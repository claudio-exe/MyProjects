
public class Consumatore extends Thread {

    private int id;
    private GestoreMsg g;

    public Consumatore(int id, GestoreMsg g) {
        this.id = id;
        this.g = g;
    }

    public void run() {
        try {
            System.out.println("Consumatore: " + id + " Mi registro");
            g.signUp(String.valueOf(id));
            System.out.println("Consumatore: " + id + " Registrato");
            while (true) {
                try {
                    System.out.println("Consumatore: " + id + " Controllo presenza messaggi");
                    if (g.anyMsg(String.valueOf(id))) {
                        System.out.println("Sono presenti messaggi per: " + id);
                        while (g.anyMsg(String.valueOf(id))) {
                            Msg m = g.receive(String.valueOf(id));
                            System.out.println("Consumatore: " + id + " riceve il messaggio: " + m.txt);
                        }
                    } else {
                        System.out.println("Non sono presenti messaggi per: " + id);
                        Thread.sleep(4000);
                    }
                } catch (ConsumatoreSconosciuto e) {
                    System.err.println("Consumatore " + id + " sconosciuto");
                    ;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Thread.sleep(4000 + (long) Math.random() * 1000);
            }
        } catch (GiaRegistrato | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
