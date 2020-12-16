package lab;

import java.util.Scanner;

public class lab {

    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);


        String aline = vvod.nextLine();
        Strill line = new Strill(aline);
        System.out.println(line.maxContainsChar());

        String bline = vvod.nextLine();
        line.setString(bline);
        System.out.println(line.mostLengthWord());

        String cline = vvod.nextLine();
        Array words = new Array(cline.split(" "));
        System.out.println(words.delete());

        // Проверка копирования объекта
        System.out.println("Проверка на копирование:");
        Array ad = new Array("temp1 string2".split(" "));
        Array sd = new Array(ad);
        ad.setWords("some text 3".split(" "));
        String[] wordsSd = sd.getWords();
        for (String word :
                wordsSd) {
            System.out.println(word + " ");
        }

    }
}

