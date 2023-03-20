package program;

import login.User;
import service.DepartmentService;
import service.EmployeeService;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Program {


    public static void homepage() throws ParseException {


        System.out.println("Danh sách danh mục :");
        System.out.println("1.Danh mục nhân viên  ");
        System.out.println("2.Danh mục phòng ban ");
        System.out.println("3.Logout");
        System.out.println("Nhập số từ 1 đến 3 để vào mục tiếp theo");
         Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while ( choice > 3 ||choice<1){
            System.out.println("Bạn nhập không hợp lệ .Vui lòng nhập lại số từ 1 đến 3");
            choice=scanner.nextInt();
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
                int options=sc.nextInt();
                while (options >5 || options < 0){
                    System.out.println("Bạn nhập không hợp lệ.Vui lòng nhập lại số từ 0 đến 5");
                    options=sc.nextInt();
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
                System.out.println("0.Quay lại ");

                System.out.println("Nhập số từ 0 đến 4 để thực hiện chức năng tương ứng : ");
                int optionsDepartment=sc.nextInt();
                while (optionsDepartment >4 || optionsDepartment < 0){
                    System.out.println("Bạn nhập không hợp lệ.Vui lòng nhập lại số từ 0 đến 4");
                    optionsDepartment=sc.nextInt();
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
        }
        else if (fea==0) {
            System.out.println("Back");
            homepage();
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

        else if (fea==0) {
            System.out.println("Back");
            homepage();
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
        homepage();

    }
}
