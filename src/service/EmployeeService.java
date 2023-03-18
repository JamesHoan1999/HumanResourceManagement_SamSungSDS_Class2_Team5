package service;

import entity.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {


    public static void getAllEmployee(){
       List<Employee> employeeList = Employee.getAllEmployees();

        System.out.println("Danh sách nhân viên");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s","Mã nhân viên",
                "Tên nhân viên","Tên phòng ban","Vị trí","Địa chỉ","Ngày sinh","Giới tính","SĐT","Email","Số tk","Tên Ngân hàng",
                "Tiền lương","Thuế","Là trưởng phòng");
        System.out.println();
       for(Employee employee : employeeList){

           System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s",employee.getEmployeeCode(),
                   employee.getEmployeeName(),employee.getDepartmentName(),employee.getPositionName(),employee.getAddress(),
                   employee.getDateOfBirth(),employee.getGender(),employee.getTelephoneNumber(),employee.getEmail(),
                   employee.getBankAccountNumber(),employee.getBankName(),
                   employee.getSalary(),employee.getTax(),employee.getIsManage());
           System.out.println();
       }
    }


//    public static void insertEmployee(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập mã nhân viên :");
//        String employeeCode = scanner.nextLine();
//        System.out.println("Nhập tên nhân viên");
//        String employeeName = scanner.nextLine();
//
//
//    }
}
