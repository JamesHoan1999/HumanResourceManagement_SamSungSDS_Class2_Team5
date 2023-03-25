package entity;

import base.MethodBase;
import base.MySQLConnection;
import enumCommon.SortEnum;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Statistics {

    /**
     * @return Danh sách phòng ban
     */
    public static List<Employee> getTopEmployees(SortEnum sort) {
        try {

            //Chuẩn bị câu lệnh truy vấn
            String sql = "SELECT e.*,d.DepartmentName from employee e left JOIN department d ON  e.DepartmentID=d.DepartmentID ORDER BY e.salary " + sort + " LIMIT 5 ";

            //Khởi tạo kết nối
            Statement statement = MySQLConnection.getStatement();

            //Thực hiện truy vấn, lấy ra dữ liệu
            ResultSet resultSet = statement.executeQuery(sql);

            //Khởi tại list nhân viên
            List<Employee> employeeList = new ArrayList<>();
            //lấy dữ liệu từ database rồi add vào employeeList
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmployeeID(resultSet.getString("employeeID"));
                employee.setEmployeeCode(resultSet.getString("employeeCode"));
                employee.setEmployeeName(resultSet.getString("employeeName"));
                employee.setDepartmentID(resultSet.getString("departmentID"));
                employee.setPositionName(resultSet.getString("positionName"));
                employee.setAddress(resultSet.getString("address"));
                employee.setDateOfBirth(resultSet.getDate("dateOfBirth"));
                employee.setGender(resultSet.getInt("gender"));
                employee.setIdentityNumber(resultSet.getString("identityNumber"));
                employee.setTelephoneNumber(resultSet.getString("telephoneNumber"));
                employee.setEmail(resultSet.getString("email"));
                employee.setBankAccountNumber(resultSet.getString("bankAccountNumber"));
                employee.setBankName(resultSet.getString("bankName"));
                employee.setIsManage(resultSet.getInt("isManage"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setTax(resultSet.getDouble("tax"));
                employee.setDepartmentName(resultSet.getString("departmentName"));

                employeeList.add(employee);
            }
            //Thực hiện đóng kết nối
            statement.close();
            return employeeList;
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return new ArrayList<Employee>();
    }

    /**
     * Thống kê số lượng nhân viên mỗi phòng ban
     */
    public static void showQuantityEmployeeOfDepartment() {
        try {

            //Chuẩn bị câu lệnh truy vấn
            String sql = "SELECT d.DepartmentName,COUNT(e.DepartmentID) AS employeeQuantity FROM department d  LEFT JOIN employee e ON  d.DepartmentID=e.DepartmentID  GROUP BY d.DepartmentID ORDER BY employeeQuantity ;";
            //Khởi tạo kết nối
            Statement statement = MySQLConnection.getStatement();

            //Thực hiện truy vấn, lấy ra dữ liệu
            ResultSet resultSet = statement.executeQuery(sql);

            //Khởi tại list nhân viên
            List<Employee> employeeList = new ArrayList<>();
            System.out.println("-----------------------------------------------");



            System.out.printf("%-3s%-20s%-3s%-20s%-3s","|", "Tên phòng ban","|", "Số lượng nhân viên","|");
            System.out.println();
            System.out.println("-----------------------------------------------");


            //lấy dữ liệu từ database rồi add vào employeeList
            while (resultSet.next()) {
                System.out.printf("%-3s%-20s%-3s%-20s%-3s","|", resultSet.getString("DepartmentName"),"|", resultSet.getInt("employeeQuantity"),"|");
                System.out.println();
                System.out.println("-----------------------------------------------");


            }
            //Thực hiện đóng kết nối
            statement.close();

        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


    }


    /**
     * @return Danh sách phòng ban
     */
    public static void showAVGDepartmentSalary() {
        try {

            //Chuẩn bị câu lệnh truy vấn
            String sql = "SELECT d.DepartmentName,AVG(e.Salary) AS avgSalary FROM department d  LEFT JOIN employee e ON  d.DepartmentID=e.DepartmentID  GROUP BY d.DepartmentID ORDER BY avgSalary DESC;";
            //Khởi tạo kết nối
            Statement statement = MySQLConnection.getStatement();

            //Thực hiện truy vấn, lấy ra dữ liệu
            ResultSet resultSet = statement.executeQuery(sql);

            //Khởi tại list nhân viên
            List<Employee> employeeList = new ArrayList<>();
            System.out.println(" Lương trung bình của mỗi phòng ban");
            System.out.println("-----------------------------------------------");

            System.out.printf("%-3s%-20s%-3s%-20s%-3s","|", "Tên phòng ban","|", "Tiền lương trung bình","|");
            System.out.println();
            System.out.println("-----------------------------------------------");


            //lấy dữ liệu từ database rồi add vào employeeList
            while (resultSet.next()) {
                System.out.printf("%-3s%-20s%-3s%-20s%-3s","|", resultSet.getString("DepartmentName"),"|", MethodBase.getSalaryString(resultSet.getDouble("avgSalary")),"|" );
                System.out.println();
                System.out.println("-----------------------------------------------");


            }
            //Thực hiện đóng kết nối
            statement.close();

        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


    }


}
