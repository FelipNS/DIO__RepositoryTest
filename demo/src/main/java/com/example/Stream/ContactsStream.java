package com.example.Stream;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;

public class ContactsStream {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {{
           put(1, new Contato("Simba", 5555));
           put(4, new Contato("Cami", 1111));
           put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda);
        agenda.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>() {{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("Jon", 2222));
        }};
        System.out.println(agenda1);
        agenda1.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        agenda2.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("--\tOrdem número telefone\t--");
        //precisamos organizar os valores. Logo:
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumber()));
        set.addAll(agenda.entrySet());
        set.forEach(System.out::println);
        

        System.out.println("--\tOrdem name contato\t--");
        //precisamos organizar os valores. Logo:
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(
            new Function<Map.Entry<Integer, Contato>, String>() {
                @Override
                public String apply(Map.Entry<Integer, Contato> o) {
                    return o.getValue().getName();
                }
            }
        ));
        set1.addAll(agenda.entrySet());
        set1.forEach(System.out::println);
    }
}

class Contato {
    private String name;
    private Integer number;

    public Contato(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return name.equals(contato.name) && number.equals(contato.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}