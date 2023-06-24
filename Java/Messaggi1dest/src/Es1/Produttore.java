package Es1;

import java.util.Random;

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
        } catch (InterruptedException e) {
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

}
