package service;

import base.MethodBase;
import entity.Department;
import entity.Employee;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class EmployeeService {




    public static void  showListEmployee(List<Employee> employeeList){
        if(employeeList.size()>0){
            System.out.println("Danh sách nhân viên");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            System.out.printf("%-3s%-10s%-3s%-20s%-3s%-30s%-3s%-20s%-3s%-30s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-30s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-20s%-3s","|","STT","|","Mã nhân viên","|",
                    "Tên nhân viên","|","Tên phòng ban","|","Vị trí","|","Địa chỉ","|","Ngày sinh","|","Giới tính","|","SĐT","|","Email","|","Số tk","|","Tên Ngân hàng","|",
                    "Tiền lương","|","Thuế","|","Là trưởng phòng","|");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            int count=1;
            for(Employee employee : employeeList){

                System.out.printf("%-3s%-10s%-3s%-20s%-3s%-30s%-3s%-20s%-3s%-30s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-30s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-20s%-3s","|",count,"|",employee.getEmployeeCode(),"|",
                        employee.getEmployeeName()==null ? "":employee.getEmployeeName(),"|",employee.getDepartmentName() ==null ?"":employee.getDepartmentName(),"|",employee.getPositionName()==null ? "":employee.getPositionName(),"|",employee.getAddress() ==null ? "" : employee.getAddress() ,"|"  ,
                        employee.getDateOfBirth() ==null ? "":employee.getDateOfBirth(),"|", MethodBase.convertGender(employee.getGender()),"|",employee.getTelephoneNumber()==null ? "":employee.getTelephoneNumber(),"|",
                        employee.getEmail()==null ? "": employee.getEmail(),"|",
                        employee.getBankAccountNumber()==null ? "": employee.getBankAccountNumber(),"|",employee.getBankName()==null ? "": employee.getBankName(),"|",
                        MethodBase.getSalaryString(employee.getSalary()),"|",MethodBase.getSalaryString(employee.getTax()),"|",MethodBase.stringIsManage(employee.getIsManage()),"|");
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                count++;
            }
        }
        else {
            System.out.println("Không có  nhân viên");
        }





    }


    public static void getAllEmployee(){


       List<Employee> employeeList = Employee.getAllEmployees();

        showListEmployee(employeeList);

    }


    public static void searchEmployee(){
        System.out.println("------------------------------------------------------------------------------------------------");

        System.out.println("Nhập thông tin tìm kiếm theo tên ,sdt,email,mã nv");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
       List<Employee> employeeList = Employee.searchEmployees(key);
       if(employeeList.size()>0){
      showListEmployee(employeeList);
       }
       else{
           System.out.println("Không tìm thấy nhân viên");
       }


        System.out.println("------------------------------------------------------------------------------------------------");

    }


    public static void insertEmployee() throws ParseException {
        System.out.println("------------------------------------------------------------------------------------------------");


        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã nhân viên :");
        String employeeCode =MethodBase.getStringNotNull();



        while (Employee.checkDuplicateCode(employeeCode,null)){
            System.out.println("Mã nhân viên đã tồn tại");
            System.out.println("Nhập lại mã nhân viên :");
            employeeCode =MethodBase.getStringNotNull();
        }


        System.out.println("Nhập tên nhân viên");
        String employeeName = scanner.nextLine();

        System.out.println("Chọn phòng ban");
       DepartmentService.getAllDepartment();
       List<Department> departments =Department.getAllDepartment();
        System.out.println("Nhập stt phòng ban ");
        int stt=  MethodBase.getNumberFromMinToMax(1,departments.size());

        String departmentID=departments.get(stt-1).getDepartmentID();

        scanner= new Scanner(System.in);
        System.out.println("Nhập vị trí");
        String positionName = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh theo định dạng yyyy-MM-dd");
        String dateOfBirth = MethodBase.getDateScanner();
        System.out.println("Nhập Giới tính (0-nam,1-nữ,2-khác)");
        int gender = MethodBase.getNumberFromMinToMax(0,2);
        scanner = new Scanner(System.in);
        System.out.println("Nhập số cmnd ");
        String identityNumber = MethodBase.getStringNumberScanner();

        while (Employee.checkDuplicateIdentityNumber(identityNumber,null)){
            System.out.println("Số cmnd đã tồn tại");
            System.out.println("Nhập lại số cmnd :");
            identityNumber = MethodBase.getStringNumberScanner();
        }
        System.out.println("Nhập số điện thoại");
        String telephoneNumber = MethodBase.getPhoneNumber();
        System.out.println("Nhập email");
        String email = MethodBase.getEmailScanner();

        while (Employee.checkDuplicateEmail(email,null)){
            System.out.println("Email đã tồn tại");
            System.out.println("Nhập lại email :");
            email = MethodBase.getEmailScanner();
        }
        System.out.println("Nhập số tk");
        String bankAccountNumber = MethodBase.getStringNumberScanner();
        System.out.println("Nhập tên ngân hàng");
        String bankName = scanner.nextLine();

        System.out.println("Nhập tiền lương");
        double salary = MethodBase.getSalaryScanner();

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
        employee.setIsManage(null);






        if(employee.insertEmployee()){
            System.out.println("Thêm mới nhân viên thành công");
        }
        else {
            System.out.println("Thêm mới nhân viên thất bại");
        }
        System.out.println("------------------------------------------------------------------------------------------------");



    }

    public static void updateEmployee() throws ParseException {
        System.out.println("------------------------------------------------------------------------------------------------");


        getAllEmployee();
        List<Employee> employeeList = Employee.getAllEmployees();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập stt nhân viên muốn sửa");
        int stt=  MethodBase.getNumberFromMinToMax(1, employeeList.size());
        Employee employee=employeeList.get(stt-1);
        scanner = new Scanner(System.in);
        System.out.println("Mã nhân viên hiện tại là : " + employee.getEmployeeCode());
        System.out.println("Nhập mã nhân viên .Vui lòng bỏ trống  nếu không thay đổi");
        String employeeCode = scanner.nextLine();
        while (Employee.checkDuplicateCode(employeeCode,employee.getEmployeeID())){
            System.out.println("Mã nhân viên đã tồn tại");
            System.out.println("Nhập lại mã nhân viên :");
            employeeCode = scanner.nextLine();
        }
        System.out.println("Tên nhân viên hiện tại là : " + employee.getEmployeeName());
        System.out.println("Nhập tên nhân viên .Vui lòng bỏ trống  nếu không thay đổi");
        String employeeName = scanner.nextLine();


        System.out.println("Vị trí hiện tại là : " + employee.getPositionName());
        System.out.println("Nhập vị trí .Vui lòng bỏ trống  nếu không thay đổi");
        String positionName = scanner.nextLine();
        System.out.println("Địa chỉ hiện tại là : " +employee.getAddress());
        System.out.println("Nhập địa chỉ .Vui lòng bỏ trống  nếu không thay đổi");
        String address = scanner.nextLine();

        System.out.println("Ngày sinh hiện tại là : "+employee.getDateOfBirth());
        System.out.println("Nhập ngày sinh theo định dạng yyyy-MM-dd .Vui lòng bỏ trống  nếu không thay đổi");
        String dateOfBirth = MethodBase.getDateScanner();
        System.out.println("Giới tính hiện tại là : "+employee.getGenderName());
        System.out.println("Nhập Giới tính .Nhập 0(Nam),1(Nữ),2(Khác)");


        int gender =MethodBase.getNumberFromMinToMax(0,2);


        scanner = new Scanner(System.in);
        System.out.println("CMND cũ là : " + employee.getIdentityNumber());
        System.out.println("Nhập số cmnd .Vui lòng bỏ trống  nếu không thay đổi");
        String identityNumber = MethodBase.getStringNumberScanner();

        while (Employee.checkDuplicateIdentityNumber(identityNumber,employee.getEmployeeID())) {
            System.out.println("Số cmnd đã tồn tại");
            System.out.println("Nhập lại số cmnd :");
            identityNumber = MethodBase.getStringNumberScanner();
        }
        System.out.println("Số điện thoại hiện tại là : "+employee.getTelephoneNumber());
        System.out.println("Nhập số điện thoại .Vui lòng bỏ trống  nếu không thay đổi");
        String telephoneNumber = MethodBase.getPhoneNumber();

        System.out.println("Email cũ là : "+employee.getEmail());
        System.out.println("Nhập email .Vui lòng bỏ trống  nếu không thay đổi");
        String email = MethodBase.getEmailScanner();
        while (Employee.checkDuplicateEmail(email,employee.getEmployeeID())){
            System.out.println("Email đã tồn tại");
            System.out.println("Nhập lại email :");
            email = MethodBase.getEmailScanner();
        }
        System.out.println("Số tài khoản cũ là "+employee.getBankAccountNumber());
        System.out.println("Nhập số tk .Vui lòng bỏ trống  nếu không thay đổi");
        String bankAccountNumber = MethodBase.getStringNumberScanner();

        System.out.println("Tên ngân hàng hiện tại là : "+employee.getBankName());
        System.out.println("Nhập tên ngân hàng .Vui lòng bỏ trống  nếu không thay đổi");
        String bankName = scanner.nextLine();

        System.out.println("Nhập tiền lương .Vui lòng nhập 0   nếu không thay đổi");
        double salary =MethodBase.getSalaryScanner();

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
            System.out.println("Cập nhật nhân viên thành công" );
        }
        else {
            System.out.println("Cập nhật nhân viên thất bại");
        }
        System.out.println("------------------------------------------------------------------------------------------------");

    }

    public static void deleteEmployee() throws ParseException {
        System.out.println("------------------------------------------------------------------------------------------------");


        getAllEmployee();
        List<Employee> employeeList = Employee.getAllEmployees();



        System.out.println("Nhập stt nhân viên muốn xóa");
        int stt= MethodBase.getNumberFromMinToMax(1, employeeList.size());
        Employee employee=employeeList.get(stt-1);
        if(employee.deleteEmployee()){
            System.out.println("Xóa thành công! Nhân viên vừa xóa có mã nhân viên là : "+employee.getEmployeeCode() + " Tên nhân viên là : " + employee.getDepartmentName());

        }
        else {
            System.out.println("Xóa nhân viên thất bại");
        }
        System.out.println("------------------------------------------------------------------------------------------------");


    }
}
