import java.util.Scanner;

public class ThisJava {

    // initialize variables
    int year;
    String name;


    // create a method called myMethod()
    static void myMethod() {
        System.out.println("this will execute!");
    }

    // method with parameter
    static void methodWithParameter(String fname, int age) {
        System.out.println("The first name is: " + fname + " and my age is " + age);
    }

    static int mySumMethod(int sum) {
        return 5 + sum;
    }

    static void checkAge(int thisage) {
        // if age is less than 18, print access denied!
        if (thisage < 18) {
            System.out.println("Access Denied!1");
        }
        else {
            if (thisage > 18) {
                System.out.println("Access granted, you are eligible to vote!!");
            }
        }

    }

    // Method Overloading - a method has the same name but with different parameters
    static int plusMethod(int y, int z) {
        return y + z;
    }

    static double plusMethod(double y, double z) {
        return y + z;
    }
    public static void main(String[] args) {
        // call the method
        myMethod();

        // a method can also be called multiple times
        myMethod();
        myMethod();
        myMethod();

        // call method with parameter
        methodWithParameter("ernest", 21);
        methodWithParameter("robert", 22);
        System.out.println(mySumMethod(8));

        checkAge(20);

        // create the object of the overloaded method
        int myNum1 = plusMethod(8, 5);
        double myNum2 = plusMethod(4.7, 7.5);
        System.out.println("int: " + myNum1);
        System.out.println("double: " + myNum2);

        // user input using the scanner class
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter your Username, Age, and Salary ");

        // String input
        String myName = obj.nextLine();


        // Numeric input
        int myAge = obj.nextInt();
        double salary = obj.nextDouble();

        // Output input by the user
        System.out.println("Username: " + myName);
        System.out.println("Age: " + myAge);
        System.out.println("Salary:" + salary);

        // using the try and catch blocks
        try {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter a double number: ");
            // Text input
            double doubleNumber = myObj.nextDouble();
            System.out.println("Your double number is: " + doubleNumber);
        }
        catch (Exception ex) {
            System.out.println("Please enter a double number or decimal!!");
        }
        finally {
            System.out.println("This seems not working and am gonna have to correct!!");
        }
        ThisJava myCar = new ThisJava(1967, "Mustang");
        System.out.println(myCar.name + " " +  myCar.year);

    }

    // create a constructor for the main class
    public ThisJava(int year, String name ) {
        this.year = year;
        this.name = name;


    }
}
