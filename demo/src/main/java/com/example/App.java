package com.example;

public class App 
{
    public static void main( String[] args )
    {
        Comprimento("teste");
    }

    public static void Comprimento(String horario)
    {
        String[] limitesHorario = {"00:00", "4:59", "5:00", "11:59", "12:00", "17:59", "18:00", "23:59"};
        
        for (String h : limitesHorario) {
            String[] horaMin = h.split(":");
            int hora = Integer.parseInt(horaMin[0]);
            int min = Integer.parseInt(horaMin[1]);
            int total = (hora * 60) + min;

            if (total >=0 && total <= 299) {
                System.out.println("Boa Noite");
            } else if (total >= 300 && total <= 719) {
                System.out.println("Boa Dia");
            } else if (total >= 720 && total <= 1079) {
                System.out.println("Boa Tarde");
            } else {
                System.out.println("Boa Noite");
            };
        }     
    }
}
