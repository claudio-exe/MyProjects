package RMI.client;

import RMI.common.PriorityStorage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry reg = LocateRegistry.getRegistry();
        PriorityStorage P = (PriorityStorage)reg.lookup("STORAGE");
        for(int i = 0; i < 5; i++){
            Utente u = new Utente(i,P);
            u.start();
        }

    }
}