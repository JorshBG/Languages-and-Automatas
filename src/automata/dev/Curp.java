package automata.dev;

//import java

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Curp {

    private Matcher matcher;
    private Pattern pattern;
    private ArrayList<String> curps;
//    private final String[] STATE_CODES_ARRAY = {"AS", "BC", "BS", "CC", "CL", "CM", "CS", "CH", "DF", "DG", "GT", "GR", "HG", "JC", "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC", "TS", "TL", "VZ", "YN", "ZS"};
    private final String STATE_CODES = "(AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS)";
    private final String SEX = "(M|H)";
    private final String REGEX_FIRST_FOUR_CHARS = "[A-Z][AEOUIX][A-Z]{2}";
    private final String REGEX_YEAR_CHARS = "[0-9]{2}";
    private final String REGEX_MONTH_31_DAYS_CHARS = "((0[13578]|10|12)([012][1-9]|3[01]|10))";
    private final String REGEX_MONTH_30_DAYS_CHARS = "02([01][1-9]|2[0-8]|10)";
    private final String REGEX_MONTH_FEBRUARY_CHARS = "(0[469]|11)([012][1-9]|30|10)";
    private final String REGEX_CONSONANTS_CHARS = "[B|C|D|F|G|H|J|K|L|M|N|P|Q|R|S|T|V|W|X|Y|Z]";
    private final String REGEX_HOMOCODE_CHARS = "[A-Z0-9]";
    private final String REGEX = REGEX_FIRST_FOUR_CHARS
            .concat(REGEX_YEAR_CHARS)
            .concat("("
                    .concat(REGEX_MONTH_31_DAYS_CHARS)
                    .concat("|")
                    .concat(REGEX_MONTH_30_DAYS_CHARS)
                    .concat("|")
                    .concat(REGEX_MONTH_FEBRUARY_CHARS)
                    .concat(")"))
            .concat(SEX)
            .concat(STATE_CODES)
            .concat(REGEX_CONSONANTS_CHARS).concat("{3}")
            .concat(REGEX_HOMOCODE_CHARS).concat("{2}");

    public Curp(){
        pattern = Pattern.compile(REGEX);
    }

    public void addCurp(String curp){
        matcher = pattern.matcher(curp);
    }

    public ArrayList<String> matcher(){
//        matcher.
        return null;
    }
}
