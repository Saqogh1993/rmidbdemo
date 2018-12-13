package am.aca;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHelper extends UnicastRemoteObject implements DbConnection {

    private static final String IP = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String NAME = "test";

    private static final Connection CONNECTION = getConnection();

    protected DbHelper() throws RemoteException {
    }

    private static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://" + IP + ":" + PORT + "/" + NAME,
                                                                "postgres",
                                                                "2505");
            System.out.println("Connection is successful");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Userr> getUsers() throws RemoteException {
        String sql = "select * from users";
        List<Userr> list = new ArrayList();

        try {
            Statement statement = CONNECTION.createStatement();
            statement.execute(sql);

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fName = resultSet.getString(2);
                String lName = resultSet.getString(3);
                int balance  = resultSet.getInt(4);

                list.add(new Userr(id,fName,lName,balance));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
