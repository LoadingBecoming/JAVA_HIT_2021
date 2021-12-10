package B1;

public class Employee extends Person{
    private int salary;

    public Employee(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    @Override
    public void display(){
        System.out.println("Employee Name: " + getName());
        System.out.println("Employee Address: " + getAddress());
        System.out.println("Employee Salary: " + salary);
    }
}
