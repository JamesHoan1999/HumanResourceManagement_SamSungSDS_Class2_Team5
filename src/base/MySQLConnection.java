package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLConnection {

    private static final  String jdbcDriver="com.mysql.cj.jdbc.Driver";
    private static final  String url="jdbc:mysql://localhost:3306/human_resource_management";
    private static final  String username="root";
    private static final  String password="root";

    public static Connection getConnection(){
        try {
            Class. forName(jdbcDriver);
            return DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


        public static Statement  getStatement(){
        try {
            Class.forName(jdbcDriver);
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            return statement;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }





}
