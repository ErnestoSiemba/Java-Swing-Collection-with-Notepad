package AdvancedConcepts;
// implementing Encapsulation
public class Person {
    private String name;

    // Getter Method
    public String getName() {
        return name;
    }
    // Setter Method
    public void setName(String newName) {
        this.name = newName;
    }
}
class Main {
    public static void main(String[] args) {
        // create the Person object
        Person person = new Person();
        person.setName("John");
        System.out.println(person.getName());

    }
}
