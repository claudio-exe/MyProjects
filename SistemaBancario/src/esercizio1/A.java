package esercizio1;

public class A extends Thread {

    private SistemaBancaInterface b;
    public IBAN ii;

    public A(SistemaBancaInterface b) {
        this.b = b;
    }

    public void run() {
        int tmp = 0;
        ii = IBAN.creaIBAN();
        System.out.println("A: " + ii.toString());
        try {
            System.out.println("A: controllo il saldo");
            tmp = b.saldo(ii);
            System.out.println("A: saldo = " + tmp);
            try {
                System.out.println("A: verso " + 100);
                b.versamento(ii, 100);
                System.out.println("A: versato " + 100);
                System.out.println("A: controllo il saldo");
                tmp = b.saldo(ii);
                System.out.println("A: saldo = " + tmp);
                System.out.println("A: trasferisco 50 a B");
                b.trasferimento(ii,B.i,50);
                System.out.println("A: trasferimento a B completato");
                System.out.println("A: controllo il saldo");
                tmp = b.saldo(ii);
                System.out.println("A: saldo = " + tmp);
            } catch (SommaNegativa | DisponibilitaInsufficiente e) {
                throw new RuntimeException(e);
            }
        } catch (ContoInesistente e) {
            throw new RuntimeException(e);
        }

    }
}
