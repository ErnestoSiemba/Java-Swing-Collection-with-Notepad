package AdvancedConcepts;
// implementing Abstraction
abstract class newAnimal {
    public abstract void animalSound();
    // regular method
    public void sleep() {
        System.out.println("The animal is sleeping in a regular method");
    }

}
class newPig extends newAnimal {

    @Override
    public void animalSound() {
        System.out.println("The Pig makes sound - wee wee");
    }
}
class abstractMain {
    public static void main(String[] args) {
        newPig myPig = new newPig();
        myPig.animalSound();
        myPig.sleep();


    }
}
