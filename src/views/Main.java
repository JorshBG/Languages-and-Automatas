package views;

public class Main {

    public static void main(String[] args) {

        Runnable play = new Runnable() {
            @Override
            public void run() {
                new App();
            }
        };
        play.run();
    }

}
