/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Represents a parent class of custom exceptions.
 */
public abstract class Exceptions extends Exception {
    /**
     * Declares a static final serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private String message;

    /**
     * Determines constructor.
     * @param msg is exception's message.
     */
    public Exceptions(String msg) {
        this.message = msg;
    }

    /**
     * Gets message.
     */
    public String getMessage() {
        return message;
    }
}
