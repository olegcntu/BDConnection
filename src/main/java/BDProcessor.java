import java.sql.*;

public class BDProcessor {
    private Connection connection;

    public BDProcessor() {


    }

    public Connection getConnection(String url, String user, String password) throws SQLException {
        if (connection != null) {
            return connection;
        }

        connection = DriverManager.getConnection(url, user, password);
        return connection;

    }
}