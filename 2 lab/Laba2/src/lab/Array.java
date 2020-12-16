package lab;

public class Array {
    private String[] words;

    public Array(){
        this.words = "default text".split(" ");
    }

    public Array(String[] words){
        this.words = words;
    }

    public Array(Array clone) {
        String[] originWords = clone.getWords();
        String[] newWords = new String[originWords.length];
        for (int i = 0; i < originWords.length; i++) {
            newWords[i] = originWords[i];
        }
        this.words = newWords;
    }

    public void setWords(String[] words){
        this.words = words;
    }

    public String[] getWords(){
        return words;
    }

    public String delete(){
        StringBuilder answer = new StringBuilder(words[0]).append(" ");
        for (int i = 1; i < words.length; i++) {
            if ((i + 1) % 3 == 0) continue;
            answer.append(words[i]).append(" ");
        }
        return answer.toString();
    }
    
}
