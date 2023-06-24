package esercizio1;

public class B extends Thread{

    private SistemaBancaInterface b;
    public static IBAN i;

    public B (SistemaBancaInterface b){
        this.b = b;
    }

    public void run(){
        int tmp = 0;
        i = IBAN.creaIBAN();
        System.out.println("B: " + i.toString());
        try{
            System.out.println("B: controllo il saldo");
            tmp = b.saldo(i);
            System.out.println("B: saldo = " + tmp);
            System.out.println("B: attendo trasferimento da A");
            if(b.attendiTrasferimento(i)){
                System.out.println("B: trasferimento da A completato");
                System.out.println("B: prelevo 50€");
                try{
                    b.prelievo(i,50);
                    System.out.println("B: prelevato 50€, controllo il saldo");
                    tmp = b.saldo(i);
                    System.out.println("B: saldo = " + tmp);
                } catch (SommaNegativa e) {
                    throw new RuntimeException(e);
                } catch (DisponibilitaInsufficiente e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.err.println("B: trasferimento da A non riuscito");
            }
        } catch (ContoInesistente e) {
            throw new RuntimeException(e);
        }
    }
}
