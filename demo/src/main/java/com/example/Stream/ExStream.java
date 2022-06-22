package com.example.Stream;

import java.util.Arrays;
import java.util.List;
//import java.util.OptionalDouble;
//import java.util.Set;
import java.util.stream.Collectors;

public class ExStream {
    public static void main(String[] args) {
        List<String> randomNumbers = Arrays.asList("1", "2", "4", "4", "5", "6", "0", "6", "7");

        //randomNumbers.forEach(System.out::println);

        /*Set<String> firstFiveNumbers = randomNumbers.stream()
                                                    .limit(5)
                                                    .collect(Collectors.toSet());*/
    
        List<Integer> parsedToInteger = randomNumbers.stream()
                                                     .map(Integer::parseInt)
                                                     .collect(Collectors.toList());
        
        /*Set<Integer> evenNumbers = parsedToInteger.stream()
                                                  .filter(n -> n % 2 == 0)
                                                  .collect(Collectors.toSet());*/

        /*OptionalDouble numbersMean = randomNumbers.stream()
                                                  .mapToInt(Integer::parseInt)
                                                  .average();*/

        parsedToInteger.removeIf(n -> n % 2 != 0);
        
        System.out.println(parsedToInteger);
    }
}
