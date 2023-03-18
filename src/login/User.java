package login;


import base.MySQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    public static boolean checkLogin(String username, String password){
        try {

            Connection connection = MySQLConnection.getConnection();

            Statement statement = connection.createStatement();
            String sql="SELECT * From user WHERE username = '" + username + "'  AND password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }
        return false;
    }

}
