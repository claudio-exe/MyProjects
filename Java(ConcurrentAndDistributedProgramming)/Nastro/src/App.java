
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quanti thread vuoi avviare?");
        int th = sc.nextInt();
        System.out.println("Faccio partire " + th + " Thread...");
        Nastro nastro = new NastroImpl(100);
        for(int i = 0; i < th; i++){
            Utente u = new Utente(i,nastro);
            u.start();
        }
        sc.close();
    }
}
