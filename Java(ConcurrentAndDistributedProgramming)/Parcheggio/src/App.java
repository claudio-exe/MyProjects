
public class App {
    public static void main(String[] args) {
        GestioneParcheggio gp = new GPImpl(3, 5);
        for (int i = 0; i < 20; i++) {
            Automobilista a = new Automobilista(i, gp);
            a.start();
        }
        ;
    }
}
