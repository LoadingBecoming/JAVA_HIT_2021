package B1;

public class Customer extends Person{
    private int balance;

    public Customer(String name, String address, int balance) {
        super(name, address);
        this.balance = balance;
    }

    @Override
    public void display(){
        System.out.println("Customer Name: " + getName());
        System.out.println("Customer Address: " + getAddress());
        System.out.println("Customer Balance: " + balance);
    }
}
