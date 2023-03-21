package service;

import entity.Department;
import entity.Employee;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DepartmentService {


    /*
    Lấy danh sách tất cả phòng ban
     */
    public static void  getAllDepartment(){
        List<Department> departments = Department.getAllDepartment();
        System.out.println("Danh sách phòng ban ");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s","STT","Mã phòng ban","Tên phòng ban","Số điện thoại","Tên trưởng phòng");
        System.out.println();
        int count=1;

        for (Department department : departments) {

            System.out.printf("%-20s%-20s%-20s%-20s%-20s",count,department.getDepartmentCode(),department.getDepartmentName(),department.getPhoneNumber(),department.getManagerName());
            System.out.println();
            count++;
        }
    }
    /*
    Thêm mới phòng ban

     */
    public static void  insertDepartment(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã phòng ban");
        String departmentCode = scanner.nextLine();
        System.out.println("Nhập tên phòng ban");
        String departmentName = scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        String phoneNumber = scanner.nextLine();
         String departmentID = String.valueOf(UUID.randomUUID());


         Department department = new Department();
         department.setDepartmentCode(departmentCode);
         department.setDepartmentName(departmentName);
         department.setPhoneNumber(phoneNumber);
         department.setDepartmentID(departmentID);

         if(department.insertDepartment() ){
             System.out.println("Thêm phòng ban thành công");
         }
         else{
             System.out.println("Thêm phòng ban thất bại");
         }
    }
    /*
    Cập nhật thông tin phòng ban
     */
    public static void  updateDepartment(){

        getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban muốn sửa");
        int stt = new Scanner(System.in).nextInt();
        stt = stt -1;
        List<Department> departments = Department.getAllDepartment();

       Department department = departments.get(stt);


        System.out.println("Nhập mã phòng ban .Vui lòng bỏ trống nếu không thay đổi");
        String departmentCode = new Scanner(System.in).nextLine();
        System.out.println("Nhập tên phòng ban .Vui lòng bỏ trống nếu không thay đổi");
        String departmentName = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại.Vui lòng bỏ trống nếu không thay đổi");
        String phoneNumber = new Scanner(System.in).nextLine();

        if(!departmentCode.trim().equals("")){
            department.setDepartmentCode(departmentCode);
        }
        if(!departmentName.trim().equals("")){
            department.setDepartmentName(departmentName);
        }

         if(!phoneNumber.trim().equals("")){
             department.setPhoneNumber(phoneNumber);
         }



         if(department.updateDepartment() ){
             System.out.println("Cập nhật phòng ban thành công");
         }
         else{
             System.out.println("Cập nhật phòng ban thất bại");
         }
    }
    /*
    Xóa thông tin phòng ban
     */
    public static void  deleteDepartment(){

        getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban muốn xóa");
        int stt = new Scanner(System.in).nextInt();
        stt = stt -1;
        List<Department> departments = Department.getAllDepartment();

       Department department = departments.get(stt);

         if(department.deleteDepartment() ){
             System.out.println("Xóa  phòng ban thành công");
         }
         else{
             System.out.println("Xóa phòng ban thất bại !Vì vẫn tồn tại nhân viên thuộc phòng ban này !");
         }
    }

    /*
    Thêm nhân viên vào phòng ban
     */
    public static void  insertEmployeeToDepartment(){

        getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban muốn thêm nhân viên");
        int stt = new Scanner(System.in).nextInt();
        stt = stt -1;
        List<Department> departments = Department.getAllDepartment();

       Department department = departments.get(stt);
       List<Employee> employeeList = Employee.getEmployeesHasNotDepartmentID();


        System.out.println("Danh sách nhân viên chưa có phòng ban");
       EmployeeService.showListEmployee(employeeList);

        System.out.println("Vui lòng nhập số thứ tự nhân viên  ban muốn thêm vào phòng ban");
        int stt2 = new Scanner(System.in).nextInt();
        stt2 = stt2 -1;


        Employee employee = employeeList.get(stt2);

        if(employee.updateDepartmentEmployee(department.getDepartmentID())){
            System.out.println("Thêm nhân viên vào phòng ban thành công");
        }
        else{
            System.out.println("Thêm nhân viên vào phòng ban thất bại");
        }

    }


    //Xóa nhân viên khỏi phòng ban
    public static void  releaseEmployeeFromDepartment(){

        getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban muốn xóa nhân viên");
        int stt = new Scanner(System.in).nextInt();
        stt = stt -1;
        List<Department> departments = Department.getAllDepartment();

        Department department = departments.get(stt);
        System.out.println("Bạn đang ở phòng ban : " + department.getDepartmentName());

        //Lấy ra danh sách nhân viên thuộc phòng ban
        List<Employee> employeeList = Employee.getEmployeesByDepartmentID(department.getDepartmentID());


        System.out.println("Danh sách nhân viên thuộc phòng ban thuộc phòng ban này");
        EmployeeService.showListEmployee(employeeList);

        System.out.println("Vui lòng nhập số thứ tự nhân viên  ban muốn xóa khỏi phòng ban");
        int stt2 = new Scanner(System.in).nextInt();
        stt2 = stt2 -1;


        Employee employee = employeeList.get(stt2);

        if(employee.releaseEmployeeFromDepartment()){
            System.out.println("Xóa nhân viên vào phòng ban thành công");
        }
        else{
            System.out.println("Xóa nhân viên khỏi phòng ban thất bại");
        }

    }


    //Điều chuyển  nhân viên khỏi phòng ban
    public static void  updateDepartmentForEmployee(){

        getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban đang muốn điều chuyển nhân viên");
        int stt = new Scanner(System.in).nextInt();
        stt = stt -1;
        List<Department> departments = Department.getAllDepartment();

        Department department = departments.get(stt);
        System.out.println("Bạn đang ở phòng ban : " + department.getDepartmentName());

        //Lấy ra danh sách nhân viên thuộc phòng ban
        List<Employee> employeeList = Employee.getEmployeesByDepartmentID(department.getDepartmentID());


        System.out.println("Danh sách nhân viên thuộc phòng ban thuộc phòng ban này");
        EmployeeService.showListEmployee(employeeList);

        System.out.println("Vui lòng nhập số thứ tự nhân viên  ban muốn xóa khỏi phòng ban");
        int stt2 = new Scanner(System.in).nextInt();
        stt2 = stt2 -1;


        Employee employee = employeeList.get(stt2);


        System.out.println("Vui lòng nhập số thứ tự phòng để điều chuyển nhân viên đến");
        int stt3 = new Scanner(System.in).nextInt();
        stt3 = stt3 -1;

        Department departmentNew = departments.get(stt3);


        if(employee.updateDepartmentEmployee(departmentNew.getDepartmentID())){
            System.out.println("Điều chuyển nhân viên thành công");
        }
        else{
            System.out.println("Điều chuyển nhân viên thất bại");
        }

    }


    //Bổ nhiệm trưởng phòng
    public static void  updateManageForDepartment(){

        getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban đang muốn bổ nhiệm trưởng phòng");
        int stt = new Scanner(System.in).nextInt();
        stt = stt -1;
        List<Department> departments = Department.getAllDepartment();

        Department department = departments.get(stt);
        System.out.println("Bạn đang ở phòng ban : " + department.getDepartmentName());

        //Lấy ra danh sách nhân viên thuộc phòng ban
        List<Employee> employeeList = Employee.getEmployeesByDepartmentID(department.getDepartmentID());


        System.out.println("Danh sách nhân viên thuộc phòng ban thuộc phòng ban này");
        EmployeeService.showListEmployee(employeeList);

        System.out.println("Vui lòng nhập số thứ tự nhân viên  muốn bổ nhiệm làm trưởng phòng");
        int stt2 = new Scanner(System.in).nextInt();
        stt2 = stt2 -1;


        Employee employee = employeeList.get(stt2);





        if(employee.updateManageEmployee()){
            System.out.println("Bổ nhiệm trưởng phòng thành công");
        }
        else{
            System.out.println("Bổ nhiệm trưởng phòng thất bại");
        }

    }


    //Hiển thị danh sách nhân viên theo phòng ban
    public static void  showListEmployeeByDepartment(){

        getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban đang muốn hiển thị nhân viên");
        int stt = new Scanner(System.in).nextInt();
        stt = stt -1;
        List<Department> departments = Department.getAllDepartment();

        Department department = departments.get(stt);
        System.out.println("Bạn đang ở phòng ban : " + department.getDepartmentName());

        //Lấy ra danh sách nhân viên thuộc phòng ban
        List<Employee> employeeList = Employee.getEmployeesByDepartmentID(department.getDepartmentID());


        System.out.println("Danh sách nhân viên thuộc phòng ban thuộc phòng ban này");
        EmployeeService.showListEmployee(employeeList);



    }





}
