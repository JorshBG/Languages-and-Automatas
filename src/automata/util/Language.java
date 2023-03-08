package automata.util;

import java.util.ArrayList;
import java.util.Arrays;

public class Language {
    private ArrayList<Character> alphabet;
    private int size;
    private boolean sizeExact;
    private ArrayList<String> language;
    public Language() {
        this(new Character[]{'0', '1'});
    }

    public Language(Character[] alphabet) {
        this(alphabet, alphabet.length, false);
    }

    public Language(Character[] alphabet, boolean sizeExact) {
        this(alphabet, alphabet.length, sizeExact);
    }

    public Language(Character[] alphabet, int size, boolean sizeExact) {
        this.alphabet = new ArrayList<>(Arrays.asList(alphabet));
        this.size = size;
        this.sizeExact = sizeExact;
        this.language = new ArrayList<>();
    }

    private void build(String currentWord) {
        if (currentWord.length() == size) {
            this.language.add(currentWord);
        } else {
            for (char s : alphabet) {
                build(currentWord + s);
            }
        }
    }

    private void build(){
        var repeat = size;
        for (int i = 1; i <= repeat; i++) {
            this.size = i;
            build("");
        }
    }

    public ArrayList<String> getLanguage(boolean includeVoid){
        if (alphabet == null) {
            throw new RuntimeException("The alphabet cannot be null");
        } else {
            if (sizeExact) build("");
            else build();
            if (includeVoid) {
                this.language.add(0, "");
            }
            return this.language;
        }
    }

}
