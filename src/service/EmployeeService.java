package service;

import entity.Department;
import entity.Employee;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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


    public static void insertEmployee(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên :");
        String employeeCode = scanner.nextLine();
        System.out.println("Nhập tên nhân viên");
        String employeeName = scanner.nextLine();
        System.out.println("Nhập mã phòng ban");
       DepartmentService.getAllDepartment();
       List<Department> departments =Department.getAllDepartment();
        System.out.println("Nhập stt phòng ban ");
        int stt=  scanner.nextInt();
        String departmentID=departments.get(stt-1).getDepartmentID();
        System.out.println("Nhập vị trí");
        String positionName = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập Giới tính");
        int gender = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.println("Nhập số cmnd ");
        String identityNumber = scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        String telephoneNumber = scanner.nextLine();
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        System.out.println("Nhập số tk");
        String bankAccountNumber = scanner.nextLine();
        System.out.println("Nhập tên ngân hàng");
        String bankName = scanner.nextLine();
        System.out.println("Là trưởng phòng hay không !Nếu có nhập 1 ");
        Integer isManage = scanner.nextInt();
        System.out.println("Nhập tiền lương");
        double salary = scanner.nextDouble();
        System.out.println("Nhập thuế");
        double tax = scanner.nextDouble();

        String employeeId = UUID.randomUUID().toString();

        Employee employee = new Employee();
        employee.setEmployeeID(employeeId);
        employee.setEmployeeCode(employeeCode);
        employee.setEmployeeName(employeeName);
        employee.setDepartmentID(departmentID);
        employee.setPositionName(positionName);
        employee.setAddress(address);
//        employee.setDateOfBirth(dateOfBirth);
        employee.setGender(gender);
        employee.setTelephoneNumber(telephoneNumber);
        employee.setEmail(email);
        employee.setBankAccountNumber(bankAccountNumber);
        employee.setBankName(bankName);
        employee.setSalary(salary);
        employee.setTax(tax);
        employee.setIsManage(isManage);


        if(employee.insertEmployee()){
            System.out.println("Thêm mới nhân viên thành công");
        }
        else {
            System.out.println("Thêm mới nhân viên thất bại");
        }


    }
}
