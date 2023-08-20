// abstract class
abstract class myAnimal {
    // abstract method does not have body
    public abstract void animalSound();
    // normal method
    public void sleep() {
        System.out.println("zzzz");
    }
}
// Pig class that inherits from the myAnimal class
class myPig extends myAnimal {

    @Override
    public void animalSound() {
        System.out.println("Animal makes sound");
    }
}
// main class
class animalMain {
    public static void main(String[] args) {

        // create an object of the pig class
        myPig pig = new myPig();
        pig.animalSound();
        pig.sleep();
    }
}