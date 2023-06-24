package esercizio2;


import esercizio1.ContoInesistente;
import esercizio1.DisponibilitaInsufficiente;
import esercizio1.IBAN;
import esercizio1.SommaNegativa;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class SistemaBanca extends UnicastRemoteObject implements SistemaBancaInterface {

    public static HashMap<IBAN, Integer> conti;
    public static int iban = 11111;

    public SistemaBanca() throws RemoteException {
        super();
        this.conti = new HashMap<IBAN, Integer>();
    }
    public int saldo(IBAN idcc) throws ContoInesistente, RemoteException {
        if(!conti.containsKey(idcc)){
            throw new ContoInesistente();
        }else{
            synchronized (conti.get(idcc)){
                return conti.get(idcc);
            }
        }
    }

    public void versamento(IBAN idcc, int s) throws ContoInesistente, SommaNegativa, RemoteException {
        if(!conti.containsKey(idcc)){
            throw new ContoInesistente();
        }else if(s < 0){
            throw new SommaNegativa();
        }else{
            synchronized (conti.get(idcc)){
                int saldo = conti.get(idcc);
                conti.put(idcc,saldo+s);
            }
        }
    }

    public void prelievo(IBAN idcc, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente, RemoteException {
        if(!conti.containsKey(idcc)){
            throw new ContoInesistente();
        }else if(s < 0){
            throw new SommaNegativa();
        }else if(conti.get(idcc) < s){
            throw new DisponibilitaInsufficiente();
        }else{
            synchronized (conti.get(idcc)){
                int saldo = conti.get(idcc);
                conti.put(idcc,saldo-s);
            }
        }
    }

    public void trasferimento(IBAN idccFrom, IBAN idccTo, int s) throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente, RemoteException {
        if(!conti.containsKey(idccFrom) || !conti.containsKey(idccTo)){
            throw new ContoInesistente();
        }else if(s < 0){
            throw new SommaNegativa();
        }else if(conti.get(idccFrom) < s){
            throw new DisponibilitaInsufficiente();
        }else{
            synchronized (conti.get(idccFrom)){
                int prelievo = conti.get(idccFrom);
                conti.put(idccFrom,prelievo-s);
            }
            synchronized (conti.get(idccTo)){
                int versamento = conti.get(idccTo);
                conti.put(idccTo,versamento+s);
            }
        }
    }

    public boolean attendiTrasferimento(IBAN idcc) throws ContoInesistente, RemoteException {
        if(!conti.containsKey(idcc)){
            throw new ContoInesistente();
        }else{
            int saldo = conti.get(idcc);
            synchronized (conti.get(idcc)){
                try {
                    conti.get(idcc).wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(saldo != conti.get(idcc)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.getRegistry();
        SistemaBancaInterface b = new SistemaBanca();
        reg.rebind("BANCA",b);
        System.out.println("Server ready...");
    }
}
