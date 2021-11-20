

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    //String st1 = "SELECT * FROM bank";

public class Query {
    public static String read(String inquiry) {
        Connection connection = null;
        String result = null;

        try {
            BDProcessor bdProcessor = new BDProcessor();
            connection = bdProcessor.getConnection("jdbc:postgresql://localhost:5432/Bank", "postgres", "123re");

            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


            ResultSet rs;
            rs = stmt.executeQuery(inquiry);
            rs.afterLast();


            result=Result(rs).toString();//запрос на вывод

            stmt.close();
            connection.close();

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





    private static StringBuilder Result(ResultSet rs) throws SQLException {
        StringBuilder res = new StringBuilder();

        while (rs.previous()) {
            int columns = rs.getMetaData().getColumnCount();
            for(int i=1;i<=columns;i++) {
                res.append(rs.getObject(i) + " ");
            }
            res.append("\n");
        }
        return res;
    }



}


