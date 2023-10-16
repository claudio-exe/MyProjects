package esercizio1;

import java.io.Serializable;

public class Priority implements Serializable {

    public static final long serialVersionUID = 1L;
    public int priority;

    public Priority(int priority){
        this.priority = priority;
    }
}
