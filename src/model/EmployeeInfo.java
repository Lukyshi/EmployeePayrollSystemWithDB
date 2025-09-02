package model;
import java.sql.Timestamp;

public class EmployeeInfo {
    private int id;
    private String name;
    private String position;
    private double salary;
    private Timestamp hire_date;

    public EmployeeInfo(int id, String name, String position, double salary, Timestamp hire_date){
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.hire_date = hire_date;
    }

   public EmployeeInfo(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public EmployeeInfo(int id,String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public Timestamp getHire_date(){
        return hire_date;
    }

}
