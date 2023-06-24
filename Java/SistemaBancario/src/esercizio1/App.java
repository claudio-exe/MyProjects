package esercizio1;


public class App 
{
    public static void main( String[] args )
    {
        SistemaBancaInterface banca = new SistemaBanca();
        A a = new A(banca);
        B b = new B(banca);
        a.start();
        b.start();
    }
}
