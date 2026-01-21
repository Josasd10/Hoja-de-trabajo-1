public class Main {

    public static void main(String[] args) {
        Radio radio = new RadioImpl();   // intercambiable
        new RadioGUI(radio);
    }
}


