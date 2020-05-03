package jdbctests;

import java.sql.*;

public class practice_1 {
    public static void main(String[] args) throws SQLException {

        // connection string
        String dbUrl = "jdbc:oracle:thin:@54.145.112.194:1521:xe";
        String dbUsername = "HR";
        String dbPassword = "HR";

        // create connection to database
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        // create statement object
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from employees");
        //move pointer to next row;



        while (resultSet.next()){
        System.out.println(resultSet.getString(2)+"-"+resultSet.getString(3)

                +"-"+resultSet.getInt("salary"));
    }
    //close connection
        resultSet.close();
        statement.close();
        connection.close();


}
}
