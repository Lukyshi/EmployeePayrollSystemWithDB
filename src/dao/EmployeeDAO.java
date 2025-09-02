package dao;
import model.EmployeeInfo;
import app.payRoll;
import Util.DBConnection;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    public void addEmployees(EmployeeInfo employeeInfo){
        String sql = "insert into employees (name, position, salary) " +
                "values (?, ?, ?)";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, employeeInfo.getName());
            statement.setString(2, employeeInfo.getPosition());
            statement.setDouble(3, employeeInfo.getSalary());

            statement.executeUpdate();

        }catch (SQLException e) {
            System.out.println("Failed to add " + e.getMessage());
        }
    }

    public void addPayrolls(payRoll payRolls) {
        String sql = "insert into payroll (employee_id, basic_salary, deductions, net_salary) " +
                "values (?, ?, ?, ?)";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, payRolls.getEmployeeId());
            statement.setDouble(2, payRolls.getBasicSalary());
            statement.setDouble(3, payRolls.getDeduction());
            statement.setDouble(4, payRolls.getNet_salary());

            statement.executeUpdate();

        }catch (SQLException e) {
            System.out.println("add payrolls failed " + e.getMessage());
        }
    }

    public List<EmployeeInfo> viewAllEmployees(){
        String sql = "Select * from employees";
        List<EmployeeInfo> employeeInfos = new ArrayList<>();

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                EmployeeInfo empoInfo = mapRowForEmployeesInfo(rs);
                employeeInfos.add(empoInfo);

            }

        }catch (SQLException e) {
            System.out.println("Viewing failed " + e.getMessage());
        }
        return employeeInfos;
    }

    public EmployeeInfo mapRowForEmployeesInfo(ResultSet rs) throws SQLException {
        return new EmployeeInfo(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("position"),
                rs.getDouble("salary"),
                rs.getTimestamp("hire_date")
        );
    }

    public List<payRoll> viewAllPayRoll(){
        String sql = "SELECT * FROM payroll";
        List<payRoll> payRollList = new ArrayList<>();

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                payRoll payRoll = mapRowForPayroll(rs);
                payRollList.add(payRoll);
            }

        }catch(SQLException e) {
            System.out.println("select from payroll failed "+ e.getMessage());
        }
        return payRollList;
    }

    public payRoll mapRowForPayroll(ResultSet rs) throws SQLException {
        return new payRoll(
                rs.getInt("id"),
                rs.getInt("employee_id"),
                rs.getDouble("basic_salary"),
                rs.getDouble("deductions"),
                rs.getDouble("net_salary")
        );
    }

    public void employeeUpdate(int id, String name, String position, double salary) {
        String sql = "update employees set name = ?, position = ?, salary = ? " +
                "where id = ?";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, name);
            statement.setString(2, position);
            statement.setDouble(3, salary);
            statement.setInt(4, id);

            int rows = statement.executeUpdate();
            if(rows > 0 ) {
                System.out.print("Product Update Successfully");
            }else{
                System.out.print("Product Update failed");
            }

        }catch(SQLException e) {
            System.out.println("Updating failed "+ e.getMessage());
        }
    }

    public void payrollUpdate(int id, double basicSalary,
                              double deduction, double netSalary) {
        String sql = "update payroll set basic_salary = ?, deductions = ?, net_salary = ?" +
                "where id = ?";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement  statement = connection.prepareStatement(sql)){

            statement.setDouble(1, basicSalary);
            statement.setDouble(2, deduction);
            statement.setDouble(3, netSalary);
            statement.setInt(4, id);

            int rows = statement.executeUpdate();

            if(rows > 0) {
                System.out.print("Payroll Update Successfully");
            }else{
                System.out.print("Payroll update failed");
            }

        } catch (SQLException e) {
            System.out.println("Update failed "+ e.getMessage());
        }

    }

    public payRoll viewEmployeePayroll(int id) {
        String sql = "SELECT \n" +
                "    e.id AS employee_id,\n" +
                "    e.name,\n" +
                "    e.position,\n" +
                "    e.salary,\n" +
                "    p.basic_salary,\n" +
                "    p.deductions,\n" +
                "    p.net_salary\n" +
                "FROM employees e\n" +
                "JOIN payroll p ON e.id = p.employee_id\n" +
                "WHERE e.id = ?;";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                EmployeeInfo empo = new EmployeeInfo(
                        rs.getInt("employee_id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getDouble("salary")
                );
                return new payRoll(
                        empo,
                        rs.getInt("employee_id"),
                        rs.getDouble("basic_salary"),
                        rs.getDouble("deductions"),
                        rs.getDouble("net_salary")
                );
            }
        }catch(SQLException e) {
            System.out.println("Error searching " + e.getMessage());
        }
        return null;
    }

    public void firedEmployee(int id) {
        String sql = "delete from employees where id = ?";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);

            int row = statement.executeUpdate();

            if(row > 0) {
                System.out.println("Removing employee successfully");
            }
        }catch (SQLException e) {
            System.out.println("Removing failed " + e.getMessage());
        }
    }
}
