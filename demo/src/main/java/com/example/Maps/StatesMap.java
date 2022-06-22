package com.example.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatesMap {
    
    public static void main(String[] args) {
        Map<String, Integer> states = new HashMap<>() {{
            put("California", 9616621);
            put("Texas", 3351543);
            put("New York", 9187103);
            put("Florida", 3534265);
        }};

        System.out.println("Replace Florida population");
        states.replace("Florida", 3534165);
        states.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("<--------------------------------->");
        
        System.out.println("There is state with name: Massachusetts");
        if (states.containsKey("Massachusetts")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
            states.put("Massachusetts", 4039277);
            System.out.println("Stated added");
        }
        System.out.println("<--------------------------------->");
        
        System.out.println("Population of California: " + states.get("California"));
        System.out.println("<--------------------------------->");
        
        Map<String, Integer> states1 = new LinkedHashMap<>() {{
            put("California", 9616621);
            put("Texas", 3351543);
            put("New York", 9187103);
            put("Florida", 3534265);
        }};
        states1.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("<--------------------------------->");
        
        Map<String, Integer> states2 = new TreeMap<>(states1);        
        states2.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("<--------------------------------->");
        
        states.forEach((k, v) -> {
            if (v == Collections.min(states.values())) {
                System.out.println("Smallest population: " + k + ": " + v);
            }
        });
        System.out.println("<--------------------------------->");
        
        states.forEach((k, v) -> {
            if (v == Collections.max(states.values())) {
                System.out.println("Biggest population: " + k + ": " + v);
            }
        });
        System.out.println("<--------------------------------->");
        
        Integer sum = 0;
        Iterator<Map.Entry<String, Integer>> it = states.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> state = it.next();
            sum += state.getValue();
        }
        System.out.println("Sum of all states: " + sum);
        System.out.println("<--------------------------------->");
        
        System.out.println("The mean population of all states: " + (sum / states.size()));
        System.out.println("<--------------------------------->");
        
        List<String> statesToRemove = new ArrayList<>();
        states.forEach((k, v) -> {
            if (v < 4000000) {
                statesToRemove.add(k);
            }
        });
        statesToRemove.forEach(elem -> states.remove(elem));
        states.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("<--------------------------------->");

        states.clear();
        System.out.println(states.isEmpty());
    }
}
