package B1;

public class RunMain {
    public static void main(String[] args) {
        Person person1 = new Employee("Nguyen", "BG", 1);
        Person person2 = new Customer("Nguyen", "BG", 2);
        person1.display();
        person2.display();
    }
}
