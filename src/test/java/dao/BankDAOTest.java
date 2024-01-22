package dao;

import model.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankDAOTest {
    @Test
    public void selectAll_Test(){
        //given

        //when
        BankDAO dao =new BankDAO();
        List<Account> accountList = dao.selectAll();

        System.out.println(accountList.size());
        System.out.println(accountList);
    }



    @Test
    public void seceltByNumber_test(){
        //given
        int number =7 ;


        //when
        BankDAO dao = new BankDAO();
       Account account =  dao.selectByNumber(number);

       if(account == null){
           System.out.println(number +"로 조회된 값이 없습니다.");
       }else {
           System.out.println(account);
//           System.out.println(account.getNumber());
//           System.out.println(account.getPassword());
//           System.out.println(account.getBalance());
//           System.out.println(account.getCreatedAt());
       }
    }


    @Test
    public void deleteByNumber_test() {
        //given
        int number = 4;
        int balance = 5000;
        String password = "1478";

        // when
        BankDAO dao = new BankDAO();
        int result = dao.insert(password,balance);

        //then
        if (result == 1) {
            System.out.println("성공");
        } else if (result == 0) {
            System.out.println(number + "번호를 찾을 수 없습니다.");
        } else {
            System.out.println("실패");
        }
    }
}
