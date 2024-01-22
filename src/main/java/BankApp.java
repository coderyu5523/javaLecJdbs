import dao.BankDAO;
import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //URL 을 통해 요청 URL 뒤에 자원명이 아니라 식별자 요청
        // PUT UPDATE 는 WRITE 요청. 요청 바디가 무조건 있어야됨. 응답 바디는 필요없다. OK만 있으면 됨.
        //GET DELETE 는 HTTP 요청에 바디가 없다.
        // http://bank.com/account GET  HTTP에 값을 받는 것. 전 계좌 정보 요청
        // http://bank.com/account/10 GET  HTTP에 값을 받는 것. 전 계좌 정보 요청 /프라이머리키
        // http://bank.com/account POST HTTP 에 값을 보내는 것. 계좌를 만들기
        // http://bank.com/account/1  DELETE  1번 계좌 삭제
        // http://bank.com/account/1  PUT  1번 계좌 수정

        // POST 와 PUT 은 반드시 데이터가 ㅣ필요함. 바디데이터 뭔가 받을 떄
        //

        //지금은 웹이 아니기 때문에 식별자만 받음

        // /acount
        // /account/1
        // /account
        // /account/1
        // /account/1
        System.out.println("메서드를 입력하세요");
        String method = sc.nextLine();
        System.out.println("식별자를 입력하세요");
        String action = sc.nextLine();

        String body = "" ;
        //라우팅
        BankDAO bankDAO = new BankDAO();
        if(method.equals("GET")){
            if(action.equals("/account")) {
               List<Account> accountList = bankDAO.selectAll();
                System.out.println(accountList);
            }else if(action.equals("/account/1")){
               Account account = bankDAO.selectByNumber(1);
                System.out.println(account);
            }

        }else if(method.equals("POST")){
            System.out.println("body 데이터를 입력하세요.");
            body = sc.nextLine();

            //password=1234&balance=1000

            String[] st1 = body.split("&");
            String password = st1[0].split("=")[1];
            int balance =   Integer.parseInt(st1[1].split("=")[1]);
            if(action.equals("/account")){
                bankDAO.insert(password,balance);
            }  // 값을 파싱해서 메서드 호출

        }else if(method.equals("PUT")){

        }else if(method.equals("DELETE")){

        }


    }
}