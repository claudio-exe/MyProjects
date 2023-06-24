import java.util.Random;

public class Utente extends Thread {

    private int id;
    private Contenitore c;

    public Utente(int id, Contenitore c) {
        this.id = id;
        this.c = c;
    }

    public void run() {
        try {
            Random r = new Random();
            while (true) {
                int op = r.nextInt(1,10);
                switch (op) {
                    case 1,2,3:
                        int ins = r.nextInt(1, 90);
                        System.out.println(id + " inserisco " + ins);
                        c.inserisci(ins);
                        System.out.println(id + " inserito " + ins);
                        break;
                    case 4:
                        System.out.println(id+" sommo");
                        System.out.println(id+" somma = "+c.somma());
                        break;
                    case 5,6:
                        System.out.println(id+" cancello");
                        c.cancella();
                        System.out.println(id+" ho cancellato");
                        break;
                }
                Thread.sleep((long) Math.random() * 2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
