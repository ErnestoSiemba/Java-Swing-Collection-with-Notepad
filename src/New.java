import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class New{
    public static void main(String[] args) {
        String myStr1= "Hello";
        String myStr2 = "Hello";
        char result = myStr1.charAt(0);
        System.out.println(result);
        System.out.println(myStr1.compareTo(myStr2));
        System.out.println(myStr1.equals(myStr2));

        String firstname = "Ernest ";
        String lastname = "Junior";
        System.out.println(firstname.concat(lastname));

//        compareToIgnoreCase()
        String hello = "Hello, world";
        String HELLO = "HELLO WORLD";
        System.out.println(HELLO.toLowerCase());
        System.out.println(hello.compareToIgnoreCase(HELLO)); //returns 0 since the strings are the same.
        System.out.println(hello.contains("el")); //returns a boolean value
        System.out.println(hello.startsWith("Hell"));
        System.out.println(hello.endsWith("ld")); // checks if a given string ends with a specified sequence of characters
        // contentEqual() method
        System.out.println(hello.contentEquals("Hello world"));

        // Java date and time
        LocalDate myObj = LocalDate.now();
        System.out.println("The date is : " +myObj);

        LocalTime myTime = LocalTime.now();
        System.out.println("The time is: " + myTime);

        LocalDateTime datetime = LocalDateTime.now();
        System.out.println("The current date and time is: " + datetime);

//        Formatting date and time to remove the 'T' seperator
//        we use the ofPattern() method to format date and time
        LocalDateTime myDate = LocalDateTime.now();
        System.out.println("Before formatting: " + myDate);

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy hh-mm;ss");
        String formattedDate = myDate.format(myFormat);
        System.out.println("After formatting: " + formattedDate);
        // Regular expressions in java
        Pattern pattern = Pattern.compile("Ernesto", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Ernesto");
        boolean matchFound = matcher.find();
        try {
            if (matchFound) {
                System.out.println("Match found");
            }
            else {
                System.out.println("Match not found");
            }
        }
        catch (Exception ex) {
            System.out.println("Illegal expression was provided, please try again!!");
        }
        finally {
            System.out.println("This is pretty much fun!!");
        }

        // Java lambda
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(5);
        integers.add(7);
        integers.add(9);
        integers.add(3);
//        integers.forEach(System.out::println);
        integers.forEach((i) -> {
            System.out.println(i);
        });

        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("Mustang");
        cars.add("Ford");
        // using a loop to print arraylist items
        for (String car : cars) {
            System.out.println(car);
        }
        // using a lambda expression to print arraylist items
        cars.forEach((i) -> {
            System.out.println(i);
        });

        // using forEach() method declaration to avoid use of lambda
        cars.forEach(System.out::println);

        // java switch
        int day = 4;
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Looking forward to the weekend");
            // outputs Thursday
        }








    }
}
