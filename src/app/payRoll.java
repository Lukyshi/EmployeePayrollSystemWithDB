package app;
import model.EmployeeInfo;

public class payRoll{
    private int id;
    private int EmployeeId;
    private double basicSalary;
    private double deduction;
    private double net_salary;
    private String name;
    private String position;
    private double salary;

    public payRoll(int id, int employeeId, double basicSalary, double deductions, double net_salary){
        this.id = id;
        this.EmployeeId = employeeId;
        this.basicSalary = basicSalary;
        this.deduction = deductions;
        this.net_salary = net_salary;
    }

    public payRoll(int EmployeeId, double basicSalary, double deduction, double net_salary) {
        this.EmployeeId = EmployeeId;
        this.basicSalary = basicSalary;
        this.deduction = deduction;
        this.net_salary = net_salary;
    }

    public payRoll(EmployeeInfo employeeInfo, int id, double basicSalary,
                   double deduction, double net_salary) {
        this.EmployeeId = employeeInfo.getId();
        this.id = id;
        this.name = employeeInfo.getName();
        this.position = employeeInfo.getPosition();
        this.salary = basicSalary;
        this.basicSalary = basicSalary;
        this.deduction = deduction;
        this.net_salary = net_salary;

    }

    public int getId(){
        return id;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getDeduction() {
        return deduction;
    }

    public double getNet_salary() {
        return net_salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

}

