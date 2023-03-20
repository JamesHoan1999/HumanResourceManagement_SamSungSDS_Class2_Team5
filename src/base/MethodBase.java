package base;

public class MethodBase {

    public static double getTax(double salary) {

        double salaryToTax=salary-11000000;
        if(salaryToTax <=5000000){
            return salaryToTax*0.05;
        }
        else if(salaryToTax>5000000 && salaryToTax<=10000000){
            return salaryToTax*0.1;
        }

        else if(salaryToTax>10000000 && salaryToTax<=18000000){
            return salaryToTax*0.15;
        }
        else if(salaryToTax >18000000 && salaryToTax<=32000000){
            return salaryToTax*0.2;
        }
        else if(salaryToTax >32000000 && salaryToTax<=52000000){
            return salaryToTax*0.25;
        }
        else if(salaryToTax >52000000 && salaryToTax<=80000000){
            return salaryToTax*0.3;
        }
        else {
            return salaryToTax*0.35;
        }
    }


    public static String convertGender(int gender){
        if(gender==0){
            return "Nam";
        }
        else if(gender==1){
            return "Nữ";
        }
        else{
            return "Khác";
        }
    }

    public static String stringIsManage(int isManage){

        if(isManage==1){
            return "Có";
        }
        else{
            return "Không";
        }
    }
}
