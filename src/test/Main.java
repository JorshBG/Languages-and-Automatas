package test;
import automata.dev.AFD;
import automata.dev.Curp;
import automata.dev.IP;
import automata.util.Language;
public class Main {
    public static void main(String[] args) {
        AFD obj1 = new AFD(
                new int[]{0,1,2,3,4},
                new char[]{'a','b'},
                0,
                new int[]{0,3,4},
                new int[][]{
                        {1,2},
                        {3,4},
                        {3,3},
                        {1,2},
                        {1,2}
                }
        );
        Language obj2 = new Language(new String[]{"a","b"}, 5, false);

        var language = obj2.getLanguage(false);
        System.out.println(language.size());
        language.forEach(letter ->{
            try {
                var response = obj1.validate(letter);
                System.out.println("La cadena " + letter + " es " + (response?"Valido":"Invalido"));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });

        try {
            var response = obj1.validate("");
            System.out.println("La cadena vacia" + " es " + (response?"Valido":"Invalido"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}


