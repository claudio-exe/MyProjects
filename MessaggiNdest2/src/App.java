
public class App {
    private static GestoreMsg g;

    public static void main(String[] args) {
        g = new GestoreM(10);
        for (int i = 0; i < 5; i++) {
            Produttore p = new Produttore(i, g);
            p.start();
            Consumatore c = new Consumatore(i, g);
            c.start();
        }
    }
}
