package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    public DatabaseConnection() {
    }

    /*public void GetConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://xamarindbinstance.cgz3euuxgt6b.us-east-2.rds.amazonaws.com/aulavirtual?useUnicode=true&characterEncoding=UTF-8&user=admin&password=admin987";
        Connection conn = DriverManager.getConnection(connectionUrl);
        ResultSet rs = conn.prepareStatement("show tables").executeQuery();

        while (rs.next()) {
            String s = rs.getString(1);
            System.out.println(s);
        }
    }*/

    public Connection GetConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connectionUrl = "jdbc:mysql://xamarindbinstance.cgz3euuxgt6b.us-east-2.rds.amazonaws.com/aulavirtual?useUnicode=true&characterEncoding=UTF-8&user=admin&password=admin987";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

