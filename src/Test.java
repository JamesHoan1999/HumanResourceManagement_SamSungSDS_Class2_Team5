import base.MethodBase;
import entity.Employee;

public class Test {

    public static void main(String[] args) {
        String email = "imtra98@gmail.com";
        String id=null;
        String id2="ce9f0b99-006e-4fbc-9e29-79ab0eafe35d";
        boolean kq1= Employee.checkDuplicateEmail(email,id);
        boolean kq2= Employee.checkDuplicateEmail(email,id2);

        System.out.println("kq1 = "+kq1);
        System.out.println("kq2 = "+kq2);
    }
}
