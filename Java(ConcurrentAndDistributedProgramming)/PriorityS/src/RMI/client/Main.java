package RMI.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        for(int i = 0; i < 5; i++){
            Utente u = new Utente(i);
            u.start();
        }

    }
}