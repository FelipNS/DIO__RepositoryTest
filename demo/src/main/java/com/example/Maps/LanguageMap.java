package com.example.Maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LanguageMap {
    public static void main(String[] args) {
        Map<String, Language> languages = new HashMap<>() {{
            put("Gosling, James", new Language("Java", 1991, "Eclipse"));
            put("van Rossum, Guido", new Language("Python", 1989, "Pycharm"));
            put("Eich, Brendan", new Language("Javascript", 1995, "VS Code"));
        }};

        System.out.println("Random Order: ");
        languages.forEach((k, v) -> {
            System.out.println(k + ": " + v.getName());
        });
        System.out.println("<--------------------------------->");
        
    
        System.out.println("Insertion Order: ");
        Map<String, Language> languages2 = new LinkedHashMap<>() {{
            put("Gosling, James", new Language("Java", 1991, "Eclipse"));
            put("van Rossum, Guido", new Language("Python", 1989, "Pycharm"));
            put("Eich, Brendan", new Language("Javascript", 1995, "VS Code"));
        }};
        languages2.forEach((k, v) -> System.out.println(k + ": " + v.getName()));
        System.out.println("<--------------------------------->");
        
        System.out.println("Author Name Order: ");
        Map<String, Language> languages3 = new TreeMap<>(languages);
        languages3.forEach((k, v) -> System.out.println(k + ": " + v.getName()));
        System.out.println("<--------------------------------->");
        
        
        System.out.println("Book Name Order: ");
        Set<Map.Entry<String, Language>> languages4 = new TreeSet<>(new Language.ComparatorName());
        languages4.addAll(languages.entrySet());
        System.out.println(languages4);
        System.out.println("<--------------------------------->");
        
        System.out.println("Book Name Order: ");
        Set<Map.Entry<String, Language>> languages5 = new TreeSet<>(new Language.ComparatorYear());
        languages5.addAll(languages.entrySet());
        System.out.println(languages5);
        System.out.println("<--------------------------------->");

    }
}

class Language implements Comparable<Language>{
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
    public void setName(String name) {
        this.name = name;
    }

    public int getCriationYear() {
        return criationYear;
    }
    public void setCriationYear(int criationYear) {
        this.criationYear = criationYear;
    }

    public String getIde() {
        return ide;
    }
    public void setIde(String ide) {
        this.ide = ide;
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

    public static class ComparatorName implements Comparator<Map.Entry<String, Language>> {
        @Override
        public int compare(Map.Entry<String, Language> o1, Map.Entry<String, Language> o2) {
            return o1.getValue().getName().compareToIgnoreCase(o2.getValue().getName());
        }
    }

    public static class ComparatorYear implements Comparator<Map.Entry<String, Language>> {
        @Override
        public int compare(Map.Entry<String, Language> o1, Map.Entry<String, Language> o2) {
            return Integer.compare(o1.getValue().getCriationYear(), (o2.getValue().getCriationYear()));
        }
    }
}