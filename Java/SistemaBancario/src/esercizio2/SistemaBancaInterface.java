package esercizio2;

import esercizio1.ContoInesistente;
import esercizio1.DisponibilitaInsufficiente;
import esercizio1.IBAN;
import esercizio1.SommaNegativa;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SistemaBancaInterface extends Remote {
    int saldo(IBAN idcc) throws ContoInesistente, RemoteException;
    void versamento(IBAN idcc, int s)
            throws ContoInesistente, SommaNegativa, RemoteException;
    void prelievo(IBAN idcc, int s)
            throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente, RemoteException;
    void trasferimento(IBAN idccFrom, IBAN idccTo, int s)
            throws DisponibilitaInsufficiente, SommaNegativa, ContoInesistente, RemoteException;
    boolean attendiTrasferimento(IBAN idcc) throws ContoInesistente,RemoteException;
}
