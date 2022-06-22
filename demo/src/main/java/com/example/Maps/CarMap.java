package com.example.Maps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CarMap {
    public static void main(String[] args) {
        Map<String, Float> cars = new HashMap<>() {{
            put("Gol", 14.4f);
            put("Uno", 15.6f);
            put("Mobi", 16.1f);
            put("HB20", 14.5f);
            put("Kwid", 15.1f);
        }};

        cars.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\n");
        cars.put("Gol", 16.1f);
        cars.forEach((k, v) -> {
            if (k.equals("Gol")) {
                System.out.println(k + ": " + v);
            }
        });

        boolean hasTucson = cars.containsKey("Tucson");
        System.out.println("Tucson: " + hasTucson);
     
        Set<String> keys = cars.keySet();
        System.out.println(keys);

        Collection<Float> values = cars.values();
        System.out.println(values);
        Set<Map.Entry<String, Float>> entries = cars.entrySet();

        Float maxValue = Collections.max(cars.values());
        for (Map.Entry<String, Float> entry : entries) {
            if (entry.getValue().equals(maxValue)) {
                System.out.println("Best model: " + entry.getKey() + ": " + cars.get(entry.getKey()));
            }
        }

        Float minValue = Collections.min(cars.values());
        for (Map.Entry<String, Float> entry : entries) {
            if (entry.getValue().equals(minValue)) {
                System.out.println("Worst model: " + entry.getKey() + ": " + cars.get(entry.getKey()));
            }
        }

        Iterator<Float> it = values.iterator();
        Float sum = 0f;
        while (it.hasNext()) {
            sum += it.next();
        }
        System.out.println("Total: " + sum);

        System.out.println("Median: " + (sum/values.size()));

        List<String> carsToRemove = new ArrayList<>();
        for (Map.Entry<String, Float> entry : entries) {
            Float value = entry.getValue();
            if (value == 15.6f) carsToRemove.add(entry.getKey());
        }
        for (String car : carsToRemove) {
            cars.remove(car);
        }

        System.out.println(cars);
    }
}