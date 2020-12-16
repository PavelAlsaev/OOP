package Lab;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class WorkFile {
    private static Scanner in = new Scanner(System.in);
    private static String path = "C:\\Users\\alsae\\IdeaProjects\\Lab3\\File\\";
    public static void work() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println("           Работа с файлами          ");
            System.out.println("-------------------------------------");
            System.out.println("|1 - Создать файл                   |");
            System.out.println("|2 - Посмотреть содержимое файла    |");
            System.out.println("|3 - Удалить файл                   |");
            System.out.println("|4 - Вернуться в главное меню       |");
            System.out.println("-------------------------------------");
            System.out.print("Введите: ");



            try{
                choice = Integer.parseInt(in.nextLine());
                if(choice < 1 || choice > 4) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Ввели не то что нужно, введите 1,2,3 или 4");
            }

            String fileName = null;
            switch (choice){
                case 1:
                    System.out.println("Введите имя файла ");

                    fileName = in.nextLine() + ".txt";

                    FileWriter file1 = null;
                    try {
                        file1 = new FileWriter(path + fileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.print("Введите текст: ");
                    String text = in.nextLine() + ' ';

                    try {
                        file1.write(text);
                    } catch (IOException e){
                        System.err.println("Ошибка при записи текста");
                    }

                    try {
                        file1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                   break;

                case 2:
                    FileReader file2 = null;
                    do {
                        System.out.println("Введите имя файла, корого хотите посмотреть содержимое ");
                        fileName = in.nextLine() + ".txt";

                        try {
                            file2 = new FileReader(path + fileName);
                        } catch (FileNotFoundException e){
                            System.err.println("Ошибка, файл не найден");
                            continue;
                        }
                        break;
                    } while(true);


                    char[] a = new char[255];

                    int length = 0;
                    try {
                        length = file2.read(a);
                    } catch (IOException e){
                        System.err.println("Ошибка чтения");
                    }

                    try {
                        a = Arrays.copyOf(a, length);
                    }catch (NegativeArraySizeException e){
                        System.out.println("Фаил пустой ");
                        continue;
                    }

                    System.out.print("Текст файла содержит: ");
                    for (char b: a){
                        System.out.print(b);
                    }
                    System.out.println();
                    try{
                        file2.close();
                    }catch (IOException e){
                        System.out.println("Ошибка!");
                    }
                    break;
                case 3:
                    System.out.print("Введите фаил который хотите удалить: ");

                    fileName = in.nextLine()+".txt";


                    File File3 = new File(path + fileName);

                    if(File3.delete()){
                        System.out.println("Файл " + fileName + " удален");
                    } else{
                        System.out.println("Файла " + fileName + " не существует ");
                    }
                    break;
            }
        }while(choice != 4);
    }
}

