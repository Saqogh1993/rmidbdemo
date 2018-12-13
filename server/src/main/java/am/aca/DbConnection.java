package am.aca;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DbConnection extends Remote {
    List<Userr> getUsers() throws RemoteException;
}
