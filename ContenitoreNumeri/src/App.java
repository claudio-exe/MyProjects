public class App {
    public static void main(String[] args) throws Exception {
        Contenitore c = new ContenitoreImpl(5);
        demone d = new demone(c);
        d.setDaemon(true);
        d.start();
        for(int i = 0; i < 3; i++){
            Utente u = new Utente(i,c);
            u.start();
        }
    }

}
