
import java.util.Random;

public class Automobilista extends Thread {

    private int id;
    private GestioneParcheggio gp;

    public Automobilista(int id, GestioneParcheggio gp) {
        this.id = id;
        this.gp = gp;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Automobilista " + id + " sono in coda all'entrata");
                gp.ingresso();
                System.out.println("Automobilista " + id + " sono entrato");
                int i;
                try {
                    i = 0;
                    while (true) {
                        try {
                            System.out.println("Automobilista " + id + " parcheggio al piano " + i);
                            gp.parcheggia(i);
                            System.out.println("Automobilista " + id + " ho parcheggiato al piano " + i);
                            break;
                        } catch (NoStalliLiberi | PianoInesistente e) {
                            if (e instanceof PianoInesistente) {
                                System.err.println("Automobilista " + id + " ultimo piano occupato, torno giù");
                                i = 0;
                            } else {
                                System.err.println(
                                        "Automobilista " + id + " piano " + i + " occupato, controllo il successivo");
                                i++;
                            }
                        }
                    }
                    Thread.sleep(1000 + (long) Math.random() * 15000);
                    System.out.println("Automobilista " + id + " parto dal piano " + i);
                    gp.partenza(i);
                    System.out.println("Automobilista " + id + " esco");
                    gp.uscita();
                    System.out.println("Automobilista " + id + " uscito dal parcheggio");
                } catch (PianoInesistente e) {
                    e.printStackTrace();
                }
                Thread.sleep(2000 + (long) Math.random() * 10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
