public class demone extends Thread{

    private Contenitore c;

    public demone (Contenitore c){
        this.c = c;
    }

    public void run(){
        try{
            while(true){
                int hash = c.hashCode();
                Thread.sleep(6000);
                if(hash == c.hashCode()){
                    System.out.println("DEADLOCK");
                    c.cancella();
                    c.inserisci(1);
                    System.out.println("DEADLOCK SBLOCCATO");
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
