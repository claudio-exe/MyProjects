package esercizio1;

import java.util.HashMap;
import java.util.LinkedList;

public class Storage implements PriorityStorage{

    private HashMap<Integer, LinkedList<String>> stringhe;
    private int max;

    public Storage (int max){
        this.max = max;
        stringhe = new HashMap<Integer, LinkedList<String>>();
    }
    @Override
    public synchronized void insert(String s, Priority p) throws StorageFull {
        if(stringhe.isEmpty() || !stringhe.containsKey(p.priority)){
            stringhe.put(p.priority,new LinkedList<String>());
            stringhe.get(p.priority).addFirst(s);
        }else{
            if(stringhe.get(p.priority).size() == max ){
                throw new StorageFull();
            }
            stringhe.get(p.priority).addFirst(s);
        }
        notifyAll();
    }

    @Override
    public synchronized String get(Priority p) {
        while(stringhe.get(p.priority) == null || stringhe.get(p.priority).isEmpty()){
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return (stringhe.get(p.priority).getFirst());
    }

    @Override
    public synchronized void remove(Priority p) throws StorageEmpty {
        if(stringhe.get(p.priority) == null || stringhe.get(p.priority).isEmpty()){
            throw new StorageEmpty();
        }
        stringhe.get(p.priority).removeLast();
        notifyAll();
    }

    @Override
    public synchronized int num(Priority p) {
        if(stringhe.get(p.priority) == null || stringhe.get(p.priority).isEmpty()){
            return 0;
        }
        return (stringhe.get(p.priority).size());
    }
}
