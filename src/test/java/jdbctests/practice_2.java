package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;

public class practice_2 {

        String dbUrl = "jdbc:oracle:thin:@54.145.112.194:1521:xe";
        String dbUsername = "HR";
        String dbPassword = "HR";

        @Test
        public void test11() throws SQLException {


            // create connection to database
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            // create statement object
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select region_name from regions");

            while(resultSet.next()){
                String regionName = resultSet.getString("region_name");
                System.out.println(regionName);
            }


            resultSet = statement.executeQuery("Select * from countries");
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }


        }
        @Test
    public void test13() throws SQLException{
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from departments");




        }
    }


