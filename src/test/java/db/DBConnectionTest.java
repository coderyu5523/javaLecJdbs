package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {
    @Test
    public void getInstance_test(){  //테스트코드에서는 _test 붙임
        //given  = 파라미터

        //when  =  본코드를 실행
        Connection conn = DBConnection.getInstance();

        //then = 검증
        if(conn==null){
            System.out.println("실패");
        }else {
            System.out.println("성공");
        }

    }
}
