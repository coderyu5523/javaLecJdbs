import controller.BankController;



// 책임 : 라우팅

public class Dispacher {

    private BankController con;

    public Dispacher(BankController con) {
        this.con = con;
    }

    public BankController getCon() {
        return con;
    }

    public void setCon(BankController con) {
        this.con = con;
    }

    public void route(String url){


        // 라우터. 어떤 주소가 들어왔을 때 라우팅(찾아주는)하는 것. = 디스패처. 주소를 추적해서 찾아줌
        // 앞으로 많은 경우의 수가 있음.라이브러리를 사용해야됨.
        if(url.equals("insert")){
            con.insert();  // 라우터
        }else if(url.equals("delete")) {
            con.delete();
        }else if(url.equals("update")) {
            con.update();
        }else if(url.equals("selectOne")) {
            con.selectOne();
        }else if(url.equals("selectAll")) {
            con.selectAll();
        }



    }
}
