package RMI.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GestoreMsgInterface extends Remote{

    void signUp(String id) throws GiaRegistrato, RemoteException;

    void send(Msg m) throws GestorePieno, RemoteException;

    Msg receive(String id) throws InterruptedException,
            ConsumatoreSconosciuto, RemoteException;

    boolean anyMsg(String id) throws ConsumatoreSconosciuto, RemoteException;
}
