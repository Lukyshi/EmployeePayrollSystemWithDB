package Util;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
    private static  final String url = "jdbc:mysql://localhost:3306/EmployeeDB";
    private static final String root = "root";
    private static final String password = "Luiz010124";

    public static Connection getConnection (){
        try{
            return DriverManager.getConnection(url, root, password);
        }catch (SQLException e) {
            System.out.println("Database connection failed " + e.getMessage());
            return null;
        }
    }
}
