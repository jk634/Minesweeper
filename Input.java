import java.io.Console;

/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Represents user input.
 */
public class Input {
    /**
     * Takes user input.
     * @return returns user input.
     */
    public String question() {
        Console console = System.console();
        String a = console.readLine();
        return a;
    }
}
