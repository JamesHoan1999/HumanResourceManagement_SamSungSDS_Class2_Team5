package service;

import entity.Employee;
import entity.Statistics;
import enumCommon.SortEnum;

import java.awt.*;
import java.util.List;

public class StatisticsService {

    public static void showTopEmployee(){
        List<Employee> employeeList= Statistics.getTopEmployees(SortEnum.DESC);
        System.out.println(" Danh sách top 5 nhân viên có lương cao nhất");
        EmployeeService.showListEmployee(employeeList);
    }


    public static void showTopDownEmployee(){
        List<Employee> employeeList= Statistics.getTopEmployees(SortEnum.ASC);
        System.out.println(" Danh sách top 5 nhân viên có lương thấp nhất");
        EmployeeService.showListEmployee(employeeList);
    }
}
