package automata.util;

public class Word {

    private String word;
    private boolean validate;

    public Word(String word, boolean validate){
        this.word = word;
        this.validate = validate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(word);
        builder.append(" is ");
        builder.append(validate?"Accepted":"Refused");
        builder.append("\n");
        return builder.toString();
    }

    public String[] toArray(){
        String[] arr = new String[2];
        arr[0] = word;
        arr[1] = validate?"Accepted":"Refused";
        return arr;
    }
}
