package RMI.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConsumatoreMsgInterface extends Remote {
    void signUp(String id) throws GiaRegistrato, RemoteException;

    Msg receive(String id) throws InterruptedException,
            ConsumatoreSconosciuto, RemoteException;
}
