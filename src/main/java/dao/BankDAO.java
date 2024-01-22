package dao;

// DAO / Data Access Object
// SRP - 단일책임의 원칙/ 하나의 클래스는 하나의 책임을 갖는다.


import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankDAO {

    public int deleteByNumber(int number) {  // 파라미터가 없으면 재사용 불가능함.
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "delete from account_tb where number = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            int num = pstmt.executeUpdate();  // flush 코드
            return num;
        } catch (Exception e) {
            e.printStackTrace();  //throw new RuntimeException(e); 이거는 오류를 메인에 던짐

        }
        return -1;  // 오류값을
    }

    public int insert(String password, int balance) {

        Connection conn = DBConnection.getInstance();
        try {
            String sql = "insert into account_tb(password,balance,created_at) values(?,?,now())";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setInt(2, balance);
            int num = pstmt.executeUpdate();  // flush 코드
            return num;
        } catch (Exception e) {
            e.printStackTrace();  //throw new RuntimeException(e); 이거는 오류를 메인에 던짐

        }
        return -1;  // 오류값을
    }

    public Account selectByNumber(int number){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            ResultSet rs = pstmt.executeQuery();

            boolean isRow = rs.next(); // 커서 한칸 내리기

            if(isRow){
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                return account;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> selectAll(){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb order by number desc";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            List<Account> accountList = new ArrayList<>();
            while(rs.next()){
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                accountList.add(account);
            }
            return accountList;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    }



