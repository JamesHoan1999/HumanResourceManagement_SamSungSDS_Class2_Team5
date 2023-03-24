package entity;


import base.MySQLConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    //Property
    private String employeeID;
    private String employeeCode;
    private String employeeName;
    private String departmentID;
    private String departmentName;
    private String positionName;
    private String address;
    private Date dateOfBirth;
    private int gender;
    private String genderName;
    private String identityNumber;
    private String telephoneNumber;
    private String email;
    private String bankAccountNumber;
    private String bankName;
    private Integer isManage;
    private String isManagerTxt;
    private double salary;
    private double tax;

    //Constructor

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getIsManage() {
        return isManage;
    }

    public void setIsManage(Integer isManage) {
        this.isManage = isManage;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getIsManagerTxt() {
        return isManagerTxt;
    }

    public void setIsManagerTxt(String isManagerTxt) {
        this.isManagerTxt = isManagerTxt;
    }


    public Employee(String employeeID, String employeeCode, String employeeName, String departmentID, String departmentName, String positionName, String address, Date dateOfBirth, int gender, String identityNumber, String telephoneNumber, String email, String bankAccountNumber, String bankName, Integer isManage, String isManagerTxt, double salary, double tax) {
        this.employeeID = employeeID;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.positionName = positionName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;

        this.identityNumber = identityNumber;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.isManage = isManage;

        this.salary = salary;
        this.tax = tax;
    }

    public Employee() {
    }

    /**
     * Lấy tất cả danh sách nhân viên
     * @return danh sách nhân viên
     */
    public static List<Employee> getAllEmployees() {
        try {


            //Chuẩn bị câu lệnh truy vấn
            String sql = "SELECT e.*,d.DepartmentName from employee e left JOIN department d ON  e.DepartmentID=d.DepartmentID  ";
            //Khởi tạo kết nối đến database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào database
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
     * Lấy danh sách nhân viên thuộc phòng ban
     * @param departmentID id phòng ban muốn lấy danh sách nhân viên
     * @return danh sách nhân viên của phòng ban đó
     */
    public static List<Employee> getEmployeesByDepartmentID(String departmentID) {
        try {

            //Chuẩn bị câu lệnh sql
            String sql = "SELECT e.*,d.DepartmentName from employee e left JOIN department d ON  e.DepartmentID=d.DepartmentID where e.DepartmentID='" + departmentID + "' ";
            //Khởi tạo kết nối đến databsae
            Statement statement = MySQLConnection.getStatement();

            //Thực hiện truy vấn vào database
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
     * Lấy danh sách nhân viên chưa có phòng ban
     * @return danh sách nhân viên chưa thuộc phòng ban nào
     */
    public static List<Employee> getEmployeesHasNotDepartmentID() {
        try {

            //Chuẩn bị câu lệnh sql
            String sql = "SELECT * from employee e where e.DepartmentID is null";
            //Khởi tạo kết nối đến database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào database
            ResultSet resultSet = statement.executeQuery(sql);


            //Khởi tạo list nhân viên
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
     * Tìm kiếm nhân viên theo mã ,tên,sdt hoặc email
     * @param keySearch từ khóa tìm kiếm nhân viên
     * @return danh sách nhân viên
     */
    public static List<Employee> searchEmployees(String keySearch) {
        try {

            //Chuẩn bị câu lệnh truy vấn
            String sql = "SELECT e.*,d.DepartmentName from employee e left JOIN department d ON  e.DepartmentID=d.DepartmentID  where  e.EmployeeCode LIKE '%" + keySearch + "%' OR e.EmployeeName like '%" + keySearch + "%' OR e.TelephoneNumber LIKE '%" + keySearch + "%' OR e.Email LIKE '%" + keySearch + "%' ;";
            //Khởi tạo kết nối đến database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào database
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
     *
     * @return true nếu thêm thành công nhân  viên
     */
    public boolean insertEmployee() {
        try {

            String sql="";
            java.sql.Date date = null;

            if (dateOfBirth!=null ){
                //Chuyển kiểu date java về date sql
                date = new java.sql.Date(dateOfBirth.getTime());
                sql = "INSERT INTO employee(EmployeeID,EmployeeCode,EmployeeName,DepartmentID,PositionName,Address,Gender,DateOfBirth,IdentityNumber,TelephoneNumber,Email,BankAccountNumber,BankName,IsManage,Salary,Tax) " +
                        " Values ('" + employeeID + "','" + employeeCode + "','" + employeeName + "','" + departmentID + "','" + positionName + "','" + address + "'," + gender + ",'" + date + "','" + identityNumber + "','" + telephoneNumber + "','" + email + "','" + bankAccountNumber + "','" + bankName + "'," + isManage + ",'" + salary + "','" + tax + "')";

            }
            else {
                sql = "INSERT INTO employee(EmployeeID,EmployeeCode,EmployeeName,DepartmentID,PositionName,Address,Gender,IdentityNumber,TelephoneNumber,Email,BankAccountNumber,BankName,IsManage,Salary,Tax) " +
                        " Values ('" + employeeID + "','" + employeeCode + "','" + employeeName + "','" + departmentID + "','" + positionName + "','" + address + "'," + gender  + ",'" + identityNumber + "','" + telephoneNumber + "','" + email + "','" + bankAccountNumber + "','" + bankName + "'," + isManage + ",'" + salary + "','" + tax + "')";
            }





            //Chuẩn bị câu lệnh truy vấn

            //Khởi tạo kết nối đến Database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào DB và lấy ra  số bản ghi bị ảnh hưởng
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
     * Cập nhật thông tin nhân viên
     * @return true nếu cập nhật thành công
     */
    public boolean updateEmployee() {
        try {
            String sql="";
            java.sql.Date date = null;

            if (dateOfBirth!=null ){
                //Chuyển kiểu date java về date sql
                date = new java.sql.Date(dateOfBirth.getTime());
                sql = "UPDATE employee SET EmployeeCode='" + employeeCode + "',EmployeeName='" + employeeName + "',DepartmentID='" + departmentID + "',PositionName='" + positionName + "',Address='" + address + "',DateOfBirth='" + date + "',IdentityNumber='" + identityNumber + "',TelephoneNumber='" + telephoneNumber + "',Email='" + email + "',BankAccountNumber='" + bankAccountNumber + "',BankName='" + bankName + "',IsManage='" + isManage + "',Salary='" + salary + "',Tax='" + tax + "' WHERE EmployeeID='" + employeeID + "'";

            }
            else {
                sql = "UPDATE employee SET EmployeeCode='" + employeeCode + "',EmployeeName='" + employeeName + "',DepartmentID='" + departmentID + "',PositionName='" + positionName + "',Address='" + address + "',IdentityNumber='" + identityNumber + "',TelephoneNumber='" + telephoneNumber + "',Email='" + email + "',BankAccountNumber='" + bankAccountNumber + "',BankName='" + bankName + "',IsManage='" + isManage + "',Salary='" + salary + "',Tax='" + tax + "' WHERE EmployeeID='" + employeeID + "'";

            }

            //Chuẩn bị câu lệnh truy vấn
            //Khởi tạo kết nối đến database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào DB và lấy ra  số bản ghi bị ảnh
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
     * Xóa nhân viên
     * @return true nếu xóa thành công
     */
    public boolean deleteEmployee() {
        try {

            //Chuẩn bị câu lệnh truy vấn
            String sql = "DELETE FROM employee WHERE EmployeeID='" + employeeID + "'";
            //Khởi tạo kết nối đến database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào DB và lấy ra  số bản ghi bị ảnh hưởng
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
     * Chuyển phòng ban cho nhân viên (Nếu là trưởng phòng cũ thì cần xóa đi)
     * @param departmentID ID phòng ban muốn chuyển tới
     * @return true nếu chuyển phòng ban cho nhân viên thành công
     */
    public boolean updateDepartmentEmployee(String departmentID) {
        try {

          //Chuẩn bị câu lệnh truy vấn
            String sql = "UPDATE  employee SET DepartmentID='" + departmentID + "' , IsManage = null where EmployeeID='" + employeeID + "'";
            //Khởi tạo kết nối đến DB
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào DB và lấy ra  số bản ghi bị ảnh
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
     * Bổ nhiệm trưởng phòng
     * @return true nếu thực hiện thành công
     */
    public boolean updateManageEmployee() {
        try {

           //Chuẩn bị câu lệnh truy ấn
            String sql1 = "UPDATE  employee SET  IsManage = null where DepartmentID='" + departmentID + "' AND IsManage = 1 ;";

              String sql2   =   "UPDATE employee SET IsManage =1 where EmployeeID='" + employeeID + "';";
            //Khởi tạo kết nối đến database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào DB và lấy ra  số bản ghi bị ảnh
            int number = statement.executeUpdate(sql1);
            //Thực hiện đóng kết nối


                int number2=statement.executeUpdate(sql2);
                if(number2>0){
                    return true;
                }
                return false;

            //Thực hiện đóng kết nối
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return false;
    }


    /**
     * Xóa nhân viên khỏi phòng ban
     * @return true nếu xóa thành công
     */
    public boolean releaseEmployeeFromDepartment() {
        try {

            //chuẩn bị câu lệnh truy vấn
            String sql = "UPDATE  employee SET DepartmentID=null , IsManage = null where EmployeeID='" + employeeID + "'";
            //Khởi tạo kết nối đến database
            Statement statement = MySQLConnection.getStatement();
            //Thực hiện truy vấn vào DB và lấy ra  số bản ghi bị ảnh hưởng
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
     * kiểm tra xem email đã tồn tại trong hệ thống chưa
     * @param email
     * @param id
     * @return boolean
     */
    public static  boolean checkDuplicateEmail(String email ,  String id ){
        try {

            //chuẩn bị câu lệnh truy vấn
            String sql="";
            if(id==null){
              sql = "SELECT * FROM employee WHERE email = '" + email + "' ";
            }
            else {
                sql = "SELECT * FROM employee WHERE email = '" + email + "' AND EmployeeID != '" + id + "'";

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

    /**
     * Kiểm tra mã nhân viên tồn tại trong hệ thống chưa
     * @param empCode
     * @param id
     * @return
     */
    public static  boolean checkDuplicateCode(String empCode ,  String id ){
        try {

            //chuẩn bị câu lệnh truy vấn
            String sql="";
            if(id==null){
              sql = "SELECT * FROM employee WHERE EmployeeCode = '" + empCode + "' ";
            }
            else {
                sql = "SELECT * FROM employee WHERE EmployeeCode = '" + empCode + "' AND EmployeeID != '" + id + "'";

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

    /**
     * Kiểm tra số cccd nhân viên tồn tại trong hệ thống chưa
     * @param identityNumber
     * @param id
     *
     */
    public static  boolean checkDuplicateIdentityNumber(String identityNumber ,  String id ){
        try {

            //chuẩn bị câu lệnh truy vấn
            String sql="";
            if(id==null){
              sql = "SELECT * FROM employee WHERE IdentityNumber = '" + identityNumber + "' ";
            }
            else {
                sql = "SELECT * FROM employee WHERE IdentityNumber = '" + identityNumber + "' AND EmployeeID != '" + id + "'";

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
