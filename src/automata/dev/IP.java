package automata.dev;

import automata.util.Register;

import java.util.regex.Pattern;

public class IP {
    private final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
                    + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    Register register;

    public IP(){
        this.register = new Register(IPADDRESS_PATTERN);
    }

    public void addIP(String ip){
        register.addWord(ip);
    }
    @Override
    public String toString(){
        return register.toString();
    }

    public String[][] toArray(){
        return register.toArray();
    }


}
