package RMI.client;

import esercizio1.Priority;
import RMI.common.PriorityStorage;
import esercizio1.StorageEmpty;
import esercizio1.StorageFull;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class Utente extends Thread{

    private int id;
    private PriorityStorage p;
    private Random r = new Random();

    public Utente(int id) throws RemoteException, NotBoundException{
        Registry reg = LocateRegistry.getRegistry();
        p = (PriorityStorage)reg.lookup("STORAGE");
        this.id = id;
    }

    public void run(){
        try{
            while(true){
                int op = r.nextInt(0,4);
                String s = "ciaoDa"+id;
                Priority pr = new Priority(0);
                switch(op){
                    case 0:
                        try{
                            pr = generaPriorita();
                            System.out.println("Utente " + id + " inserisco stringa con priorità " + pr.priority);
                            p.insert(s,pr);
                            System.out.println("Utente " + id + " stringa inserita");
                        } catch (StorageFull e) {
                            System.err.println("Storage full");
                        }
                        break;
                    case 1:
                        pr = generaPriorita();
                        String tmp = "";
                        System.out.println("Utente " + id + " ottengo stringa con priorità " + pr.priority);
                        tmp = p.get(pr);
                        System.out.println("Utente " + id + " stringa ottenuta: " + tmp);
                        break;
                    case 2:
                        try{
                            pr = generaPriorita();
                            System.out.println("Utente "+ id + " rimuovo stringa con priorità " + pr.priority);
                            p.remove(pr);
                            System.out.println("Utente " + id + " stringa rimossa");
                        } catch (StorageEmpty e) {
                            System.err.println("Storage Empty for priority: " + pr.priority);
                        }
                        break;
                    case 3:
                        pr = generaPriorita();
                        System.out.println("Utente " + id + " controllo n stringhe con priorità " + pr.priority);
                        System.out.println("Utente " + id + " stringhe con priorità " + pr.priority + " = " + p.num(pr));
                        break;
                }
                Thread.sleep(2000+(long)Math.random()*4000);
            }
        }catch(InterruptedException | RemoteException e){
            e.printStackTrace();
        }
    }

    private Priority generaPriorita(){
        int priority = r.nextInt(1,6);
        Priority pr = new Priority(priority);
        return pr;
    }
}
