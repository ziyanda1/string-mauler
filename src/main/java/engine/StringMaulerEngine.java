package engine;

import command.Functions;
import exception.NoMaulException;
import mauler.impl.StringMaulerImpl;


import java.util.Arrays;

public class StringMaulerEngine {

    private static final int EXIT_ON_QUIT = 1;
    private boolean running = Boolean.TRUE;

    private StringMaulerImpl stringManipulator;

    public StringMaulerEngine() {
        stringManipulator = new StringMaulerImpl();
    }

    public boolean isRunning() {
        return running;
    }

    public void display(Runnable runnable) {
        runnable.run();
    }

    public void execute(String input) {
        String [] commands = input.split("\\s");
        String function = commands[0];

        if((function.equalsIgnoreCase("A") || function.equalsIgnoreCase("P")) && (commands.length == 1 || commands.length > 2)) {
            System.out.println("-usage A <text to append> || P <text to prepend>");
        } else {
            try {
                if (function.equalsIgnoreCase(Functions.NEW.getId())) {
                    stringManipulator.create();
                } else if (function.equalsIgnoreCase(Functions.APPEND.getId())) {
                    stringManipulator.append(commands[1]);
                } else if (function.equalsIgnoreCase(Functions.PREPEND.getId())) {
                    stringManipulator.prepend(commands[1]);
                } else if (function.equalsIgnoreCase(Functions.REVERSE.getId())) {
                    stringManipulator.reverse();
                } else if (function.equalsIgnoreCase(Functions.QUIT.getId())) {
                    System.out.println("Goodbye!");
                    setRunning(Boolean.FALSE);
                    System.exit(EXIT_ON_QUIT);
                } else {
                    System.out.println("Command not found");
                    displayCommands();
                }
                System.out.println(stringManipulator);
            } catch(NoMaulException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex){
                System.out.println("Something went wrong!");
            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void displayCommands() {
        Arrays.stream(Functions.values()).forEach(function -> {
            System.out.println(String.format("| %s |  %s |", function.getId(), function.getDescription()));
        });
    }
}
