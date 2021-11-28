

import java.sql.*;


public class Query {
    public static final String JDBC_POSTGRESQL_LOCALHOST_5432_BANK = "jdbc:postgresql://localhost:5432/Bank";
    public static final String RE = "123re";


    public static String read(String inquiry) {
        String result;

        try {
            BDProcessor bdProcessor = new BDProcessor();
            try (Connection connection = bdProcessor.getConnection(JDBC_POSTGRESQL_LOCALHOST_5432_BANK, System.getenv("login"), System.getenv("password"))) {

                try (Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

                    try (ResultSet rs = stmt.executeQuery(inquiry)) {
                        rs.afterLast();
                        result = Result(rs).toString();//запрос на вывод
                    }
                }
            }

        } catch (Exception e) {
            result = e.toString();
            return result;
        }
        return result;
    }


    private static StringBuilder Result(ResultSet rs) throws SQLException {
        StringBuilder res = new StringBuilder();

        while (rs.previous()) {
            int columns = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columns; i++) {
                res.append(rs.getObject(i)).append(" ");
            }
            res.append("\n");
        }
        return res;
    }


}


