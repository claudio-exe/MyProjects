package esercizio2;

import esercizio1.ContoInesistente;
import esercizio1.DisponibilitaInsufficiente;
import esercizio1.IBAN;
import esercizio1.SommaNegativa;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class A extends Thread {

    private SistemaBancaInterface b;
    public IBAN ii;

    public A(SistemaBancaInterface b) throws RemoteException, NotBoundException {
        this.b = b;
    }

    public void run() {
        int tmp = 0;
        this.ii = IBAN.creaIBAN();
        System.out.println("A: " + ii.toString());
        try {
            System.out.println("A: controllo il saldo");
            tmp = b.saldo(ii);
            System.out.println("A: saldo = " + tmp);
            try {
                System.out.println("A: verso " + 100 + " €");
                b.versamento(ii, 100);
                System.out.println("A: versato " + 100 + " €");
                System.out.println("A: controllo il saldo");
                tmp = b.saldo(ii);
                System.out.println("A: saldo = " + tmp);
                System.out.println("A: trasferisco 50€ a B");
                b.trasferimento(ii, B.i,50);
                System.out.println("A: trasferimento a B completato");
                System.out.println("A: controllo il saldo");
                tmp = b.saldo(ii);
                System.out.println("A: saldo = " + tmp);
            } catch (SommaNegativa | DisponibilitaInsufficiente e) {
                throw new RuntimeException(e);
            }
        } catch (ContoInesistente | RemoteException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry();
        SistemaBancaInterface b = (SistemaBancaInterface) reg.lookup("BANCA");
        A u = new A(b);
        u.start();
    }
}
