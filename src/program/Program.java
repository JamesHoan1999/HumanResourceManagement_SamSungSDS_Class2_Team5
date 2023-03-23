package program;

import base.MethodBase;
import login.User;
import service.DepartmentService;
import service.EmployeeService;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Program {


    public static void homePage() throws ParseException {


        System.out.println("Danh sách danh mục :");
        System.out.println("1.Danh mục nhân viên  ");
        System.out.println("2.Danh mục phòng ban ");
        System.out.println("3.Logout");
        System.out.println("Nhập số từ 1 đến 3 để vào mục tiếp theo");

        int choice = MethodBase.getNumberScanner();

        while ( choice > 3 ||choice<1){
            System.out.println("Bạn nhập không hợp lệ .Vui lòng nhập lại số từ 1 đến 3");
            choice=MethodBase.getNumberScanner();
        }

        feature(choice);

    }

    public static void  feature(int option) throws ParseException {
        Scanner sc= new Scanner(System.in);
        switch (option){
            case 1:
                System.out.println("Bạn đã đến danh mục nhân viên ");
                System.out.println("Danh sách chức năng ");
                System.out.println("1.Hiển thị danh sách nhân viên");
                System.out.println("2.Thêm mới nhân viên");
                System.out.println("3.Cập nhật nhân viên");
                System.out.println("4.Xóa  nhân viên");
                System.out.println("5.Tìm kiếm nhân viên theo mã ,tên ,sdt hoặc email");
                System.out.println("0.Quay lại ");
                System.out.println("Nhập số từ 0 đến 5 để thực hiện chức năng tương ứng : ");
                int options=MethodBase.getNumberScanner();
                while (options >5 || options < 0){
                    System.out.println("Bạn nhập không hợp lệ.Vui lòng nhập lại số từ 0 đến 5");
                    options=MethodBase.getNumberScanner();
                }

                featureEmployee(options);

                break;
            case 2:
                System.out.println("Bạn đã đến danh mục phòng ban");
                System.out.println("Danh sách chức năng ");
                System.out.println("1.Hiển thị danh sách phòng ban");
                System.out.println("2.Thêm mới phòng ban");
                System.out.println("3.Cập nhật phòng ban");
                System.out.println("4.Xóa  phòng ban");
                System.out.println("5.Thêm nhân viên vào phòng ban");
                System.out.println("6.Xóa nhân viên khỏi phòng ban");
                System.out.println("7.Điều chuyển phòng ban cho nhân viên");
                System.out.println("8.Bổ nhiệm trưởng phòng");
                System.out.println("9.Hiển thị danh sách nhân viên theo phòng ban ");

                System.out.println("0.Quay lại ");

                System.out.println("Nhập số từ 0 đến 9 để thực hiện chức năng tương ứng : ");
                int optionsDepartment= MethodBase.getNumberScanner();
                while (optionsDepartment >9 || optionsDepartment < 0){
                    System.out.println("Bạn nhập không hợp lệ.Vui lòng nhập lại số từ 0 đến 4");
                    optionsDepartment=MethodBase.getNumberScanner();
                }
                featureDepartment(optionsDepartment);

                break;
            case 3:
                System.out.println("Đăng xuất");
                break;
        }

    }

    public static void featureEmployee(int fea) throws ParseException {
        if (fea==1){
            System.out.println("Hiển thị danh sách nhân viên");
            EmployeeService.getAllEmployee();
            feature(1);

        }
        else if (fea==2) {

            System.out.println("Thêm mới nhân viên");
            EmployeeService.insertEmployee();
            feature(1);
        }
        else if (fea==3) {
            System.out.println("Cập nhật nhân viên");
            EmployeeService.updateEmployee();
            feature(1);

        }
        else if (fea==4) {
            System.out.println("Xóa  nhân viên");
            EmployeeService.deleteEmployee();
            feature(1);
        }
        else if (fea==5) {
            System.out.println("Tìm kiếm nhân viên theo mã,tên,sdt hoặc email");
            EmployeeService.searchEmployee();
            feature(1);
        }
        else if (fea==0) {
            System.out.println("Back");
            homePage();
        }
    }

    public static void featureDepartment(int fea) throws ParseException {
        if (fea==1){
            System.out.println("Hiển thị danh sách phòng ban");
            DepartmentService.getAllDepartment();
            feature(2);

        }
        else if (fea==2) {
            System.out.println("Thêm mới phòng ban");
            DepartmentService.insertDepartment();
            feature(2);
        }
        else if (fea==3) {
            System.out.println("Cập nhật phòng ban");

            DepartmentService.updateDepartment();
            feature(2);
        }
        else if (fea==4) {
            System.out.println("Xóa  phòng ban");

            DepartmentService.deleteDepartment();
            feature(2);
        }
        else if (fea==5) {
            System.out.println("Thêm nhân viên vào phòng ban");
            DepartmentService.insertEmployeeToDepartment();
            feature(2);
        }
        else if (fea==6) {
            System.out.println("Xóa nhân viên khỏi phòng ban");
            DepartmentService.releaseEmployeeFromDepartment();
            feature(2);
        }
        else if (fea==7) {
            System.out.println("Điều chuyển phòng ban cho nhân viên");

            DepartmentService.updateDepartmentForEmployee();
            feature(2);
        }
        else if (fea==8) {
            System.out.println("Bổ nhiệm trưởng phòng");
            DepartmentService.updateManageForDepartment();
            feature(2);
        }
        else if (fea==9) {
            System.out.println("Hiển thị danh sách nhân viên theo phòng ban");
            DepartmentService.showListEmployeeByDepartment();
            feature(2);
        }

        else if (fea==0) {
            System.out.println("Back");
            homePage();
        }

    }
    public static void main(String[] args) throws ParseException {


        System.out.println("Chào mừng bạn đến với hệ thống quản lý nhân sự .");
        System.out.println("Vui lòng đăng nhập để sử dụng hệ thống");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin username :");
        String username = scanner.nextLine();
        System.out.println("Nhập thông tin password :");
        String password = scanner.nextLine();

            boolean isLogin = User.checkLogin(username, password);

        while (!isLogin) {
            System.out.println("Đăng nhập không thành công .Vui lòng thử lại !");
            System.out.println("Nhập thông tin username :");
            username = scanner.nextLine();
            System.out.println("Nhập thông tin password :");
            password = scanner.nextLine();
            isLogin = User.checkLogin(username, password);
        }
        System.out.println("Đăng nhập thành công");
        homePage();

    }
}
