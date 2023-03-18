package base;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

    private static final  String jdbcDriver="com.mysql.cj.jdbc.Driver";
    private static final  String url="jdbc:mysql://localhost:3306/human_resource_management";
    private static final  String username="root";
    private static final  String password="999999999";

    public static Connection getConnection(){
        try {
            Class.forName(jdbcDriver);
            return DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
