

public class NastroImpl implements Nastro{

    private String[] N;
    private int dim;
    private int posizione;

    public NastroImpl(int dimensione){
        N = new String[dimensione];
        dim = dimensione;
        for(int i = 0; i < dim; i++){
            N[i] = null;
        }
        posizione = 0;
    }
    public synchronized void write(String s) throws noWrite {
        if(N[posizione] != null){
            throw new noWrite();
        }else{
            N[posizione] = s;
            if(posizione < dim-1){
                posizione++;
            }else{
                posizione = 0;
            }
        }
    }

    public synchronized String read() throws noRead {
        String out = "";
        if(N[posizione] == null){
           throw new noRead();
        }else{
            out = N[posizione];
            N[posizione] = null;
            if(posizione < dim-1){
                posizione++;
            }else{
                posizione = 0;
            }
        }
        return out;
    }

    public synchronized void rewind() {
        if(!empty()){
            posizione = 0;
        }
    }

    public synchronized boolean empty() {
        for(int i = 0; i < dim; i++){
            if(N[i] != null){
                return false;
            }
        }
        return true;
    }
}
