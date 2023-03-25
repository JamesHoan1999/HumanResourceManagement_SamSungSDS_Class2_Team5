package service;

import base.MethodBase;
import entity.Department;
import entity.Employee;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DepartmentService {


    /*
    Lấy danh sách tất cả phòng ban
     */
    public static void getAllDepartment() {


        List<Department> departments = Department.getAllDepartment();

        System.out.println("Danh sách phòng ban ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");


        System.out.printf("%-3s%-10s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-20s%-3s","|", "STT","|", "Mã phòng ban","|", "Tên phòng ban","|", "Số điện thoại","|", "Tên trưởng phòng","|");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------");

        int count = 1;

        for (Department department : departments) {

            System.out.printf("%-3s%-10s%-3s%-20s%-3s%-20s%-3s%-20s%-3s%-20s%-3s","|", count,"|", department.getDepartmentCode(),"|", department.getDepartmentName() ==null? "":department.getDepartmentName(),"|", department.getPhoneNumber() ==null? "":department.getPhoneNumber(),"|", department.getManagerName()==null? "":department.getManagerName(),"|") ;
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------");

            count++;
        }

    }

    /*
    Thêm mới phòng ban

     */
    public static void insertDepartment() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã phòng ban");
        String departmentCode =MethodBase.getStringNotNull();
        while (Department.checkDuplicateCode(departmentCode,null)){
            System.out.println("Mã phòng ban đã tồn tại trong hệ thống!Vui lòng nhập lại");
            departmentCode=MethodBase.getStringNotNull();
        }
        System.out.println("Nhập tên phòng ban");
        String departmentName = scanner.nextLine();
        System.out.println("Nhập số điện thoại");
        String phoneNumber = MethodBase.getPhoneNumber();
        String departmentID = String.valueOf(UUID.randomUUID());


        Department department = new Department();
        department.setDepartmentCode(departmentCode);
        department.setDepartmentName(departmentName);
        department.setPhoneNumber(phoneNumber);
        department.setDepartmentID(departmentID);

        if (department.insertDepartment()) {
            System.out.println("Thêm phòng ban thành công");
        } else {
            System.out.println("Thêm phòng ban thất bại");
        }
        System.out.println("------------------------------------------------------------------------------------------------");

    }

    /*
    Cập nhật thông tin phòng ban
     */
    public static void updateDepartment() {


        getAllDepartment();
        List<Department> departments = Department.getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban muốn sửa");

        int stt = MethodBase.getNumberFromMinToMax(1, departments.size());
        stt = stt - 1;


        Department department = departments.get(stt);
        Scanner scanner= new Scanner(System.in);
        System.out.println("Mã phòng ban hiện tại là : " + department.getDepartmentCode());
        System.out.println("Nhập mã phòng ban .Vui lòng bỏ trống nếu không thay đổi");
        String departmentCode =scanner.nextLine();

        while (Department.checkDuplicateCode(departmentCode,department.getDepartmentID())){
            System.out.println("Mã phòng ban đã tồn tại trong hệ thống!Vui lòng nhập lại");
            departmentCode=scanner.nextLine();
        }
        System.out.println("Tên phòng ban hiện tại là : "+department.getDepartmentName());
        System.out.println("Nhập tên phòng ban .Vui lòng bỏ trống nếu không thay đổi");
        String departmentName = scanner.nextLine();
        System.out.println("Số điên thoại hiện tại là : "+department.getPhoneNumber());
        System.out.println("Nhập số điện thoại.Vui lòng bỏ trống nếu không thay đổi");
        String phoneNumber = MethodBase.getPhoneNumber();

        if (!departmentCode.trim().equals("")) {
            department.setDepartmentCode(departmentCode);
        }
        if (!departmentName.trim().equals("")) {
            department.setDepartmentName(departmentName);
        }

        if (!phoneNumber.trim().equals("")) {
            department.setPhoneNumber(phoneNumber);
        }


        if (department.updateDepartment()) {
            System.out.println("Cập nhật phòng ban thành công");
        } else {
            System.out.println("Cập nhật phòng ban thất bại");
        }
        System.out.println("------------------------------------------------------------------------------------------------");

    }

    /*
    Xóa thông tin phòng ban
     */
    public static void deleteDepartment() {

        getAllDepartment();
        List<Department> departments = Department.getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban muốn xóa");
        int stt = MethodBase.getNumberFromMinToMax(1, departments.size());
        stt = stt - 1;


        Department department = departments.get(stt);

        if (department.deleteDepartment()) {
            System.out.println("Xóa  phòng ban thành công");
        } else {
            System.out.println("Xóa phòng ban thất bại !Vì vẫn tồn tại nhân viên thuộc phòng ban này !");
        }
        System.out.println("------------------------------------------------------------------------------------------------");

    }

    /*
    Thêm nhân viên vào phòng ban
     */
    public static void insertEmployeeToDepartment() {


        getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban muốn thêm nhân viên");
        List<Department> departments = Department.getAllDepartment();
        int stt = MethodBase.getNumberFromMinToMax(1, departments.size());
        stt = stt - 1;


        Department department = departments.get(stt);
        List<Employee> employeeList = Employee.getEmployeesHasNotDepartmentID();


        if (employeeList.size() > 0) {
            System.out.println("Danh sách nhân viên chưa có phòng ban");
            EmployeeService.showListEmployee(employeeList);

            System.out.println("Vui lòng nhập số thứ tự nhân viên  ban muốn thêm vào phòng ban");
            int stt2 = MethodBase.getNumberFromMinToMax(1,employeeList.size());
            stt2 = stt2 - 1;

            Employee employee = employeeList.get(stt2);

            if (employee.updateDepartmentEmployee(department.getDepartmentID())) {
                System.out.println("Thêm nhân viên vào phòng ban thành công");
            } else {
                System.out.println("Thêm nhân viên vào phòng ban thất bại");
            }
        }
        else {
            System.out.println("Không có nhân viên nào chưa có phòng ban");
        }


        System.out.println("------------------------------------------------------------------------------------------------");

    }


    //Xóa nhân viên khỏi phòng ban
    public static void releaseEmployeeFromDepartment() {
        getAllDepartment();
        List<Department> departments = Department.getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban muốn xóa nhân viên");
        int stt = MethodBase.getNumberFromMinToMax(1, departments.size());
        stt = stt - 1;


        Department department = departments.get(stt);
        System.out.println("Bạn đang ở phòng ban : " + department.getDepartmentName());

        //Lấy ra danh sách nhân viên thuộc phòng ban
        List<Employee> employeeList = Employee.getEmployeesByDepartmentID(department.getDepartmentID());

        if (employeeList.size() > 0) {
            System.out.println("Danh sách nhân viên thuộc phòng ban thuộc phòng ban này");
            EmployeeService.showListEmployee(employeeList);

            System.out.println("Vui lòng nhập số thứ tự nhân viên  ban muốn xóa khỏi phòng ban");
            int stt2 =MethodBase.getNumberFromMinToMax(1,employeeList.size());
            stt2 = stt2 - 1;

            Employee employee = employeeList.get(stt2);

            if (employee.releaseEmployeeFromDepartment()) {
                System.out.println("Xóa nhân viên vào phòng ban thành công");
            } else {
                System.out.println("Xóa nhân viên khỏi phòng ban thất bại");
            }
        } else {

            System.out.println("Không có nhân viên thuộc phòng ban này");
        }

        System.out.println("------------------------------------------------------------------------------------------------");


    }


    //Điều chuyển  nhân viên khỏi phòng ban
    public static void updateDepartmentForEmployee() {


        getAllDepartment();

        List<Department> departments = Department.getAllDepartment();

        System.out.println("Vui lòng nhập số thứ tự phòng ban đang muốn điều chuyển nhân viên");
        int stt = MethodBase.getNumberFromMinToMax(1,departments.size());
        stt = stt - 1;


        Department department = departments.get(stt);
        System.out.println("Bạn đang ở phòng ban : " + department.getDepartmentName());

        //Lấy ra danh sách nhân viên thuộc phòng ban
        List<Employee> employeeList = Employee.getEmployeesByDepartmentID(department.getDepartmentID());

        if (employeeList.size() > 0) {
            System.out.println("Danh sách nhân viên thuộc phòng ban thuộc phòng ban này");
            EmployeeService.showListEmployee(employeeList);

            System.out.println("Vui lòng nhập số thứ tự nhân viên  ban muốn xóa khỏi phòng ban");
            int stt2 = MethodBase.getNumberFromMinToMax(1,employeeList.size());
            stt2 = stt2 - 1;


            Employee employee = employeeList.get(stt2);


            System.out.println("Vui lòng nhập số thứ tự phòng để điều chuyển nhân viên đến");
            int stt3 = MethodBase.getNumberFromMinToMax(1,departments.size());
            stt3 = stt3 - 1;

            Department departmentNew = departments.get(stt3);


            if (employee.updateDepartmentEmployee(departmentNew.getDepartmentID())) {
                System.out.println("Điều chuyển nhân viên thành công");
            } else {
                System.out.println("Điều chuyển nhân viên thất bại");
            }
        } else {
            System.out.println("Không có nhân viên thuộc phòng ban này");
        }


        System.out.println("-----------------------------------------------------------------------------------------------");


    }


    //Bổ nhiệm trưởng phòng
    public static void updateManageForDepartment() {



        getAllDepartment();

        List<Department> departments = Department.getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban đang muốn bổ nhiệm trưởng phòng");
        int stt = MethodBase.getNumberFromMinToMax(1,departments.size());
        stt = stt - 1;


        Department department = departments.get(stt);
        System.out.println("Bạn đang ở phòng ban : " + department.getDepartmentName());

        //Lấy ra danh sách nhân viên thuộc phòng ban
        List<Employee> employeeList = Employee.getEmployeesByDepartmentID(department.getDepartmentID());

        if (employeeList.size() > 0) {
            System.out.println("Danh sách nhân viên thuộc phòng ban thuộc phòng ban này");
            EmployeeService.showListEmployee(employeeList);

            System.out.println("Vui lòng nhập số thứ tự nhân viên  muốn bổ nhiệm làm trưởng phòng");
            int stt2 = MethodBase.getNumberFromMinToMax(1,employeeList.size());
            stt2 = stt2 - 1;

            Employee employee = employeeList.get(stt2);

            if (employee.updateManageEmployee()) {
                System.out.println("Bổ nhiệm trưởng phòng thành công");
            } else {
                System.out.println("Bổ nhiệm trưởng phòng thất bại");
            }
        } else {
            System.out.println("Không có nhân viên thuộc phòng ban ");
        }
        System.out.println("------------------------------------------------------------------------------------------------");


    }


    //Hiển thị danh sách nhân viên theo phòng ban
    public static void showListEmployeeByDepartment() {


        getAllDepartment();

        List<Department> departments = Department.getAllDepartment();
        System.out.println("Vui lòng nhập số thứ tự phòng ban đang muốn hiển thị nhân viên");
        int stt =MethodBase.getNumberFromMinToMax(1,departments.size());
        stt = stt - 1;


        Department department = departments.get(stt);
        System.out.println("Bạn đang ở phòng ban : " + department.getDepartmentName());

        //Lấy ra danh sách nhân viên thuộc phòng ban
        List<Employee> employeeList = Employee.getEmployeesByDepartmentID(department.getDepartmentID());

        if (employeeList.size() > 0) {
            System.out.println("Danh sách nhân viên thuộc phòng ban thuộc phòng ban này");
            EmployeeService.showListEmployee(employeeList);

        } else {
            System.out.println("Không có nhân viên thuộc phòng ban ");
        }

        System.out.println("------------------------------------------------------------------------------------------------");


    }


}
