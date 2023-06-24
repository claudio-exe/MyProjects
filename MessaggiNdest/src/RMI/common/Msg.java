package RMI.common;

import java.io.Serializable;

public class Msg implements Serializable{
    public static final long serialVersionUID = 1L;
    public int from;
    public int[] to;
    public String txt;

    public Msg(int f, int[] t, String tt) {
        from = f;
        to = t;
        txt = tt;
    }
}
