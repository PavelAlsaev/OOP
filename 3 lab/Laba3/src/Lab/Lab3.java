package Lab;

import java.util.Scanner;

public class Lab3{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        MenuMain();
    }

    private static void MenuMain(){
        int menu = 0;
        do {
            System.out.println();
            System.out.println("            Меню            ");
            System.out.println("----------------------------");
            System.out.println("| 1 - Работа с файлами     |");
            System.out.println("| 2 - Способ ввода задания |");
            System.out.println("| 3 - Выход                |");
            System.out.println("----------------------------");
            System.out.print("Введите: ");

            try{
                menu = Integer.parseInt(in.nextLine());
                if (menu < 1 || menu > 3) throw new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                System.out.println("Ввели не то что нужно, введите 1,2 или 3");
            }

            switch (menu) {
                case 1 -> WorkFile.work();
                case 2 -> Pick.choiceFile();
            }
        } while(menu != 3);
        System.out.println("Конец программы");
    }
}