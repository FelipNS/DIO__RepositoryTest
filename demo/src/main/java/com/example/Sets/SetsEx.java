package com.example.Sets;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetsEx {
    
    public static void main(String[] args) {
        
        Set<Serie> series = new HashSet<>() {{
            add(new Serie("Exodo", "Drama", 400));
            add(new Serie("Pica-Pau", "Infantil", 25));
            add(new Serie("Esqueceram de Mim", "Comédia", 130));
        }};

        Serie serieTest = new Serie("Exodo", "Drama", 52);

        Iterator<Serie> iterator = series.iterator();
        while (iterator.hasNext()) {
            Serie serieTemp = iterator.next();
            if (serieTemp.equals(serieTest)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }

        System.out.println();
    }
}

class Serie {

    private String name;
    private String gender;
    private int epTime;

    public Serie(String name, String gender, int epTime) {
        this.name = name;
        this.gender = gender;
        this.epTime = epTime;
    }

    public String getName() {
        return this.name;
    }
    public String getGender() {
        return this.gender;
    }
    public int getEpTime() {
        return this.epTime;
    }

    @Override
    public String toString() {
        return String.format("Serie => [name: %s, gender: %s, episode time: %d]", this.name, this.gender, this.epTime);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;

        return this.name.equals(serie.name) && this.gender.equals(serie.gender);
    }

    public static class SerieNameComparator implements Comparator<Serie> {
        @Override
        public int compare(Serie s1, Serie s2) {
            return s1.getName().compareToIgnoreCase(s2.getName());
        }
    }

    public static class SerieGenderComparator implements Comparator<Serie> {
        @Override
        public int compare(Serie s1, Serie s2) {
            return s1.getGender().compareToIgnoreCase(s2.getGender());
        }
    }
}