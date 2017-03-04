package WEB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dreawalker on 16.02.2017.
 */
public class MyDataBaseConnection {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/helenscake?useSSL=" +
            "false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "DEMOTOoth2017@";
    public static void main(String[] args) {
        Connection connection = getConnectionToDB();
        String sql = "CREATE TABLE IF NOT EXISTS " +
                "ingredients (" +
                "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "filepath varchar(255) NOT NULL UNIQUE);";
        tableRequestInDB(connection, sql);

//        final String filepath = "C://Test.txt";
//        String sqlField = "INSERT INTO ingredients " +
//                "(id, filepath)" +
//                " VALUES (1, '"+filepath+"')";

//        final String filepath = "C://Test1.txt";
//        String sqlField = "INSERT INTO ingredients " +
//                "(filepath)" +
//                " VALUES ('"+filepath+"')";
//        tableRequestInDB(connection, sqlField);


        String sqlRequest1 = "UPDATE ingredients " +
                "SET filepath='C://Test8.txt' WHERE id=2;";
        try(Statement statement = connection.createStatement()) {
            int res = statement.executeUpdate(sqlRequest1);
            System.out.println(res);
//            statement.addBatch("INSERT INTO ingredients (filepath) VALUES ('C://Test3');");
//            statement.addBatch("INSERT INTO ingredients (filepath) VALUES ('C://Test4');");
//            statement.addBatch("INSERT INTO ingredients (filepath) VALUES ('C://Test5');");
//            statement.executeBatch();
//            statement.clearBatch();
            String sqlRequest2 = "DELETE FROM ingredients WHERE id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest2);
            preparedStatement.setInt(1, 9);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sqlRequest = "SELECT * FROM ingredients";
        List<String> list = selectFromTableInDB(connection, sqlRequest);
        System.out.println(list);

        try {
            if(!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnectionToDB() {
        try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected!");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connection failed!");
        return null;
    }

    private static void tableRequestInDB(Connection connection, String sqlRequest) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<String> selectFromTableInDB(Connection connection, String sqlField) {
        List<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlField);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                list.add(resultSet.getString("id"));
                list.add(resultSet.getString("filepath"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
