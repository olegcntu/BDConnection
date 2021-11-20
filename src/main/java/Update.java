import java.sql.*;

// String st = "INSERT INTO bank (id,town) VALUES(17,'Chernigiv')";

public class Update {
    public static int update(String inquiry) {
        Connection connection = null;
        int result=-1;
        try {
            BDProcessor bdProcessor = new BDProcessor();
            connection = bdProcessor.getConnection("jdbc:postgresql://localhost:5432/Bank","postgres","123re");

            Statement stmt = connection.createStatement();


           result = stmt.executeUpdate(inquiry);

        } catch (Exception e) {
            e.printStackTrace();
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
