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
            System.out.println("DB 연결");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();  //  e.printStackTrace() 는 어디서 오류가 났는지 리스트가 뜸
        }
        return null ;  // 정상적으로 연결되면 값이 있고, 연결안되어있으면 값이 null
    }
}
