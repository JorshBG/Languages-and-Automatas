package automata.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {

    private ArrayList<Word> words;
    private Pattern pattern;
    private Matcher matcher;

    public Register(String regex){
        this.pattern = Pattern.compile(regex);
        words = new ArrayList<>();
    }

    public void addWord(String word){
        matcher = pattern.matcher(word);
        words.add(new Word(word, matcher.matches()));
    }

     @Override public String toString(){
        StringBuilder build = new StringBuilder("Results\n");
        words.forEach(word -> build.append(word.toString()));
        return build.toString();
     }

     public String[][] toArray(){
        String[][] arr = new String[words.size()][];
         for (int i = 0; i < arr.length; i++) {
             arr[i] = words.get(i).toArray();
         }
         return arr;
     }

}
