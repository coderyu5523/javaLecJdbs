import controller.BankController;
import dao.BankDAO;


public class BankApp {
    public static void main(String[] args) {
        // 라우터 설치 컨트롤러 설치

        String url = "selectAll" ;

        BankDAO dao = new BankDAO() ;
        BankController con = new BankController(dao);
        Dispacher dis = new Dispacher(con);  // 요청 들어올 때마다 new 하는 것 보다 미리 만들어서 의존시킴
        dis.route(url);                      // con 은 의존성 주입. 필요한 애한테 변수를 입력

    }

}