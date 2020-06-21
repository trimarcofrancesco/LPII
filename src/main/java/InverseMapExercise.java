package main.java;

import java.util.HashMap;
import java.util.Map;

public class InverseMapExercise {

    static <K,V> Map<K,V> inverseMap(Map<V,K> m) {
        Map<K,V> output = new HashMap<>();

        for (Map.Entry<V,K> entry: m.entrySet()) {
            if (!output.containsKey(entry.getValue()))
                output.put(entry.getValue(), entry.getKey());
            else throw new IllegalStateException();
        }

        return output;
    }

    public static void main(String[] args) {
        Map<String, String> test = new HashMap<>();
        test.put("a", "1");
        test.put("d", "1");
        test.put("b", "2");
        test.put("c", "3");
        test.put("d", "4");
        test.put("d", "41");

        System.out.println(test);
        System.out.println(inverseMap(test));

    }
}
