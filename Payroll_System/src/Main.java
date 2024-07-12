import java.util.ArrayList;

abstract  class Employee{


    private String name;
    private int id;
    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;

    }
    public int  getId(){
        return id;
    }
    public abstract double calculateSalary();

    public String toString(){
        return "Employee [name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }


}
class FulltimeEmployee extends Employee{
    private double monthlySalary;
    public FulltimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    public double calculateSalary(){
        return monthlySalary;
    }
}
class ParttimeEmployee extends Employee{
    private int hoursworked;
    private double hourlyrate;
    public ParttimeEmployee(String name,int id,int horlyworked,double hourlyrate){
        super(name,id);
        this.hourlyrate=hourlyrate;
        this.hoursworked=hoursworked;
    }
    @Override
    public double calculateSalary(){
        return hoursworked*hourlyrate;
    }
}
class PayrollSystem {
    private ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList=new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        FulltimeEmployee emp1 = new FulltimeEmployee("Mitu", 1, 30000.0);
        ParttimeEmployee emp2 = new ParttimeEmployee("Jitu", 3, 6, 1000);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Employee Details:");
        payrollSystem.displayEmployees();

    }
}