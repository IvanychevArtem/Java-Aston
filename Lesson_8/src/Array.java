import java.util.*;

public class Array {
    public static void array(String[] words) {
        Set<String> set = new HashSet<>(List.of((words)));
        System.out.println(set);
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            int newValue = map.getOrDefault(x, 0) + 1;
            map.put(x, newValue);
        }
        System.out.println(map);
    }
}