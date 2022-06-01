package com.example.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PetList {
    public static void main( String[] args ) {
        List<Pet> meusPets = new ArrayList<Pet>(){{
            add(new Pet("Meg", 12, "Dog", "Black"));
            add(new Pet("Mel", 15, "Dog", "Black"));
            add(new Pet("Leo", 20, "Cat", "Brindle"));
        }};
        Collections.sort(meusPets, new Pet.PetNameComparator());
        System.out.println(meusPets);
        
        System.out.println("========================");

        meusPets.sort(new Pet.PetAgeComparator());
        System.out.println(meusPets);
    }
}

class Pet {
    private String name;
    private int age;
    private String type;
    private String color;

    public Pet(String name, int age, String type, String color){
        this.name = name;        
        this.age = age;        
        this.type = type;        
        this.color = color;        
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getType() {
        return this.type;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \nAge: %d \nType: %s \nColor: %s", this.name, this.age, this.type, this.color);
    }


    public static class PetNameComparator implements Comparator<Pet> {
        
        @Override
        public int compare(Pet p1, Pet p2) {
            return p1.getName().compareToIgnoreCase(p2.getName());
        }
    }

    public static class PetAgeComparator implements Comparator<Pet> {
        
        @Override
        public int compare(Pet p1, Pet p2) {
            return Integer.compare(p1.getAge(), p2.getAge());
        }
    } 
    public static class PetColorComparator implements Comparator<Pet> {
        
        @Override
        public int compare(Pet p1, Pet p2) {
            return p1.getColor().compareToIgnoreCase(p2.getColor());
        }
    }

    public static class PetTypeComparator implements Comparator<Pet> {
        
        @Override
        public int compare(Pet p1, Pet p2) {
            return p1.getType().compareToIgnoreCase(p2.getType());
        }
    }
    
    public static class PetNameAgeColorType implements Comparator<Pet> {
        
        @Override
        public int compare(Pet p1, Pet p2) {
            int result = p1.getName().compareToIgnoreCase(p2.getName()); /* Order by Name */
            if (result == 0) { /* Order by Age*/ 
                result = Integer.compare(p1.getAge(), p2.getAge());
            }
            if (result == 0) { /* Order by Color*/
                result = p1.getColor().compareToIgnoreCase(p2.getColor());
            }
            if (result == 0) { /* Order by Type*/
                result = p1.getType().compareToIgnoreCase(p2.getType());
            }
            return result;
        }
    }
}

