
import java.util.Random;

public class Produttore extends Thread {

    private int id;
    private GestoreMsg g;

    public Produttore(int id, GestoreMsg g) {
        this.id = id;
        this.g = g;
    }

    public void run() {
        Random rg = new Random();
        try {
            while (true) {
                int rand = rg.nextInt(1, 6);
                int[] cons = new int[rand];
                for (int i = 0; i < rand; i++) {
                    cons[i] = rg.nextInt(0, 5);
                }
                Msg mess = new Msg(id, cons, "ciao");
                try {
                    System.out.println("Produttore: " + id + " Invio un messaggio");
                    g.send(mess);
                    System.out.println("Produttore: " + id + " Ho inviato un messaggio");
                } catch (GestorePieno e) {
                    if (e instanceof GestorePieno) {
                        Thread.sleep(5000);
                    }
                }
                Thread.sleep(4000 + (long) Math.random() * 10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
