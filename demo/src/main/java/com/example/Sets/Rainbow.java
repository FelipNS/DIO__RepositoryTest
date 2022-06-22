package com.example.Sets;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Rainbow {
    
    public static void main(String[] args) {
        Set<Color> rainbowColors = new LinkedHashSet<>() {{
            add(new Color("red"));
            add(new Color("orange"));
            add(new Color("yellow"));
            add(new Color("green"));
            add(new Color("blue"));
            add(new Color("indigo"));
            add(new Color("violet"));
        }}; 
        
        rainbowColors.forEach(color -> System.out.println(color.getName()));
        System.out.println("=========================");
        
        System.out.println(rainbowColors.size());
        System.out.println("=========================");
        
        Set<Color> sortedRainbowColors = new TreeSet<>(rainbowColors);
        sortedRainbowColors.forEach(color -> System.out.println(color.getName()));
        System.out.println("=========================");

        TreeSet<Color> reversedRainbomColor = new TreeSet<>(rainbowColors);
        reversedRainbomColor.descendingSet()
                            .forEach(color -> System.out.println(color.getName()));
    }
} 

class Color implements Comparable<Color> {
    private String name;

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("Color => [name: %s]", this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return this.name.equals(color.name);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public int compareTo(Color o) {
        return this.name.compareTo(o.name);
    }
}