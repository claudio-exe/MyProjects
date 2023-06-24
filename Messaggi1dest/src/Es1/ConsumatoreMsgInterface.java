
package Es1;

public interface ConsumatoreMsgInterface {
    void signUp(String id) throws GiaRegistrato;

    Msg receive(String id) throws InterruptedException,
            ConsumatoreSconosciuto;
}
