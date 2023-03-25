package base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

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

    }  /**
     * Trả về số nhập từ bàn phím
     *
     * @return
     */
    public static double getSalaryScanner() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            System.out.println(" Bạn nhập không phải là số !Vui lòng nhập lại");
            scanner.nextLine();

        }
        return scanner.nextDouble();

    }


    /**
     * Check có đúng dữ liệu sdt,email hay ngày tháng không
     * @param emailAddress chuỗi cần kiểm tra
     * @param regexPattern kiểu kiểm tra
     * @return true nếu đúng
     */
    public static boolean checkFormat(String emailAddress,String  regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    /**
     * Lấy email nhập từ bàn phím
     * @return
     */
    public static String getEmailScanner() {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        while (!checkFormat(email,regexPattern)) {
            if(email.trim().equals("")){
                return "";
            }
            System.out.println(" Bạn nhập không phải là email!Vui lòng nhập lại");
            email = scanner.nextLine();
        }

        return  email;
    }


    /**
     * Lấy chuỗi khác rỗng nhập từ bàn phím
     * @return
     */
    public static String getStringNotNull(){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        while (string.trim().equals("")) {
            System.out.println("Trường này không được bỏ trống !Vui lòng nhập lại");
            string = scanner.nextLine();
        }

        return  string;
    }

    /**
     * Lấy sdt nhập từ bàn phím
     * @return sdt
     */
    public static String getPhoneNumber() {
        String regexPattern = "(\\+84|0)+([3|5|7|8|9])+([0-9]{8})";

        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();

        while (!checkFormat(phoneNumber,regexPattern)) {

            if(phoneNumber.trim().equals("")){
                return "";
            }
            System.out.println(" Bạn nhập sdt không hợp lệ!Vui lòng nhập lại");
            phoneNumber = scanner.nextLine();
        }

        return  phoneNumber;
    }
    /**
     * Lấy sdt nhập từ bàn phím
     * @return sdt
     */
    public static String getStringNumberScanner() {
        String regexPattern = "^\\d+$";

        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        while (!checkFormat(number,regexPattern)) {
            if(number.trim().equals("")){
                return "";
            }
            System.out.println(" Bạn nhập  không hợp lệ!Vui lòng nhập lại");
            number = scanner.nextLine();
        }

        return  number;
    }





    /**
     * Lấy ngày tháng từ bàn phím
     * @return ngày tháng
     */
    public static String getDateScanner() {


        String regexPattern = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";

        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();

        while (!checkFormat(dateString,regexPattern)) {
            if(dateString.trim().equals("")){
                return "";
            }
            System.out.println(" Ngày tháng bạn nhập không hợp lệ!Vui lòng nhập lại");
            dateString = scanner.nextLine();

        }

        return  dateString;
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
        if(dateString.trim().equals("")){
            return null;
        }

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

    public static  String getSalaryString(double salary) {


        String salaryString = String.format("%.2f", salary);
        int length = salaryString.length();
        String result = salaryString.substring(length - 3, length);
        for (int i = length - 6; i > 0; i = i - 3) {
            result = "." + salaryString.substring(i, i + 3) + result;
        }
        if (length % 3 == 0) {
            result = salaryString.substring(0, 3) + result;
        }
        else if (length % 3 == 1) {
            result = salaryString.substring(0, 1) + result;
        }
        else if (length % 3 == 2) {
            result = salaryString.substring(0, 2) + result;
        }


        return result;

    }
}