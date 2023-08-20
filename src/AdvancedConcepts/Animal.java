package AdvancedConcepts;
// implementing polymorphism
public class Animal {
    public void animalSound() {
        System.out.println("The animal makes some sound");
    }
}
class Pig extends Animal {
    public void animalSound() {
        System.out.println("The pig says wee wee");
    }
}
class Dog extends Animal {
    public void animalSound() {
        System.out.println("The dog says bwo bwo");
    }
}
class myMain {
    public static void main(String[] args) {
        // create the Animal object
        Animal myAnimal = new Animal();
        Animal myPig = new Pig();
        Animal myDog = new Dog();
        myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound();
    }

}
