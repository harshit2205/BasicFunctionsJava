package Controller;

public class ImmutableClass {

    public static void main(String[] args) {
        //checking the immutability of class variable of a class..
        Department address = new Department("Raj Bharti Gali", "Bhagwanpur", 221005);
        final Employee e = new Employee("Harshit", "Varanasi", address);
        e.name = "kancha";
        //below statement is not possible but above statement works fine.. because its elements are not final.
        // e = new Employee("Harshit", "Varanasi", address);
        System.out.println(e.name);
    }
}

class Employee{
    public String name;
    public String location;
    public Department address;

    public Employee(String name, String location, Department address){
        this.name = name;
        this.location = location;
        this.address = address;
    }
}

class Department {
    public String street;
    public String address;
    public int zip;
    public Department(String street, String address, int zip){
        this.street = street;
        this.address = address;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Department{" +
                "street='" + street + '\'' +
                ", address='" + address + '\'' +
                ", zip=" + zip +
                '}';
    }

    public Department clone() throws CloneNotSupportedException {
        return (Department) super.clone();
    }
}
