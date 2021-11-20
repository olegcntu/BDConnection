import java.sql.*;

public class BDProcessor {
    private Connection connection;

    public BDProcessor() {

        try { // load the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) { // problem loading driver,
            // class not exist?
            e.printStackTrace();
        }
    }

    public Connection getConnection(String url, String user, String password) throws SQLException {
        if (connection != null) {
            return connection;
        }

        connection = DriverManager.getConnection(url, user, password);
        return connection;

    }
}