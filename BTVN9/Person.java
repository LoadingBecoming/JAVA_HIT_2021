package BT;

public class Person implements Comparable<Person> {
    private String id,name, address;

    public String getId() {
        return id;
    }

    public String setId(String id) {
        this.id = id;
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Person o) {
        if(this.id.compareTo(o.getId()) > 0) return 1;
        else if(this.id.compareTo(o.getId()) < 0) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

