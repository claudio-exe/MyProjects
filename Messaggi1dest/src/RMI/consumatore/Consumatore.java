package RMI.consumatore;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMI.common.ConsumatoreMsgInterface;
import RMI.common.ConsumatoreSconosciuto;
import RMI.common.GiaRegistrato;
import RMI.common.Msg;

public class Consumatore extends Thread {

    private int id;
    private ConsumatoreMsgInterface C;

    public Consumatore(int id) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry();
        C = (ConsumatoreMsgInterface) reg.lookup("gestore");
        this.id = id;
    }

    public void run() {
        String ID = String.valueOf(id);
        try {
            System.out.println("consumatore" + id + " mi registro");
            C.signUp(ID);
            System.out.println("consumatore" + id + " registrato");
            Msg m = null;
            while (true) {
                System.out.println("consumatore" + id + " ricevo messaggi");
                m = C.receive(ID);
                System.out.println("consumatore" + id + " ricevuto messaggio " + m.txt);
            }
        } catch (InterruptedException | GiaRegistrato | ConsumatoreSconosciuto | RemoteException e) {
            e.printStackTrace();
        }
    }
}
