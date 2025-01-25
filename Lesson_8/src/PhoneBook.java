import java.util.*;

public class PhoneBook {
    static Map<String, List<String>> phone = new HashMap<>();

    public static void add(String name, String number) {
        List<String> numbers = phone.computeIfAbsent(name, k -> new ArrayList<>());
        numbers.add(number);
    }

    public static List<String> get(String name) {
        List<String> numbers = phone.get(name);
        if (numbers == null) {
            return new ArrayList<>();
        }
        return numbers;
    }


}


