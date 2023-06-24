package RMI.produttore;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

import RMI.common.GestoreMsgInterface;
import RMI.common.GestorePieno;
import RMI.common.Msg;

public class Produttore extends Thread {

    private int id;
    private GestoreMsgInterface G;

    public Produttore(int id, GestoreMsgInterface G) {
        this.id = id;
        this.G = G;
    }

    public void run() {
        try {
            while (true) {
                try {
                    System.out.println(id + " prod invio mex");
                    G.send(generaMsg());
                    System.out.println(id + " prod inviato mex");
                } catch (GestorePieno e) {
                    System.err.println("gestore pieno");
                    Thread.sleep(3000);
                }
                Thread.sleep(2000 + (long)Math.random()*1000);
            }
        } catch (InterruptedException | RemoteException e) {
            e.printStackTrace();
        }
    }

    private Msg generaMsg() {
        Random rg = new Random();
        int dest = rg.nextInt(1, 6);
        int[] d = new int[dest];
        for (int i = 0; i < d.length; i++) {
            d[i] = rg.nextInt(0, 5);
        }
        String testo = id + "ciao";
        Msg m = new Msg(id, d, testo);
        return m;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry();
        GestoreMsgInterface G = (GestoreMsgInterface)reg.lookup("gestore");
        Produttore p = new Produttore(Integer.parseInt(args[0]),G);
        p.start();
    }
}
