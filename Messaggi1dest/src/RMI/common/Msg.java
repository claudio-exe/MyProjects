package RMI.common;

import java.io.Serializable;

public class Msg implements Serializable {

    public static final long serialVersionUID = 1L;
    public int dest;
    public String txt;

    public Msg(int t, String tt) {
        dest = t;
        txt = tt;
    }
}
