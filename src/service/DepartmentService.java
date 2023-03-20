package service;

import entity.Department;

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
        System.out.println("Nhập mã phòng ban");
        String departmentCode = new Scanner(System.in).nextLine();
        System.out.println("Nhập tên phòng ban");
        String departmentName = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại");
        String phoneNumber = new Scanner(System.in).nextLine();
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
}
