import java.sql.*;

public class Update {
    public static String update(String inquiry) {
        Connection connection = null;
        String result;
        try {
            BDProcessor bdProcessor = new BDProcessor();
            connection = bdProcessor.getConnection("jdbc:postgresql://localhost:5432/Bank", "postgres", "123re");

            Statement stmt = connection.createStatement();


            result = Integer.toString(stmt.executeUpdate(inquiry));

        } catch (Exception e) {
            result = e.toString();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
