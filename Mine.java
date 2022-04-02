/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Represents the placement of the mines.
 */
public class Mine {

    /**
     * Passes random x and y as arguments to the main placement method.
     *
     * @param board is the main board object.
     */
    public void minesPlacement(Board board) {
        int i = 0;
        while (i < Constants.MINE_AMOUNT) {
            Random rnd_x = new GetRandomX();
            Random rnd_y = new GetRandomY();
            board.placeMines(rnd_x.random(), rnd_y.random());
            i++;
        }
    }
}
