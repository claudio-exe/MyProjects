package RMI.server;

import esercizio1.Priority;
import RMI.common.PriorityStorage;
import esercizio1.StorageEmpty;
import esercizio1.StorageFull;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedList;

public class Storage extends UnicastRemoteObject implements PriorityStorage {

    private HashMap<Integer, LinkedList<String>> stringhe;
    private int max;

    public Storage (int max) throws RemoteException {
        super();
        this.max = max;
        stringhe = new HashMap<Integer, LinkedList<String>>();
    }
    @Override
    public synchronized void insert(String s, Priority p) throws StorageFull, RemoteException {
        if(stringhe.isEmpty() || !stringhe.containsKey(p.priority)){
            stringhe.put(p.priority,new LinkedList<String>());
            stringhe.get(p.priority).addFirst(s);
        }else{
            if(stringhe.get(p.priority).size() == max ){
                throw new StorageFull();
            }
            stringhe.get(p.priority).addFirst(s);
        }
        notifyAll();
    }

    @Override
    public synchronized String get(Priority p) throws RemoteException {
        while(stringhe.get(p.priority) == null || stringhe.get(p.priority).isEmpty()){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return (stringhe.get(p.priority).getFirst());
    }

    @Override
    public synchronized void remove(Priority p) throws StorageEmpty, RemoteException {
        if(stringhe.get(p.priority) == null || stringhe.get(p.priority).isEmpty()){
            throw new StorageEmpty();
        }
        stringhe.get(p.priority).removeLast();
        notifyAll();
    }

    @Override
    public synchronized int num(Priority p)throws RemoteException {
        if(stringhe.get(p.priority) == null || stringhe.get(p.priority).isEmpty()){
            return 0;
        }
        return (stringhe.get(p.priority).size());
    }

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.getRegistry();
        Storage s = new Storage(10);
        reg.rebind("STORAGE",s);
        System.out.println("Server ready...");
    }
}
