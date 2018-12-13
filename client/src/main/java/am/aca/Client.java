package am.aca;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

public class Client implements Serializable {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        DbConnection dbConnection = (DbConnection) Naming.lookup("rmi://127.0.0.1/Users");
        System.out.println(dbConnection.getUsers());
    }
}
