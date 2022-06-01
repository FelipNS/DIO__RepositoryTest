package com.example.Sets;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class FavoriteLanguage {
    
    public static void main(String[] args) {
        Set<Language> languages = new LinkedHashSet<>() {{
            add(new Language("Python", 1989, "Pycharm"));
            add(new Language("Java", 1991, "Eclipse"));
            add(new Language("Javascript", 1995, "VS Code"));
        }};

        /*Insertion Order*/
        for (Language lang : languages) {
            System.out.println(String.format("Name: %s, Year: %d, IDE: %s", lang.getName(), lang.getCriationYear(), lang.getIde()));
        }
        sortedByName(languages);
    }
    
    public static void sortedByName(Set<Language> list) {
        System.out.println("Sorted by name:");
        Set<Language> treeSet = new TreeSet<>(list);
        for (Language lang : treeSet) {
            System.out.println(String.format("Name: %s, Year: %d, IDE: %s", lang.getName(), lang.getCriationYear(), lang.getIde()));
        }
    }
}

class Language implements Comparable<Language> {
    String name;
    int criationYear;
    String ide;

    public Language(String name, int criationYear, String ide) {
        this.name = name;
        this.criationYear = criationYear;
        this.ide = ide;
    }

    public String getName() {
        return name;
    }

    public int getCriationYear() {
        return criationYear;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return String.format("Language => [name: %s, criation year: %d, ide: %s]", this.name, this.criationYear, this.ide);
    }

    @Override
    public int compareTo(Language other) {
        int result = this.getName().compareToIgnoreCase(other.getName());
        if (result == 0) {
            result = Integer.compare(this.getCriationYear(), other.getCriationYear());
        }
        if (result == 0) {
            result = this.getIde().compareToIgnoreCase(other.getIde());
        }
        return result;
    }
}