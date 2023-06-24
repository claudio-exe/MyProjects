package RMI.consumatore;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Prova {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        for(int i = 0; i < 5; i++){
           Consumatore c = new Consumatore(i);
        c.start(); 
        }
    }
}
