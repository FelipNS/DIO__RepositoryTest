package com.example.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvgTemperature {

    public static void main(String[] args) {
        showTemp();
    }

    public static void showTemp() {
        List<Temperature> temperatures = new ArrayList<Temperature>() {{
            add(new Temperature(1, 14.5f));
            add(new Temperature(2, 16.1f));
            add(new Temperature(3, 18.7f));
            add(new Temperature(4, 13.6f));
            add(new Temperature(5, 28.0f));
            add(new Temperature(6, 25.6f));
        }};
        List<String> monthsNames = new ArrayList<String>(){{
            add("January");
            add("February");
            add("March");
            add("April");
            add("May");
            add("June");
        }};

        float mean = 0.0f;
        for (Temperature temp : temperatures) {
            mean += temp.getAvgTemp();
        }
        mean /= temperatures.size();
        System.out.print("The months with the average temperature higher than " + mean + " are: ");

        for (Temperature temp : temperatures){
            if (temp.getAvgTemp() > mean){
                System.out.print(String.format("%s with %.2f, ", monthsNames.get(temp.getMonth() - 1), temp.getAvgTemp()));
            }
        }

        Collections.sort(temperatures, new Temperature.TemperatureComparator());
        System.out.println(temperatures);
    }
}

class Temperature{
    private int month;
    private float avgTemp;

    public Temperature(int month, float avgTemp){
        this.month = month;
        this.avgTemp = avgTemp;
    }

    public int getMonth() {
        return this.month;
    }

    public float getAvgTemp() {
        return this.avgTemp;
    }

    @Override
    public String toString() {
        return String.format("Temperature [month= %s, avgTemp= %f]", this.month, this.avgTemp);
    }

    public static class TemperatureComparator implements Comparator<Temperature> {
        @Override
        public int compare(Temperature t1, Temperature t2) {
            return Float.compare(t1.getAvgTemp(), t2.getAvgTemp());
        }
    }
}