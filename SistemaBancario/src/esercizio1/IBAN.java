package esercizio1;

import java.io.Serializable;

public class IBAN implements Serializable {
    private final static long serialVersionUID = 1L;
    private static String iban;
    public IBAN(String ib){
        iban = ib;
    }

    @Override
    public String toString() {
        return "IBAN{"+iban+"}";
    }

    public static IBAN creaIBAN(){
        synchronized (SistemaBanca.conti){
            IBAN i = new IBAN(String.valueOf(SistemaBanca.iban));
            SistemaBanca.conti.put(i,0);
            ++SistemaBanca.iban;
            return i;
        }
    }

}
