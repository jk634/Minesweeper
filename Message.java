/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Declares interface method.
 */
 @FunctionalInterface
interface Message {

    /**
     * Handles the string given as a parameter.
     *
     * @param str is the string given to this interface function.
     */
    public void message(String str);
}
