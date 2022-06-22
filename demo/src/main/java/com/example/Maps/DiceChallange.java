package com.example.Maps;

import java.util.HashMap;
import java.util.Map;

public class DiceChallange {
    
    public static void main(String[] args) {
        Map<Integer, Integer> diceDatas = new HashMap<>(){{
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};

        for (int i = 0; i < 100; i++) {
            int dice = (int) (Math.random() * 6 + 1);
            diceDatas.put(dice, diceDatas.get(dice) + 1);
        }
        diceDatas.forEach((key, value) -> System.out.println(key + " : " + value));

        Integer sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += diceDatas.get(i);
        }
        System.out.println("Sum : " + sum);
    }
}