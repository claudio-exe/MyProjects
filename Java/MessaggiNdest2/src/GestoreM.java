
import java.util.LinkedList;

public class GestoreM implements GestoreMsg {

    private LinkedList<String> ID;
    private LinkedList<Msg> messaggi;
    private int max;

    public GestoreM(int max) {
        this.max = max;
        ID = new LinkedList<String>();
        messaggi = new LinkedList<Msg>();
    }

    public synchronized void signUp(String id) throws GiaRegistrato {
        if (ID.isEmpty()) {
            ID.add(id);
        } else if (ID.contains(id)) {
            throw new GiaRegistrato();
        } else {
            ID.add(id);
        }
    }

    public synchronized void send(Msg m) throws GestorePieno {
        if (messaggi.isEmpty() || messaggi.size() + m.to.length <= max) {
            for (int i : m.to) {
                int[] n = { i };
                Msg tmp = new Msg(m.from, n, m.txt);
                messaggi.add(tmp);
            }
        } else if (messaggi.size() == max) {
            throw new GestorePieno();
        }
        notifyAll();
    }

    public synchronized Msg receive(String id) throws InterruptedException, ConsumatoreSconosciuto {
        if (!ID.contains(id)) {
            throw new ConsumatoreSconosciuto();
        }
        Msg m = null;
        while (m == null) {
            for (Msg tmp : messaggi) {
                if (String.valueOf(tmp.to[0]).equals(id)) {
                    m = tmp;
                    messaggi.remove(tmp);
                    break;
                }
            }
            if (m == null) {
                wait();
            }
        }
        return m;
    }

    public synchronized boolean anyMsg(String id) throws ConsumatoreSconosciuto {
        if (!ID.contains(id)) {
            throw new ConsumatoreSconosciuto();
        } else {
            for (Msg tmp : messaggi) {
                if (String.valueOf(tmp.to[0]).equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

}
