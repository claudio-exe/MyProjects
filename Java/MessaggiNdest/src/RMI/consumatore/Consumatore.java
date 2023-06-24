package RMI.consumatore;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.common.ConsumatoreSconosciuto;
import RMI.common.GestoreMsgInterface;
import RMI.common.GiaRegistrato;
import RMI.common.Msg;

public class Consumatore extends Thread {

    private int id;
    private GestoreMsgInterface G;

    public Consumatore(int id, GestoreMsgInterface G) {
        this.id = id;
        this.G = G;
    }

    public void run() {
        try {
            System.out.println(id + " cons mi registro");
            G.signUp(String.valueOf(id));
            System.out.println(id + " cons registrato");
            while (true) {
                System.out.println(id + " cons controllo presenza messaggi");
                try {
                    if (G.anyMsg(String.valueOf(id))) {
                        System.out.println(id + " cons sono presenti mex, li ricevo");
                        Msg tmp = G.receive(String.valueOf(id));
                        System.out.println(id + " cons ricevuto messaggio: " + tmp.txt);
                    } else {
                        System.err.println(id + " cons non sono presenti messaggi");
                        Thread.sleep(2000);
                    }
                } catch (ConsumatoreSconosciuto e) {
                    throw new RuntimeException(e);
                }
                Thread.sleep(2000 + (long)Math.random()*1000);
            }
        } catch (InterruptedException | GiaRegistrato | RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry();
        GestoreMsgInterface G = (GestoreMsgInterface)reg.lookup("gestore");
        Consumatore c = new Consumatore(Integer.parseInt(args[0]), G);
        c.start();
    }
}
