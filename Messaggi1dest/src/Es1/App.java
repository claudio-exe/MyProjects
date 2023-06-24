
package Es1;

public class App {
    public static void main(String[] args) throws Exception {

        GestoreM G = new GestoreM(10);
        ConsumatoreMsgInterface C = G;
        ProduttoreMsgInterface P = G;
        for (int i = 0; i < 5; i++) {
            Consumatore c = new Consumatore(i, C);
            c.start();
        }
        Produttore p = new Produttore(10, P);
        p.start();
    }
}
