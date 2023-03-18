package entity;

import base.MySQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Department {

    private String departmentID;
    private String departmentCode;
    private String departmentName;
    private String managerName;
    private String phoneNumber;


    public Department(){};

    public Department(String departmentID, String departmentCode, String departmentName, String managerName, String phoneNumber) {
        this.departmentID = departmentID;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.managerName = managerName;
        this.phoneNumber = phoneNumber;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public static List<Department> getAllDepartment(){
        try {

            Connection connection = MySQLConnection.getConnection();


            Statement statement = connection.createStatement();
            String sql="SELECT d.*,e.EmployeeName AS ManageName FROM department d JOIN employee e ON  d.DepartmentID=e.DepartmentID WHERE e.IsManage=1;  ";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Department> departmentList = new ArrayList<>();
            while (resultSet.next()){
           Department department = new Department();
           department.setDepartmentID(resultSet.getString("DepartmentID"));
           department.setDepartmentCode(resultSet.getString("DepartmentCode"));
           department.setDepartmentName(resultSet.getString("DepartmentName"));
           department.setPhoneNumber(resultSet.getString("PhoneNumber"));
           department.setManagerName(resultSet.getString("ManageName"));
           departmentList.add(department);

            }
            return departmentList;
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return  new ArrayList<Department>();
    }


}
