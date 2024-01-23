package controller;

// 책임 : 유효성 검사(바디데이터), 파싱(바디데이터), 검증 후 적절한 DAO 를 찾아줌

import dao.BankDAO;

public class BankController {

    private BankDAO dao ;

    public BankController(BankDAO dao) {
        this.dao = dao;
    }

    public BankDAO getDao() {
        return dao;
    }

    public void setDao(BankDAO dao) {
        this.dao = dao;
    }

    public void insert(){
        //1. 파싱

        //2. 유효성검사

        //3. dao 찾기

        System.out.println("controller : insert");
        dao.insert("1234",1000);
    }
    public void delete(){
        System.out.println("controller : delete");
        dao.deleteByNumber(1);
    }
    public void update(){
        System.out.println("controller : update");

    }
    public void selectOne(){
        System.out.println("controller : selectOne");
        dao.selectByNumber(1);
    }
    public void selectAll(){
        System.out.println("controller : selectAll");
        dao.selectAll();
    }


}
