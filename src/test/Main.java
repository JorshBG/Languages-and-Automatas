package test;
import automata.util.Language;
public class Main {
    public static void main(String[] args) {
        var alphabet = new String[]{"1", "2", "3"};
        var obj1 = new Language(alphabet,8,false);
        var language = obj1.getLanguage(true);
        language.forEach(word -> {
            System.out.println(word);
        });
    }
}