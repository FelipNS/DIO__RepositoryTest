package com.example.Sets;

import java.util.Iterator;
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
        
        Iterator<Color> it = rainbowColors.iterator();
        while (it.hasNext()) {
            Color color = it.next();
            System.out.println(color.getName());
        }
        System.out.println("=========================");
        
        System.out.println(rainbowColors.size());
        System.out.println("=========================");
        
        Set<Color> sortedRainbowColors = new TreeSet<>(rainbowColors);
        Iterator<Color> it2 = sortedRainbowColors.iterator();
        while (it2.hasNext()) {
            Color color = it2.next();
            System.out.println(color.getName());
        }
        System.out.println("=========================");

        TreeSet<Color> reversedRainbomColor = new TreeSet<>(rainbowColors);
        Iterator<Color> it3 = reversedRainbomColor.descendingIterator();
        while (it3.hasNext()) {
            Color color = it3.next();
            System.out.println(color.getName());
        }
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
        return this.name.hashCode();
    }

    @Override
    public int compareTo(Color o) {
        return this.name.compareTo(o.name);
    }
}