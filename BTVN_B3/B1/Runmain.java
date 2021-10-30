package B1;

public class Runmain {
    public static void main(String[] args) {
        Person Person = new Person("Nguyễn Hoàng Nguyên", 19, "Nam", "Thích nhiều thứ");
        System.out.println(Person);
        System.out.println(Person.toString());
        Person.setName("Who?");
        System.out.print("Name = " + Person.getName() + ", ");
        Person.setAge(21);
        System.out.print("Age = " + Person.getAge() + ", ");
        Person.setGender("Nữ");
        System.out.print("Gender = " + Person.getGender() + ", ");
        Person.setHobby("I don't know");
        System.out.println("Hobby = " + Person.getHobby());
        System.out.println(Person.toString());
    }
}
