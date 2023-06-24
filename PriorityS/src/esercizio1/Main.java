package esercizio1;

public class Main {
    public static void main(String[] args) {

        PriorityStorage P = new Storage(10);
        for (int i = 0; i < 5; i++) {
            Utente u = new Utente(i, P);
            u.start();
        }
    
    }
}