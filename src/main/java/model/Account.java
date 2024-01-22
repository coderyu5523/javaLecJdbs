package model;

// db에 secelt 한 데이터를 담기 위한 오브젝트






import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;


public class Account {
    private int number ;
    private String password;
    private int balance;
    private Timestamp createdAt; //java.sql 라이브러리 , 카멜표기법

    public Account(int number, String password, int balance, Timestamp createdAt) {
        this.number = number;
        this.password = password;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public int getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                '}';
    }
}
