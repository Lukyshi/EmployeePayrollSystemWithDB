import java.awt.*;
import java.util.Scanner;
import dao.EmployeeDAO;
import app.payRoll;
import model.EmployeeInfo;
import java.util.List;

// add employees
// add payrolls
// view all employees
//view payroll records
//update employeesInfo
//update payroll
//view EmployeesPayroll
//fired employees

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        EmployeeDAO employees = new EmployeeDAO();

        int choice;

        do {
            System.out.println("EmployeePayrollSystem/");
            System.out.println("1. Add employee");
            System.out.println("2. Add Payrolls");
            System.out.println("3. View Employee Records");
            System.out.println("4. View Payroll Records");
            System.out.println("5. Update Employees Info");
            System.out.println("6. Update Payroll");
            System.out.println("7. View EmployeesPayroll");
            System.out.println("8. Fired Employee");
            System.out.println("9. exit ");

            System.out.print("Enter your choice : ");
            choice = scan.nextInt();

            scan.nextLine();

            switch (choice) {
                case 1 :
                    System.out.print("Enter name : ");
                    String name = scan.nextLine();

                    System.out.print("Enter position : ");
                    String position = scan.nextLine();

                    System.out.print("Enter Salary : ");
                    double salary = scan.nextDouble();

                    employees.addEmployees(new EmployeeInfo(name, position, salary));
                    break;

                case 2:
                    System.out.print("Enter Employee ID : ");
                    int idEm = scan.nextInt();

                    System.out.print("Enter basic_salary : ");
                    double bSalary = scan.nextDouble();

                    System.out.print("Enter deductions : ");
                    double deductions = scan.nextDouble();

                    System.out.print("Enter net_salary : ");
                    double netSalary = scan.nextDouble();

                    employees.addPayrolls(new payRoll(idEm, bSalary, deductions, netSalary));

                    break;

                case 3 :
                    List<EmployeeInfo> empoList = employees.viewAllEmployees();
                    if(empoList.isEmpty()) {
                        System.out.print("EmployeesInfo not found");
                    }else {
                        for(EmployeeInfo emp : empoList){
                            System.out.print(emp.getId() + "|" + emp.getName() +
                                    "|" + emp.getPosition() + "|" + emp.getSalary() + "|" +
                                    emp.getHire_date());
                        }
                    }
                    break;

                case 4 :
                    List<payRoll> payrollList = employees.viewAllPayRoll();
                    if(payrollList.isEmpty()) {
                        System.out.println("payroll not found");
                    }else{
                        for(payRoll pays : payrollList) {
                            System.out.print(pays.getId() + "|" + pays.getEmployeeId() + "|"
                            + pays.getBasicSalary() + "|" + pays.getDeduction() + "|" +
                                    pays.getNet_salary());
                        }
                    }

                    break;


                case 5 :
                    System.out.print("Enter EmployeeId : ");
                    int id = scan.nextInt();

                    scan.nextLine();

                    System.out.print("Enter new employee name : ");
                    String newName = scan.nextLine();

                    System.out.print("Enter new positions : ");
                    String newPositions = scan.nextLine();

                    System.out.print("Enter your salary : ");
                    double newSalary = scan.nextDouble();


                    employees.employeeUpdate(id, newName, newPositions, newSalary);

                    break;

                case 6:
                    System.out.print("Enter payrollId : ");
                    int pId = scan.nextInt();

                    System.out.print("Enter Basic Salary : ");
                    double B_salary = scan.nextDouble();

                    System.out.print("Enter new Deductions : ");
                    double deDuc = scan.nextDouble();

                    System.out.print("Enter new Net Salary : ");
                    double netSal = scan.nextDouble();

                    employees.payrollUpdate(pId, B_salary, deDuc, netSal);

                    break;

                case 7 :
                    System.out.print("Enter the employee id to see payroll : ");
                    int empoId = scan.nextInt();

                    payRoll payroll = employees.viewEmployeePayroll(empoId);

                    if(payroll != null){
                        System.out.println(payroll.getEmployeeId() + "|" + payroll.getId() + "|" +
                                payroll.getName() + "|" + payroll.getPosition() + "|" + payroll.getSalary() +
                                "|" + payroll.getBasicSalary() + "|" + payroll.getDeduction() + "|" +
                                payroll.getNet_salary());
                    }else{
                        System.out.println("Not found");
                    }
                    break;

                case 8 :
                    System.out.print("Enter the id you want to fired : ");
                    int firedId = scan.nextInt();

                    employees.firedEmployee(firedId);
                    break;

                case 9 :
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;

            }

        }while(choice != 9);

        scan.close();

    }
}