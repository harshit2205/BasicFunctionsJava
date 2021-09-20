package Controller;

public class JavaCloning {
    public static void main(String[] args) {
        Department dep = new Department("chaupati", "Lanka", 10);
        Person person = new Person(10, "name", 14, dep);
        person.getDep().street = "laksman chola";
        System.out.println(person);

    }
}

final class Person{
    private final int id;
    private final String name;
    private final int age;
    private Department dep;

    public Person(int id, String name, int age, Department dep) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dep = dep;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Department getDep() {
        return dep;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dep=" + dep.toString() +
                '}';
    }

    public Person clone() throws CloneNotSupportedException {
        Person value = (Person) super.clone();
        value.dep = this.dep.clone();
        return value;
    }
}
