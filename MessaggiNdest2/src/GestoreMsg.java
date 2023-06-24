
public interface GestoreMsg {
    void signUp(String id) throws GiaRegistrato;

    void send(Msg m) throws GestorePieno;

    Msg receive(String id) throws InterruptedException, ConsumatoreSconosciuto;

    boolean anyMsg(String id) throws ConsumatoreSconosciuto;

}
