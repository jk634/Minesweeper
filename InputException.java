/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 *  Represents exceptions in the inputs.
 */
public class InputException {

    /**
     * Handles exception when input is out of the row's bound.
     */
    public static class OutOfBoundsRowException extends Exceptions {
        /**
         * Declares a static final serialVersionUID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * Passes the default exception message to the parent class
         * constructor.
         */
        public OutOfBoundsRowException() {
            super("Row must be between 1 and " + Constants.SIZE_X);
        }

        /**
         * Passes the custom exception message to the parent class
         * constructor.
         *
         * @param msg is a custom message from exception.
         */
        public OutOfBoundsRowException(String msg) {
            super(msg);
        }
    }

    /**
     * Handles the exception when input is out of the column's bound.
     */
    public static class OutOfBoundsColumnException extends Exceptions {

        /**
         * Declares a static final serialVersionUID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * Passes the default exception message to the parent class
         * constructor.
         */
        public OutOfBoundsColumnException() {
            super("Column must be between A and " + (char)
                (Constants.SIZE_Y + 64));
        }

        /**
         * Passes the custom exception message to the parent class
         * constructor.
         *
         * @param msg is a custom message from exception.
         */
        public OutOfBoundsColumnException(String msg) {
            super(msg);
        }
    }

    /**
     * Handles the exception when the input is invalid.
     */
    public static class WrongInputTypeException extends Exceptions {

        /**
         * Declares a static final serialVersionUID field.
         */
        private static final long serialVersionUID = 1L;

        /**
         * Passes thedefault exception message to the parent class
         * constructor.
         */
        public WrongInputTypeException() {
            super("Input must be one character");
        }

        /**
         * Passes the custom exception message to the parent class
         * constructor.
         *
         * @param msg is a custom message from the exception throw.
         */
        public WrongInputTypeException(String msg) {
            super(msg);
        }
    }
}
