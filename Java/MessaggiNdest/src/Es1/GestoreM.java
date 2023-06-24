package Es1;

import java.util.LinkedList;

public class GestoreM implements GestoreMsgInterface {

    private LinkedList<String> registrati;
    private LinkedList<Msg> mex;
    private int max;

    public GestoreM(int max) {
        this.max = max;
        mex = new LinkedList<Msg>();
        registrati = new LinkedList<String>();
    }

    public synchronized void signUp(String id) throws GiaRegistrato {
        if (registrati.isEmpty() || !registrati.contains(id)) {
            registrati.add(id);
        } else {
            throw new GiaRegistrato();
        }
    }

    public synchronized void send(Msg m) throws GestorePieno {
        if (mex.size() < max) {
            mex.addLast(m);
        } else {
            throw new GestorePieno();
        }
        notifyAll();
    }

    public synchronized Msg receive(String id) throws InterruptedException, ConsumatoreSconosciuto {
        if (!registrati.contains(id)) {
            throw new ConsumatoreSconosciuto();
        }
        Msg tmp = controllaMex(id);
        while (tmp == null) {
            wait();
            tmp = controllaMex(id);
        }
        if (tmp.to.length == 1) {
            mex.remove(tmp);
        } else {
            int[] dest = new int[tmp.to.length - 1];
            int j = 0;
            for (int i : tmp.to) {
                if (i != Integer.parseInt(id)) {
                    dest[j] = i;
                    j++;
                }
            }
            Msg m = new Msg(tmp.from, dest, tmp.txt);
            mex.remove(tmp);
            mex.add(m);
        }
        return tmp;
    }

    public synchronized boolean anyMsg(String id) throws ConsumatoreSconosciuto {
        if (!registrati.contains(id)) {
            throw new ConsumatoreSconosciuto();
        }
        return (controllaMex(id) != null);
    }

    private Msg controllaMex(String id) {
        for (Msg m : mex) {
            for (int i : m.to) {
                if (i == Integer.parseInt(id)) {
                    return m;
                }
            }
        }
        return null;
    }
}
