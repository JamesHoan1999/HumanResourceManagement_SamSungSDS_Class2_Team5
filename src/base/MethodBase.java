package base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MethodBase {


    /**
     * Phương thức tính thuế thu nhập cá nhân
     *
     * @param salary Tiền thuế
     * @return tiền thuế
     */
    public static double getTax(double salary) {

        double salaryToTax = salary - 11000000;

        return getTaxSalary(salaryToTax);
    }

    /**
     * Phương thức tính thuế thu nhập cá nhân
     *
     * @param salaryToTax Tiền thuế
     * @return tiền
     */
    private static double getTaxSalary(double salaryToTax) {
        if (salaryToTax < 0) {
            return 0;
        } else if (salaryToTax <= 5000000 && salaryToTax > 0) {
            return salaryToTax * 0.05;
        } else if ( salaryToTax <= 10000000) {
            return getTaxSalary(5000000) + (salaryToTax - 5000000) * 0.1;
        } else if (salaryToTax <= 18000000) {
            return getTaxSalary(10000000)+ (salaryToTax -10000000)* 0.15;
        } else if ( salaryToTax <= 32000000) {
            return getTaxSalary(18000000) +(salaryToTax -18000000)* 0.2;
        } else if (salaryToTax <= 52000000) {

            return getTaxSalary(32000000)+( salaryToTax -32000000) * 0.25;
        } else if ( salaryToTax <= 80000000) {
            return getTaxSalary(52000000)+ (salaryToTax -52000000) * 0.3;
        } else {
            return getTaxSalary(80000000)+ (salaryToTax -80000000) * 0.35;
        }
    }


    /**
     * Trả về số nhập từ bàn phím
     *
     * @return
     */
    public static Integer getNumberScanner() {


        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println(" Bạn nhập không phải là số !Vui lòng nhập lại");
            scanner.nextLine();

        }
        return scanner.nextInt();


    }

    public static  Integer getNumberFromMinToMax(int min,int max) {
        Integer number = getNumberScanner();

        while(number > max ||number < min) {
            System.out.println("Số bạn nhập không hợp lệ !Vui lòng nhập lại");
            number = getNumberScanner();
        }
        return  number;
    }



    /**
     * convert ngày tháng dạng chuỗi sang kiểu Date
     * @param dateString ngày tháng dạng chuỗi
     * @return ngày tháng dạng Date java
     */
    public static Date convertDate(String dateString) {

        Date date = null;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd" ).parse(dateString);

        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Convert giới tính
     *
     * @param gender Giới tính dạng enum
     * @return
     */
    public static String convertGender(int gender) {
        if (gender == 0) {
            return "Nam";
        } else if (gender == 1) {return "Nữ";
        } else {
            return "Khác";
        }
    }


    /**
     * Kiểm tra xem có phải trưởng phòng hay không
     *
     * @param isManage Đầu vào là 1 hoặc null
     * @return Trả về có hoặc không
     */
    public static String stringIsManage(Integer isManage) {

        if (isManage == 1) {
            return "Có";
        } else {
            return "Không";
        }
    }
}