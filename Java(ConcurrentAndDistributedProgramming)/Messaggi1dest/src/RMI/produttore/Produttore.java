package RMI.produttore;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

import RMI.common.DestinatarioPieno;
import RMI.common.Msg;
import RMI.common.ProduttoreMsgInterface;

public class Produttore extends Thread {

    private int id;
    private ProduttoreMsgInterface P;

    public Produttore(int id, ProduttoreMsgInterface P) {
        this.id = id;
        this.P = P;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("produttore" + id + " scrivo un mex");
                try {
                    P.send(generaMex());
                    System.out.println("produttore" + id + " messaggio inviato");
                } catch (DestinatarioPieno e) {
                    System.err.println("Destinatario pieno");
                    Thread.sleep(2000);
                }
            }
        } catch (InterruptedException | RemoteException e) {
            e.printStackTrace();
        }
    }

    private Msg generaMex() {
        Random r = new Random();
        int dest = r.nextInt(0, 5);
        String txt = "ciao da" + id;
        Msg m = new Msg(dest, txt);
        return m;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry();
        ProduttoreMsgInterface P = (ProduttoreMsgInterface) reg.lookup("gestore");
        Produttore p = new Produttore(Integer.parseInt(args[0]), P);
        p.start();
    }

}
