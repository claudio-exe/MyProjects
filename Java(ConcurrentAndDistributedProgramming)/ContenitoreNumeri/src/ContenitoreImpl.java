import java.util.LinkedList;

public class ContenitoreImpl implements Contenitore{

    private LinkedList<Integer> contenitore;
    private int max;

    public ContenitoreImpl (int max){
        this.max = max;
        contenitore = new LinkedList<Integer>();
    }

    @Override
    public synchronized void inserisci(int n) {
       while(contenitore.size() == max){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
       }
       contenitore.addLast(n);
       notifyAll(); 
    }

    @Override
    public synchronized int somma() {
       while(contenitore.isEmpty()){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
       }
       int somma = 0;
       for(Integer n : contenitore){
            somma+=n;
       }
       return somma;
    }

    @Override
    public synchronized void cancella() {
        contenitore.clear();
    }
    
}
