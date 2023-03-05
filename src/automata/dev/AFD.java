package automata.dev;

public class AFD {

    private int[] states;
    private char[] alphabet;
    private int init;
    private int[] deaths;
    private int[][] transitionTable;

    public AFD(int[] states, char[] alphabet, int init, int[] deaths, int[][] transitionTable) {
        this.states = states;
        this.alphabet = alphabet;
        this.init = init;
        this.deaths = deaths;
        this.transitionTable = transitionTable;
    }

    private int search(char symbol){
        for (int i = 0; i < alphabet.length; i++) {
            if (symbol == alphabet[i])
                return i;
        }
        return -1;
    }

    public boolean validate(String string) throws Exception {
        char letter = 0;
        int pos = 0;
        int actualState = this.init;
        for (int i = 0; i < string.length(); i++) {
            letter = string.charAt(i);
            pos = this.search(letter);
            if (pos == -1)
                throw new Exception("The symbol " + letter + " does not belong to the alphabet");
            else
                actualState = this.transitionTable[actualState][pos];
        }
        for (int i = 0; i < this.deaths.length; i++) {
            if (actualState == this.deaths[i])
                return true;
        }
        return false;
    }

}
