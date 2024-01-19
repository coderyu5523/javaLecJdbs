package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {
    //JUNIT 자바로 테스트할 수 있는 도구 메인이 없어도 실행시킬 수 있음.
    // 리턴타입을 못적음. void만 쓸 수 잇음
    // 매개변수를 적을 수 없음.
    //@Test 만 적으면 됨
    // build.gradle에     testImplementation platform('org.junit:junit-bom:5.9.1')
    //    testImplementation 'org.junit.jupiter:junit-jupiter'
    // 있어야 됨. 자바 gradle 로 만들면 자동 세팅 되어잇음
    @Test

    public void getInstance_test(){  //테스트코드에서는 _test 붙임
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/cosdb";

        try {
            Connection conn = DriverManager.getConnection(url,username,password); // conn  프로토콜이 적용된 소켓
            System.out.println("db connect success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
