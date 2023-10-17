package pacco;


public class App {
    
    public static void main(String[] args) {
    
        String s1 = "abcdef";
        int i = 4;
        s1 = s1.substring(0,i) + s1.substring((i + 2),s1.length());
        System.out.println(s1);
        String s = "RWRyzHBWZY3DQDZdidyaU pboIoKW1J3Bwi068eVTe3aOxbE23ypkspoRa9hbmGO292o7vvDlofLkm0pTq6BYe7kQq1xGnPVs58yhhO3R666KtV8n6 T83uT Vsucy";
        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
        int j = 0;
        int count = 0;
        String ss = "";
        System.out.println("Stringa: " + s);
        do{
            String tmp = s.replace(Character.toString(alfabeto.charAt(j)),"");
            if(!tmp.equals(s)){
                count++;
                ss += Character.toString(alfabeto.charAt(j));
            }
            s = tmp;
            j++;
        }while(s.length() > 0);
        System.out.println("Simboli trovati: " + ss);
        System.out.println("Numero di simboli: " + count);
        String cazzo = "a\nb\"#";
        System.out.println(cazzo.indexOf("\\"));
        System.out.println(cazzo.contains("\\"));
    }

}
