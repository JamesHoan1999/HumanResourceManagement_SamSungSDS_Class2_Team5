package service;

import base.MethodBase;
import entity.Department;
import entity.Employee;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class EmployeeService {




    public static void  showListEmployee(List<Employee> employeeList){
        System.out.println("Danh sách nhân viên");
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s","STT","Mã nhân viên",
                "Tên nhân viên","Tên phòng ban","Vị trí","Địa chỉ","Ngày sinh","Giới tính","SĐT","Email","Số tk","Tên Ngân hàng",
                "Tiền lương","Thuế","Là trưởng phòng");
        System.out.println();
        int count=1;
        for(Employee employee : employeeList){

            System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s",count,employee.getEmployeeCode(),
                    employee.getEmployeeName(),employee.getDepartmentName(),employee.getPositionName(),employee.getAddress(),
                    employee.getDateOfBirth(), MethodBase.convertGender(employee.getGender()),employee.getTelephoneNumber(),employee.getEmail(),
                    employee.getBankAccountNumber(),employee.getBankName(),
                    employee.getSalary(),employee.getTax(),MethodBase.stringIsManage(employee.getIsManage()));
            System.out.println();
            count++;
        }

    }


    public static void getAllEmployee(){
       List<Employee> employeeList = Employee.getAllEmployees();

        System.out.println("Danh sách nhân viên");
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s","STT","Mã nhân viên",
                "Tên nhân viên","Tên phòng ban","Vị trí","Địa chỉ","Ngày sinh","Giới tính","SĐT","Email","Số tk","Tên Ngân hàng",
                "Tiền lương","Thuế","Là trưởng phòng");
        System.out.println();
        int count=1;
       for(Employee employee : employeeList){

           System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s",count,employee.getEmployeeCode(),
                   employee.getEmployeeName(),employee.getDepartmentName(),employee.getPositionName(),employee.getAddress(),
                   employee.getDateOfBirth(), MethodBase.convertGender(employee.getGender()),employee.getTelephoneNumber(),employee.getEmail(),
                   employee.getBankAccountNumber(),employee.getBankName(),
                   employee.getSalary(),employee.getTax(),MethodBase.stringIsManage(employee.getIsManage()));
           System.out.println();
           count++;
       }
    }


    public static void searchEmployee(){
        System.out.println("Nhập thông tin tìm kiếm theo tên ,sdt,email,mã nv");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
       List<Employee> employeeList = Employee.searchEmployees(key);

        System.out.println("Danh sách nhân viên");
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s","STT","Mã nhân viên",
                "Tên nhân viên","Tên phòng ban","Vị trí","Địa chỉ","Ngày sinh","Giới tính","SĐT","Email","Số tk","Tên Ngân hàng",
                "Tiền lương","Thuế","Là trưởng phòng");
        System.out.println();
        int count=1;
       for(Employee employee : employeeList){

           System.out.printf("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s",count,employee.getEmployeeCode(),
                   employee.getEmployeeName(),employee.getDepartmentName(),employee.getPositionName(),employee.getAddress(),
                   employee.getDateOfBirth(), MethodBase.convertGender(employee.getGender()),employee.getTelephoneNumber(),employee.getEmail(),
                   employee.getBankAccountNumber(),employee.getBankName(),
                   employee.getSalary(),employee.getTax(),MethodBase.stringIsManage(employee.getIsManage()));
           System.out.println();
           count++;
       }
    }


    public static void insertEmployee() throws ParseException {

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

        scanner= new Scanner(System.in);
        System.out.println("Nhập vị trí");
        String positionName = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh theo định dạng yyyy-MM-dd");
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
        System.out.println("Là trưởng phòng hay không !Nếu có nhập 1 Không thì nhập 0");
        Integer isManage = scanner.nextInt();
        System.out.println("Nhập tiền lương");
        double salary = scanner.nextDouble();

        double tax = MethodBase.getTax(salary);

        String employeeId = UUID.randomUUID().toString();

        Employee employee = new Employee();
        employee.setEmployeeID(employeeId);
        employee.setEmployeeCode(employeeCode);
        employee.setEmployeeName(employeeName);
        employee.setDepartmentID(departmentID);
        employee.setPositionName(positionName);
        employee.setAddress(address);
        employee.setIdentityNumber(identityNumber);

        //Format date
        Date date = MethodBase.convertDate(dateOfBirth);



       employee.setDateOfBirth(date);
        employee.setGender(gender);
        employee.setTelephoneNumber(telephoneNumber);
        employee.setEmail(email);
        employee.setBankAccountNumber(bankAccountNumber);
        employee.setBankName(bankName);
        employee.setSalary(salary);
        employee.setTax(tax);



        if(isManage==1){
            employee.setIsManage(isManage);
        }
        else {
            employee.setIsManage(null);
        }





        if(employee.insertEmployee()){
            System.out.println("Thêm mới nhân viên thành công");
        }
        else {
            System.out.println("Thêm mới nhân viên thất bại");
        }


    }

    public static void updateEmployee() throws ParseException {

        getAllEmployee();
        List<Employee> employeeList = Employee.getAllEmployees();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập stt nhân viên muốn sửa");
        int stt=  scanner.nextInt();
        Employee employee=employeeList.get(stt-1);
        scanner = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên :");
        String employeeCode = scanner.nextLine();
        System.out.println("Nhập tên nhân viên");
        String employeeName = scanner.nextLine();



        System.out.println("Nhập vị trí");
        String positionName = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh theo định dạng yyyy-MM-dd");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập Giới tính .Nhập 0(Nam),1(Nữ),2(Khác)");


        int gender =MethodBase.getNumberScanner();

        while ( gender > 2 || gender<0){
            System.out.println("Bạn nhập không hợp lệ .Vui lòng nhập lại số từ 0 đến 2");
            gender=MethodBase.getNumberScanner();
        }
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

        System.out.println("Nhập tiền lương");
        double salary = scanner.nextDouble();

        double tax = MethodBase.getTax(salary);




        if(!employeeCode.trim().equals("")){
            employee.setEmployeeCode(employeeCode);
        }
        if(!employeeName.trim().equals("")){
            employee.setEmployeeName(employeeName);
        }



       if(!positionName.trim().equals("")){

           employee.setPositionName(positionName);
       }

       if(!address.trim().equals("")){
            employee.setAddress(address);
        }

       if(!dateOfBirth.trim().equals("")){
           Date date = MethodBase.convertDate(dateOfBirth);
            employee.setDateOfBirth(date);
        }
       if(!identityNumber.trim().equals("")){

           employee.setIdentityNumber(identityNumber);
       }

       if(!telephoneNumber.trim().equals("")){

           employee.setTelephoneNumber(telephoneNumber);
       }

       if(!email.trim().equals("")){

           employee.setEmail(email);
       }

       if(!bankAccountNumber.trim().equals("")){

           employee.setBankAccountNumber(bankAccountNumber);
       }

       if(!bankName.trim().equals("")){

           employee.setBankName(bankName);
       }

       if(salary > 0){

           employee.setSalary(salary);
           employee.setTax(tax);
       }



        employee.setGender(gender);

        if(employee.updateEmployee()){
            System.out.println("Cập nhật nhân viên thành công");
        }
        else {
            System.out.println("Cập nhật nhân viên thất bại");
        }

    }

    public static void deleteEmployee() throws ParseException {

        getAllEmployee();
        List<Employee> employeeList = Employee.getAllEmployees();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập stt nhân viên muốn xóa");
        int stt=  scanner.nextInt();
        Employee employee=employeeList.get(stt-1);
        if(employee.deleteEmployee()){
            System.out.println("Xóa nhân viên thành công");
        }
        else {
            System.out.println("Xóa nhân viên thất bại");
        }

    }
}
