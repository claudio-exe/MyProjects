package Es1;

public class App {
    public static void main(String[] args) {
        GestoreMsgInterface G = new GestoreM(20);
        for (int i = 0; i < 5; i++) {
            Produttore p = new Produttore(i, G);
            p.start();
            Consumatore c = new Consumatore(i, G);
            c.start();
        }
    }
}
