/**
 * @version 13.03.2020
 * @since 1.6
 */

/**
 * Represents the board and events on it.
 */
public class Board {
   private char board[][];
   private char boardHide[][];

   /**
    * Determines board's constructor.
    */
   public Board() {
      this.board = new char[Constants.SIZE_X][Constants.SIZE_Y];
      this.boardHide = new char[Constants.SIZE_X][Constants.SIZE_Y];
   }

   /**
    * Creates board based on size.
    */
   public void createBoard() {
      for (int row = 0; row < board.length; row++) {
         for (int col = 0; col < board[0].length; col++) {
            this.board[row][col] = Constants.CLOSED;
            this.boardHide[row][col] = Constants.CLOSED;
         }
      }
   }

   /**
    * Creates letters for board's columns.
    */
   public void letters() {
      char abc = 65;
      System.out.print("  ");

      for (int i = 0; i < Constants.SIZE_X; i++) {
         System.out.print(" " + abc);
         abc++;
      }
      System.out.println();
   }

   /**
    * Prints the board in the current situation.
    */
   public void printBoard() {
      letters();
      for (int row = 0; row < this.board.length; row++) {
         if (row < this.board.length) {
            if (row + 1 < 10) {
               System.out.printf("%d  ", row + 1);
            } else {
               System.out.printf("%d ", row + 1);
            }

         } else if (row == board.length) {
            System.out.print(row + 1);
         }

         for (int col = 0; col < board[0].length; col++) {
            if (col == board[0].length) {
               System.out.print(board[row][col]);
            } else {
               System.out.print(board[row][col] + " ");
            }
         }
         System.out.println();
      }
   }

   /**
    * Prints the board in the current situation where the mines are hidden.
    */
   public void printBoardHide() {
      letters();
      for (int row = 0; row < this.board.length; row++) {
         if (row < this.board.length) {
            if (row + 1 < 10) {
               System.out.printf("%d  ", row + 1);
            } else {
               System.out.printf("%d ", row + 1);
            }

         } else if (row == board.length) {
            System.out.print(row + 1);
         }

         for (int col = 0; col < board[0].length; col++) {
            if (col == board[0].length) {
               if (board[row][col] == Constants.MINE) {
                  System.out.print(Constants.CLOSED);
               } else {
                  System.out.print(board[row][col]);
               }
            } else {
               if (board[row][col] == Constants.MINE) {
                  System.out.print(Constants.CLOSED + " ");
               } else {
                  System.out.print(board[row][col] + " ");
               }
            }
         }
         System.out.println();
      }
   }

   /**
    * Places the mines randomly on the board.
    * @param random_x is a random cell on the board's row.
    * @param random_y is a random cell on the board's column.
    */
   public void placeMines(int random_x, int random_y) {
      while (true) {
         if (this.board[random_x][random_y] == Constants.MINE) {
            Random x = new GetRandomX();
            Random y = new GetRandomY();
            random_x = x.random();
            random_y = y.random();
         } else {
            this.board[random_x][random_y] = Constants.MINE;
            break;
         }
      }
   }

   /**
    * Handles what happens after a player has selected the cell to play.
    * @param x is the row selected by the player.
    * @param y is the column selected bt the player.
    * @return returns the value true or false depending were there hit or not.
    */
   public boolean press(String x, String y) {
      int row = Integer.parseInt(x);
      Operation operation = new Operation();
      int col = operation.charToNumber(y.toUpperCase());
      int counter = 0;
      int counter2 = 0;
      char count2 = '0';

      Message lambda = m -> System.out.println(m);

      if (this.board[row - 1][col] == Constants.MINE) {
         return false;
      } else {
         for (int i = row - 2; i < row + 1; i++) {
            for (int j = col - 1; j < col + 2; j++) {
               if ((i >= 0 && i < this.board.length) && (j >= 0 &&
                    j < this.board[0].length)) {
                  for (int a = i - 1; a < i + 2; a++) {
                     for (int b = j - 1; b < j + 2; b++) {
                        if ((a >= 0 && a < this.board.length) &&
                            (b >= 0 && b < this.board[0].length)) {
                           if (this.board[a][b] == Constants.MINE) {
                              counter++;
                              counter2++;
                              count2 = (char) (counter2 + '0');
                           }
                        }
                     }
                  }
                  if (this.board[i][j] != Constants.MINE) {
                     if (counter2 == 0) {
                        this.board[i][j] = Constants.OPEN;

                     } else {
                        this.board[i][j] = count2;
                     }
                  }
                  counter2 = 0;
                  count2 = (char) (counter2 + '0');
               }
            }
         }
         if (counter == 0) {
            operation.sendMessage("You are far from the mines", lambda);
         }

         operation.sendMessage("Keep going!", lambda);
         System.out.println();

         printBoardHide();
         return true;
      }
   }

   /**
    * Checks the game current situation.
    * @return boolean that indicates whether the game has been won.
    */
   public boolean checkSituation() {
      int counter = 0;
      for (int i = 0; i < this.board.length; i++) {
         for (int j = 0; j < this.board[0].length; j++) {
            if (board[i][j] != Constants.CLOSED &&
               board[i][j] != Constants.MINE) {
               counter++;
            }

            if (Constants.SIZE_X * Constants.SIZE_Y - counter
               == Constants.MINE_AMOUNT) {
               return false;
            }
         }
      }
      return true;
   }
}
