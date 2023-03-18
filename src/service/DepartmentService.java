package service;

import entity.Department;

import java.util.List;

public class DepartmentService {
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
}
