package lab;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
/*
    Задание A
 */
    public static void a(String string) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char iChar = string.charAt(i);
            if (iChar == ' ') continue;
            // получаем число одинаовых букв, если буква встречается первый раз возращаем 0
            int count = map.getOrDefault(iChar, 0);
            map.put(iChar, ++count);
        }

        boolean isFirst = true;
        Map.Entry<Character, Integer> max = null;

        for (Map.Entry<Character, Integer> count : map.entrySet()) {
            if (isFirst) {
                max = count;
                isFirst = false;
            } 

            if (max.getValue() < count.getValue()) max = count;
        }
        assert max != null;
        System.out.println(max.getKey());
    }

    /*
    Задача B
     */
    public static void b(String sentences){
        String[] mas = sentences.split(" ");
        String max = mas[0];
        for (String temp : mas) {
            if (max.length() < temp.length()) max = temp;
        }
        System.out.println(max);
    }

    /*
    Задание C
     */
    public static void c(String delete){
        String[] words = delete.split(" ");
        StringBuilder answer = new StringBuilder(words[0]).append(" ");
        for (int i = 1; i < words.length; i++) {
            if ((i + 1) % 3 == 0) continue;
            answer.append(words[i]).append(" ");
        }
        System.out.println(answer.toString());
    }

    public static void main(String[] args) {
        Scanner vvod = new Scanner(System.in);

        String aline = vvod.nextLine();
        a(aline);

        String bline = vvod.nextLine();
        b(bline);

        String cline = vvod.nextLine();
        c(cline);
    }
}
