package entity;

import base.MySQLConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Department {

    private String departmentID;
    private String departmentCode;
    private String departmentName;
    private String managerName;
    private String phoneNumber;


    public Department() {
    }

    ;

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

    /**
     *
     * @return Danh sách phòng ban
     */
    public static List<Department> getAllDepartment() {
        try {

            //Chuẩn bị câu lệnh truy vấn
            String sql = "SELECT d.*,e.EmployeeName AS ManageName FROM department d  left JOIN employee e ON  d.DepartmentID=e.DepartmentID AND e.IsManage = 1";
            //Khởi tạo kết nối
            Statement statement = MySQLConnection.getStatement();

            //Thực hiện truy vấn, lấy ra dữ liệu
            ResultSet resultSet = statement.executeQuery(sql);

            //Khởi tạo list phòng ban
            List<Department> departmentList = new ArrayList<>();
            while (resultSet.next()) {

                Department department = new Department();
                department.setDepartmentID(resultSet.getString("DepartmentID"));
                department.setDepartmentCode(resultSet.getString("DepartmentCode"));
                department.setDepartmentName(resultSet.getString("DepartmentName"));
                department.setPhoneNumber(resultSet.getString("PhoneNumber"));
                department.setManagerName(resultSet.getString("ManageName"));
                departmentList.add(department);

            }
            //Thực hiện đóng kết nối
            statement.close();
            return departmentList;
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return new ArrayList<Department>();
    }

    /**
     * Thêm mới phòng ban
     * @return trả về true nếu thêm thành công
     */
    public boolean insertDepartment() {
        try {
            //Chuẩn bị câu lệnh truy vấn dữ liệu
            String sql = "INSERT INTO department (DepartmentID,DepartmentCode,DepartmentName,PhoneNumber)" +
                    "Values ('" + departmentID + "','" + departmentCode + "','" + departmentName + "','" + phoneNumber + "')";
            //Khởi tạo kết nối đến database (Muộn nhất có thể
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn , lấy ra số bản ghi bị ảnh hưởng
            int number = statement.executeUpdate(sql);
            //Thực hiện đóng kết nối
            statement.close();
            if (number > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return false;
    }

    /**
     * Sửa phòng ban
     * @return trả về true nếu sửa thành công
     */
    public boolean updateDepartment() {
        try {
            //Chuẩn bị câu lệnh sql
            String sql = "UPDATE department SET DepartmentCode='" + departmentCode + "',DepartmentName='" + departmentName + "',PhoneNumber='" + phoneNumber + "' WHERE DepartmentID='" + departmentID + "'";
            //Khởi tạo kết nối
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào database
            int number = statement.executeUpdate(sql);
            //Thực hiện đóng kết nố
            statement.close();
            if (number > 0) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return false;
    }

    /**
     * Xóa phòng ban
     * @return true nếu xóa thành công
     */
    public boolean deleteDepartment() {
        try {

            //Chuẩn bị câu lệnh
            String sql = "DELETE FROM department WHERE DepartmentID='" + departmentID + "'";
            //Khởi tạo kết nối đến database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào database
            int number = statement.executeUpdate(sql);
            //Thực hiện đóng kết nối
            statement.close();
            if (number > 0) {
                return true;
            }
        } catch (Exception SQLIntegrityConstraintViolationException) {


            return false;

        }

        return false;

    }




    /**
     * Kiểm tra mã phòng ban tồn tại trong hệ thống chưa
     * @param empCode
     * @param id
     * @return
     */
    public static  boolean checkDuplicateCode(String departCode ,  String id ){
        try {

            //chuẩn bị câu lệnh truy vấn
            String sql="";
            if(id==null){
                sql = "SELECT * FROM department WHERE DepartmentCode = '" + departCode + "' ";
            }
            else {
                sql = "SELECT * FROM department WHERE DepartmentCode = '" + departCode + "' AND EmployeeID != '" + id + "'";

            }
            //Khởi tạo kết nối đến database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào DB và lấy ra  số bản ghi bị ảnh hưởng
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return true;
            }
            //Thực hiện đóng kết nối
            statement.close();
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }
        return false;
    }


}
