/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Reperesents random generate.
 */
interface Random {

    /**
     * Handles random generate.
     * @return random value.
     */
    public int random();
}

/**
 * Represents random generate for x.
 */
class GetRandomX implements Random {

    /**
     * Generates a random number between zero and the row size of the board.
     */
    @Override
    public int random() {
        return (int) (Math.random() * Constants.SIZE_X);
    }
}

/**
 * Represents random generate for y.
 */
class GetRandomY implements Random {

    /**
     * Generates a random number between zero and the column size of the board.
     */
    @Override
    public int random() {
        return (int) (Math.random() * Constants.SIZE_Y);
    }
}
