/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Represents several basic operations.
 */
public class Operation extends Constants {

    /**
     * Passes arguments to the main press method.
     *
     * @param board is the main board object.
     * @param row is the row given by the user.
     * @param col is the colmun given by the user.
     * @return returns boolean depending whether the mine is been hit or not.
     */
    public boolean pressLaunch(Board board, String row, String col) {
        boolean result = board.press(row, col);
        return result;
    }

    /**
     * Sets the difficulty of the game.
     *
     * @param diff is the difficulty selected by the user.
     */
    public void setDifficulty(int diff) {
        if (diff == 1) {
            SIZE_X = 5;
            SIZE_Y = 5;
            MINE_AMOUNT = 10;

        } else if (diff == 2) {
            SIZE_X = 10;
            SIZE_Y = 10;
            MINE_AMOUNT = 30;

        } else if (diff == 3) {
            SIZE_X = 15;
            SIZE_Y = 15;
            MINE_AMOUNT = 70;
        } else {
            System.out.println("Something went wrong");
        }

    }

    /**
     * Converts a string to a character and then a character to a number.
     *
     * @param str is input given by the user.
     * @return returns converted value.
     */
    public int charToNumber(String str) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            result = s - 65;
        }

        return result;
    }

    /**
     * Converts string to number.
     * @param str is string given by the user.
     */
    public void stringToNumbers(String str) {
        char[] array = {};
        String result = "";
        for (int i = 0; i > str.length(); i++) {
            char s = str.charAt(i);
            array[i] = s;
        }
        for (int j = 0; j < array.length; j++) {
            result = result + array[j];
        }
    }

    /**
     * Sets game situation to a variable.
     *
     * @param board is the main board object.
     * @return returns boolean depending whether the game is won or not.
     */
    public boolean gameSituationCheck(Board board) {
        boolean result = board.checkSituation();
        return result;
    }

    /**
     * Calls interface method.
     *
     * @param msg is given string.
     * @param m is a inteface method.
     */
    public void sendMessage(String msg, Message m) {
        m.message(msg);
    }
}
