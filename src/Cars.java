import java.util.ArrayList;

public class Cars {
    public static void main(String[] args) {
        ArrayList<String> cars  = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("Mustang");
        cars.add("Benz");
        // use the forEach while dodging the lambda expression
        cars.forEach(System.out::println);
        // use the lambda expression to print the contents of an ArrayList
        cars.forEach((i) -> {
            System.out.println(i);
        });
        // use the ordinary forEach loop to print the contents of an ArrayList
        for (String i : cars) {
            System.out.println(i);
        }

    }
}
