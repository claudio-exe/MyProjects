package RMI.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

import RMI.common.ConsumatoreSconosciuto;
import RMI.common.GestoreMsgInterface;
import RMI.common.GestorePieno;
import RMI.common.GiaRegistrato;
import RMI.common.Msg;

public class GestoreM extends UnicastRemoteObject implements GestoreMsgInterface {

    private LinkedList<String> registrati;
    private LinkedList<Msg> mex;
    private int max;

    public GestoreM(int max) throws RemoteException {
        super();
        this.max = max;
        mex = new LinkedList<Msg>();
        registrati = new LinkedList<String>();
    }

    public synchronized void signUp(String id) throws GiaRegistrato, RemoteException {
        if (registrati.isEmpty() || !registrati.contains(id)) {
            registrati.add(id);
        } else {
            throw new GiaRegistrato();
        }
    }

    public synchronized void send(Msg m) throws GestorePieno, RemoteException  {
        if (mex.size() < max) {
            mex.addLast(m);
        } else {
            throw new GestorePieno();
        }
        notifyAll();
    }

    public synchronized Msg receive(String id) throws InterruptedException, ConsumatoreSconosciuto, RemoteException  {
        if (!registrati.contains(id)) {
            throw new ConsumatoreSconosciuto();
        }
        Msg tmp = controllaMex(id);
        while (tmp == null) {
            wait();
            tmp = controllaMex(id);
        }
        // controllo ed eliminazione messaggi
        if (tmp.to.length == 1) {
            mex.remove(tmp);
        } else {
            // elimino dal messaggio il destinatario che ha letto il messaggio
            int[] dest = new int[tmp.to.length - 1];
            int j = 0;
            for (int i : tmp.to) {
                if (i != Integer.parseInt(id)) {
                    dest[j] = i;
                    j++;
                }
            }
            Msg m = new Msg(tmp.from, dest, tmp.txt);
            mex.remove(tmp);
            mex.add(m);
        }
        return tmp;
    }

    public synchronized boolean anyMsg(String id) throws ConsumatoreSconosciuto, RemoteException  {
        if (!registrati.contains(id)) {
            throw new ConsumatoreSconosciuto();
        }
        return (controllaMex(id) != null);
    }

    private Msg controllaMex(String id) {
        for (Msg m : mex) {
            for (int i : m.to) {
                if (i == Integer.parseInt(id)) {
                    return m;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.getRegistry();
        GestoreM g = new GestoreM(Integer.parseInt(args[0]));
        reg.rebind("gestore", g);
        System.out.println("server ready...");
    }
}
