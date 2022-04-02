/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Represents difficulty of the game.
 */
public class Difficulty<T extends Number> {
    private T diff;

    /**
     * Determines Difficulty's constructor.
     * @param diff is the difficulty level selected by the player.
     */
    public Difficulty(T diff) {
        this.diff = diff;
    }

    /**
     * Gets the difficulty.
     * @return returns the difficulty.
     */
    public T getDifficulty() {
        return this.diff;
    }
}
