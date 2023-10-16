
package Es1;

public class Consumatore extends Thread {

    private int id;
    private ConsumatoreMsgInterface C;

    public Consumatore(int id, ConsumatoreMsgInterface C) {
        this.id = id;
        this.C = C;
    }

    public void run() {
        String ID = String.valueOf(id);
        try {
            System.out.println("consumatore" + id + " mi registro");
            C.signUp(ID);
            System.out.println("consumatore" + id + " registrato");
            Msg m = null;
            while (true) {
                System.out.println("consumatore" + id + " ricevo messaggi");
                m = C.receive(ID);
                System.out.println("consumatore" + id + " ricevuto messaggio " + m.txt);
            }
        } catch (InterruptedException | GiaRegistrato e) {
            e.printStackTrace();
        } catch (ConsumatoreSconosciuto e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
