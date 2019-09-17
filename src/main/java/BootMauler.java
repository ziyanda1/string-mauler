import engine.StringMaulerEngine;

import java.util.Scanner;

public class BootMauler {

    private StringMaulerEngine engine = new StringMaulerEngine();

    public static void main(String [] args){

        final StringMaulerEngine engine = new StringMaulerEngine();
        final Scanner scanner = new Scanner(System.in);

        new Thread(() -> {
            engine.displayCommands();
            while(engine.isRunning()) {
                System.out.print("\ninput: \t");
                engine.execute(scanner.nextLine());
            }
        }).start();

    }
}
