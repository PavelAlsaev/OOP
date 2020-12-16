package Lab;

import java.io.*;
import java.util.Scanner;


public class Tasks{
    private static Scanner in = new Scanner(System.in);
    private static String path = "C:\\Users\\alsae\\IdeaProjects\\Lab3\\File\\";
    public static void tasksFile(String data){
        int option = 0;
        do {
            System.out.println();
            System.out.println("                       Задания                       ");
            System.out.println("-----------------------------------------------------");
            System.out.println("|1 - Поиск часто встречающего символа               |");
            System.out.println("|2 - Поиск самого длинного слова в предложении      |");
            System.out.println("|3 - Удаление каждого третьего слова в предложении  |");
            System.out.println("|4 - Вернуться в меню способа ввода                 |");
            System.out.println("-----------------------------------------------------");
            System.out.print("Введите: ");

            try{
                option = Integer.parseInt(in.nextLine());
                if(option < 1 || option > 4) throw new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                System.out.println("Ввели не то что нужно, введите 1,2,3 или 4");
            }

            System.out.println("Исходные данные: " + data);

            switch (option) {
                case 1 -> System.out.println(new Strill(data).maxContainsChar());
                case 2 -> System.out.println(new Strill(data).mostLengthWord());
                case 3 -> System.out.println(new Array(data.split(" ")).delete());
            }
        } while (option != 4);
    }

}
