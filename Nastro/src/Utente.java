

import java.util.Random;

public class Utente extends Thread {

    private Nastro N;
    private int id;

    public Utente(int id, Nastro n) {
        this.id = id;
        N = n;
    }

    public void run() {
        try {
            while (true) {
                Random rg = new Random();
                String tmp = "";
                int scelta = rg.nextInt(0, 4);
                switch (scelta) {
                    case 0:
                        try {
                            System.out.println("Utente" + id + " scrivo");
                            N.write("fanculo");
                            System.out.println("Utente" + id + " stringa scritta: fanculo");
                        } catch (noWrite e) {
                            System.err.println("scrittura negata a: Utente" + id);
                            Thread.sleep(2000);
                        }
                        break;
                    case 1:
                        try {
                            System.out.println("Utente" + id + " leggo");
                            tmp = N.read();
                            System.out.println("Utente" + id + " ho letto: " + tmp);
                        } catch (noRead e) {
                            System.err.println("posizione corrente del nastro vuota Utente" + id);
                            Thread.sleep(2000);
                        }
                        break;
                    case 2:
                        System.out.println("Utente" + id + " riavvolgo il nastro");
                        N.rewind();
                        System.out.println("Utente" + id + " nastro riavvolto");
                        break;
                    default:
                        System.out.println("Utente" + id + " controllo se il nastro è vuoto");
                        if(N.empty()){
                            System.out.println("Utente" + id + " il nastro è vuoto");
                        }else{
                            System.out.println("Utente" + id + " il nastro non è vuoto");
                        }
                        break;
                }
                Thread.sleep(3000 + (long)Math.random()*1000);
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
