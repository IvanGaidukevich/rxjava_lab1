import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);
        System.out.println(numbers);

        Collections.reverse(numbers);
        System.out.println(numbers);

    }
}
