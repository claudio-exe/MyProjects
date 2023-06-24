
import java.util.HashMap;

public class GPImpl implements GestioneParcheggio{

    private HashMap<Integer, boolean[]> parcheggio;
    private int piani;
    private int posti;
    private int postiLiberi;

    public GPImpl(int piani, int posti){
        this.piani = piani;
        this.posti = posti;
        this.postiLiberi = piani*posti;
        parcheggio = new HashMap<Integer, boolean[]>();
        for (int i = 0; i < piani; i++) {
            boolean[] b = new boolean[posti];
            for (int j = 0; j < posti; j++) {
                b[j] = true;
            }
            parcheggio.put(i, b);
        }
    }

    @Override
    public synchronized void ingresso() throws InterruptedException {
        while(postiLiberi == 0){
            wait();
        }
        postiLiberi--;
    }

    @Override
    public synchronized void uscita() {
        postiLiberi++;
        notifyAll();
    }

    @Override
    public synchronized void parcheggia(int piano) throws PianoInesistente, NoStalliLiberi {
        if(!parcheggio.containsKey(piano)){
            throw new PianoInesistente();
        }else if (stalliLiberi(piano) == 0){
            throw new NoStalliLiberi();
        }else{
            int i = 0;
            for(boolean b : parcheggio.get(piano)){
                if(b == true){
                    parcheggio.get(piano)[i] = false;
                    break;
                }
                i++;
            }
        }
    }

    @Override
    public synchronized void partenza(int piano) throws PianoInesistente {
        if(!parcheggio.containsKey(piano)){
            throw new PianoInesistente();
        }else{
            int i = 0;
            for(boolean b: parcheggio.get(piano)){
                if(b == false){
                    parcheggio.get(piano)[i] = true;
                    break;
                }
                i++;
            }
        }
    }

    @Override
    public synchronized int postiLiberi() {
        int liberi = 0;
        for(int i = 0; i < parcheggio.size(); i++){
            for(boolean b : parcheggio.get(i)){
                if(b == true){
                    liberi++;
                }
            }
        }
        return liberi;
    }

    @Override
    public synchronized int stalliLiberi(int piano) throws PianoInesistente {
        if(!parcheggio.containsKey(piano)){
            throw new PianoInesistente();
        }else{
            int stalli = 0;
            for(boolean b : parcheggio.get(piano)){
                if(b == true){
                    stalli++;
                }
            }
            return stalli;
        }
    }
}
