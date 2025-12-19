package week1.task1;

public class Employee {

    private int empId;
    private String name;
    private String department;
    private double salary;

    public Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void work() {
        System.out.println(name + " is working");
    }

    public void getSalary() {
        System.out.println("Salary: " + salary);
    }

    public void displayInfo() {
        System.out.println(this.toString());
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name +
                ", department=" + department + ", salary=" + salary + "]";
    }
}
