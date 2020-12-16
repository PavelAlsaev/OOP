package Lab;

import java.util.HashMap;
import java.util.Map;

public class Strill {
    private String string;

    public Strill() {
        this.string = "default text";
    }
    public Strill(String string) {
        this.string = string;
    }

    public Strill(Strill clone){
        this.string = clone.getString();
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public String mostLengthWord(){
        String[] mas = string.split(" ");
        String max = mas[0];
        for (String temp : mas) {
            if (temp.length() >= max.length()) max = temp;
        }
        return max;
    }

    public char maxContainsChar() {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char iChar = string.charAt(i);
            if (iChar == ' ')  continue;
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
        return max.getKey();
    }
}
