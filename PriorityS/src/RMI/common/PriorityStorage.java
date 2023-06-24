package RMI.common;

import esercizio1.Priority;
import esercizio1.StorageEmpty;
import esercizio1.StorageFull;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PriorityStorage extends Remote {
    void insert(String s, Priority p) throws StorageFull, RemoteException;
    String get(Priority p) throws RemoteException;
    void remove(Priority p) throws StorageEmpty, RemoteException;
    int num(Priority p) throws RemoteException;
}
