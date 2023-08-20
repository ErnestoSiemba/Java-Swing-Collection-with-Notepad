// interfaces don't have a method body
interface Animal {
    public void animalSound();
    public void sleep();
}
class Pig implements Animal {

    @Override
    public void animalSound() {
        System.out.println("The Pig says: wee wee");
    }

    @Override
    public void sleep() {
        System.out.println("The sleeps: zzzz");

    }
}
class myMain {
    public static void main(String[] args) {
        // create the pig class object
        Pig pig = new Pig();
        pig.sleep();
        pig.animalSound();
    }
}