package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getInstance(){   // Connection은 소켓
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb";

        try {
            Connection conn = DriverManager.getConnection(url,username,password); // conn  프로토콜이 적용된 소켓
            System.out.println("db connect success");
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
