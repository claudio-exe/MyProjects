package RMI.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.LinkedList;

import RMI.common.ConsumatoreMsgInterface;
import RMI.common.ConsumatoreSconosciuto;
import RMI.common.DestinatarioPieno;
import RMI.common.GiaRegistrato;
import RMI.common.Msg;
import RMI.common.ProduttoreMsgInterface;

public class GestoreM extends UnicastRemoteObject implements ConsumatoreMsgInterface, ProduttoreMsgInterface {

    private int max;
    private HashMap<String, LinkedList<Msg>> messaggi;

    public GestoreM(int max) throws RemoteException {
        super();
        this.max = max;
        messaggi = new HashMap<String, LinkedList<Msg>>();
    }

    @Override
    public synchronized void send(Msg m) throws DestinatarioPieno, RemoteException {
        String id = String.valueOf(m.dest);
        if (messaggi.get(id).size() == max) {
            throw new DestinatarioPieno();
        } else {
            messaggi.get(id).addLast(m);
        }
        notifyAll();
    }

    @Override
    public synchronized void signUp(String id) throws GiaRegistrato, RemoteException {
        if (messaggi.containsKey(id)) {
            throw new GiaRegistrato();
        } else {
            messaggi.put(id, new LinkedList<Msg>());
        }
    }

    @Override
    public synchronized Msg receive(String id) throws InterruptedException, ConsumatoreSconosciuto, RemoteException {
        if (!messaggi.containsKey(id))
            throw new ConsumatoreSconosciuto();
        while (messaggi.get(id).isEmpty()) {
            wait();
        }
        Msg m = messaggi.get(id).getFirst();
        messaggi.get(id).remove(m);
        return m;
    }

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.getRegistry();
        GestoreM gest = new GestoreM(Integer.parseInt(args[0]));
        reg.rebind("gestore", gest);
        System.out.println("server ready...");
    }
}
