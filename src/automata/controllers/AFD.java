package automata.controllers;

import automata.util.Language;

import java.util.ArrayList;

public class AFD {
    private automata.dev.AFD AFD_model;

    public void newAFD_model(int[] states, Character[] alphabet, int init, int[] deaths, int[][] transitionTable){
        AFD_model = new automata.dev.AFD(
                states,  alphabet, init, deaths, transitionTable
        );
    }

    public ArrayList<String> generateLang(Character[] alphabet, int size, boolean sizeExact, boolean includeVoid){
        Language lang = new Language(
                alphabet,
                size,
                sizeExact
        );
        return lang.getLanguage(includeVoid);
    }

    public String validate(ArrayList<String> words){
        StringBuilder stringResult = new StringBuilder("----- Validations -----\n\n");
        words.forEach(word ->{
            try {
                boolean flag = AFD_model.validate(word);
                stringResult.append("La palabra ".concat(word).concat(" es ").concat(flag?"valida":"invalida").concat("\n"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return stringResult.toString();
    }
}
