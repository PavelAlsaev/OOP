package Lab;

import java.io.*;
import java.util.Scanner;

public class Pick {
    private static Scanner in = new Scanner(System.in);
    private static String path = "C:\\Users\\alsae\\IdeaProjects\\Lab3\\File\\";
    public static void choiceFile(){

        int selection = 0;
        do {
            System.out.println();
            System.out.println("    Выберите способ ввода данных   ");
            System.out.println("-----------------------------------");
            System.out.println("|1 - Ввести данные из файла       |");
            System.out.println("|2 - Ввести данные через консоль  |");
            System.out.println("|3 - Вернуться в главное меню     |");
            System.out.println("-----------------------------------");
            System.out.print("Введите: ");

            try{
                selection = Integer.parseInt(in.nextLine());
                if(selection < 1 || selection > 3) throw new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                System.out.println("Ввели не то что нужно, введите 1,2 или 3");
            }

            switch (selection) {
                case 1:
                    try{
                        String Temp = FileInput();
                        Tasks.tasksFile(Temp);

                    }catch (IOException e){

                        System.err.println("Файл не обнаружен");
                    }
                    break;
                case 2:
                    Tasks.tasksFile(ConsoleInput());
                    break;
            }
        }while (selection != 3);
    }


      private static String FileInput() throws IOException {
        StringBuilder stroka = new StringBuilder();
        System.out.print("Введите имя файла: ");
        String filename = in.nextLine()+".txt";
        FileReader fr = new FileReader(path+filename);

        char [] a = new char[255];

        int count = 0;

        try {
            count = fr.read(a);
        } catch (IOException ex) {
            System.err.println("Ошибка ввода ");
        }

        for(int i = 0; i < count; i++)
            stroka.append(a[i]);
        fr.close();

        System.out.println();
        return stroka.toString();
    }


    private static String ConsoleInput(){
        System.out.print("Введите текст: ");
        return in.nextLine();
    }
}
