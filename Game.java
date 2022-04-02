/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Represents the gameplay.
 */
public class Game {
    int time;

    /**
     * Handles events that initialize the game.
     */
    public void start() {
        Clock timeCheck = new TimeCalculationThread();
        timeCheck.setDaemon(true);
        timeCheck.start();

        Input difficultyChoise = new Input();
        String result;

        print();

        while (true) {
            System.out.print("Select difficulty: | 1 = Easy ||" +
                             " 2 = Intermediate || 3 = Hard |  ");
            result = difficultyChoise.question();
            try {
                int convertedResult = Integer.parseInt(result);
                if (convertedResult <= 3 && convertedResult > 0) {
                    Difficulty<Integer> difficulty =
                        new Difficulty<Integer>(convertedResult);
                    int diff = difficulty.getDifficulty();
                    Operation diffSet = new Operation();
                    diffSet.setDifficulty(diff);
                    break;
                } else {
                    System.out.println("Your selection must be " +
                                       "between 1 and 3");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid input");
            }
        }

        print();
        Board board = new Board();
        board.createBoard();
        board.printBoardHide();
        Mine mine = new Mine();
        mine.minesPlacement(board);

        playingGame(board, timeCheck);
    }

    /**
     * Handles all events that keeps the game running until the end.
     *
     * @param board is the main board object.
     * @param timeCheck is an object for checking time.
     */
    public void playingGame(Board board, Clock timeCheck) {
        Input chosenRow = new Input();
        Input chosenColumn = new Input();
        Operation mine = new Operation();

        boolean flag = true;
        boolean flag2 = true;
        boolean success = false;

        String resultX = "";
        String resultY = "";

        print();

        while (flag && flag2) {

            while (true) {
                System.out.print("Select a row: ");
                try {
                    resultX = chosenRow.question();
                    try {
                        Integer.parseInt(resultX);
                        success = true;
                    } catch (Exception e) {
                        System.out.println("Row has to be a number");
                    }
                    if (success == true) {
                        if (Integer.parseInt(resultX) < 1 ||
                            Integer.parseInt(resultX) > Constants.SIZE_X) {
                            success = false;
                            throw new InputException.OutOfBoundsRowException();

                        } else {
                            break;
                        }
                    }
                } catch (Exceptions e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                System.out.print("Select a column: ");
                try {
                    resultY = chosenColumn.question();
                    if (resultY.length() > 1) {
                        success = false;
                        throw new InputException.WrongInputTypeException();
                    } else if (resultY.length() == 1) {
                        success = true;
                    }
                    if (success) {
                        if (mine.charToNumber(resultY.toUpperCase()) < 0
                                || mine.charToNumber(resultY.toUpperCase())
                                   > Constants.SIZE_Y) {
                            throw new
                                InputException.OutOfBoundsColumnException();
                        } else {
                            break;
                        }
                    }
                } catch (Exceptions e) {
                    System.out.println(e.getMessage());
                }
            }
            print();

            flag = mine.pressLaunch(board, resultX, resultY);

            if (flag == false) {
                board.printBoard();
                print();
                System.out.println("YOU FOUND A MINE AND LOST THE GAME!");
                time = timeCheck.getTime();
                System.out.println("You played " + time + " seconds");
            }
            flag2 = mine.gameSituationCheck(board);
            if (flag2 == false) {
                print();
                board.printBoard();
                print();
                System.out.println("YOU WON THE GAME!");
                time = timeCheck.getTime();
                System.out.println("You played " + time + " seconds");
            }
            success = false;
            print();
        }
    }

    /**
     * Shortens the print statement.
     */
    public void print() {
        System.out.println();
    }
}
