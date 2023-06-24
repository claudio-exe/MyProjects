package Es1;

import java.util.HashMap;
import java.util.LinkedList;

public class GestoreM implements ConsumatoreMsgInterface, ProduttoreMsgInterface {

    private int max;
    private HashMap<String, LinkedList<Msg>> messaggi;

    public GestoreM(int max) {
        this.max = max;
        messaggi = new HashMap<String, LinkedList<Msg>>();
    }

    @Override
    public synchronized void send(Msg m) throws DestinatarioPieno {
        String id = String.valueOf(m.dest);
        if (messaggi.get(id).size() == max) {
            throw new DestinatarioPieno();
        } else {
            messaggi.get(id).addLast(m);
        }
        notifyAll();
    }

    @Override
    public synchronized void signUp(String id) throws GiaRegistrato {
        if (messaggi.containsKey(id)) {
            throw new GiaRegistrato();
        } else {
            messaggi.put(id, new LinkedList<Msg>());
        }
    }

    @Override
    public synchronized Msg receive(String id) throws InterruptedException, ConsumatoreSconosciuto {
        if (!messaggi.containsKey(id))
            throw new ConsumatoreSconosciuto();
        while (messaggi.get(id).isEmpty()) {
            wait();
        }
        Msg m = messaggi.get(id).getFirst();
        messaggi.get(id).remove(m);
        return m;
    }

}
