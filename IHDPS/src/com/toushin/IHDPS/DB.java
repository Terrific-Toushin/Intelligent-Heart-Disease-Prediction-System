package com.toushin.IHDPS;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ihdps", "root", "");
            return conn;
        } catch (Exception e) {
            System.out.println("Connection Error."+e.toString());
            return null;
        }
    }
}

