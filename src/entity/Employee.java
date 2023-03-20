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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", departmentID='" + departmentID + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", identityNumber='" + identityNumber + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", isManage=" + isManage +
                ", salary=" + salary +
                ", tax=" + tax +
                '}';
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

    public  Employee() {}


    public static List<Employee> getAllEmployees() {
        try {

            Connection connection = MySQLConnection.getConnection();


            Statement statement = connection.createStatement();
            String sql="SELECT e.*,d.DepartmentName from employee e JOIN department d ON  e.DepartmentID=d.DepartmentID  ";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Employee> employeeList = new ArrayList<>();
           while (resultSet.next()){
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
           return employeeList;
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return  new ArrayList<Employee>();

    }

    public boolean insertEmployee(){
        try {

            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            java.sql.Date date = new java.sql.Date(dateOfBirth.getTime());
           String sql = "INSERT INTO employee(EmployeeID,EmployeeCode,EmployeeName,DepartmentID,PositionName,Address,Gender,DateOfBirth,IdentityNumber,TelephoneNumber,Email,BankAccountNumber,BankName,IsManage,Salary,Tax) " +
                   " Values ('"+employeeID+"','"+employeeCode+"','"+employeeName+"','"+departmentID+"','"+positionName+"','"+address+"',"+gender+",'"+date+"','"+identityNumber+"','"+telephoneNumber+"','"+email+"','"+bankAccountNumber+"','"+bankName+"',"+isManage+",'"+salary+"','"+tax+"')";
            int number = statement.executeUpdate(sql);
            if (number > 0){
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return  false;
    }

    public boolean updateEmployee(){
        try {

            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();

            java.sql.Date date = new java.sql.Date(dateOfBirth.getTime());
           String sql = "UPDATE employee SET EmployeeCode='"+employeeCode+"',EmployeeName='"+employeeName+"',DepartmentID='"+departmentID+"',PositionName='"+positionName+"',Address='"+address+"',DateOfBirth='"+date+"',IdentityNumber='"+identityNumber+"',TelephoneNumber='"+telephoneNumber+"',Email='"+email+"',BankAccountNumber='"+bankAccountNumber+"',BankName='"+bankName+"',IsManage='"+isManage+"',Salary='"+salary+"',Tax='"+tax+"' WHERE EmployeeID='"+employeeID+"'";
            int number = statement.executeUpdate(sql);
            if (number > 0){
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return  false;
    }

    public boolean deleteEmployee(){
        try {

            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
           String sql = "DELETE FROM employee WHERE EmployeeID='"+employeeID+"'";
            int number = statement.executeUpdate(sql);
            if (number > 0){
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Error : fail");
            ex.printStackTrace();
        }


        return  false;
    }


}
