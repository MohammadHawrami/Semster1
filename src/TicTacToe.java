import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public char [][] gameBoard = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
    };

    public int currentPlayer = 1;
    public int currentRowNumber;
    public int currentColumnNumber;
    public int moveCounter = 0;
    public static void main(String[] args) {
             TicTacToe test = new TicTacToe();

             test.initGame();
        }
        //fuction to start a game
        public void initGame() {
                enterCoordinates();
        }
        //function to take row and column index of each palyer
        public void enterCoordinates() {
                       System.out.println("Player" + currentPlayer + "´s turn");
                       printBoard();
                       Scanner in = new Scanner(System.in);
                       System.out.println("enter row number:");
                       currentRowNumber = in.nextInt();
                       if(currentRowNumber >= 1 && currentRowNumber <= 3){
                               System.out.println("enter column number:");
                               currentColumnNumber = in.nextInt();
                               if(!(currentColumnNumber >= 1 && currentColumnNumber <=3)){
                                   in.close();
                                   throw new IllegalArgumentException("please enter column number between 1 und 3");
                               }
                       }
                       else {
                               in.close();
                               throw new IllegalArgumentException("please enter row number between 1 and 3");
                       }
                       tryMove();
                       in.close();
        }
        //tries to execute a turn with fiven row and colum index
        public void tryMove(){
            if(isVaildMove(currentRowNumber-1, currentColumnNumber-1)) {
                    executeMove(currentRowNumber-1,currentColumnNumber-1);
            }else{
                    System.out.println("move is invaild please enter new coordinates");
                    enterCoordinates();
            };
        }
        //checks if a turn is vaild
        public boolean isVaildMove(int row, int column) {
                return row >= 0 && row <= 2 && column >= 0 && column <= 2 && gameBoard[row][column] == ' ';
        }
        // executes a turn and changes the game board appropriately
        public void executeMove(int row, int column) {
                int winningPlayer = currentPlayer;

                if(currentPlayer == 1) {
                       gameBoard[row][column] = 'X';
                       currentPlayer = 2;
                }
                else {
                       gameBoard[row][column] = 'O';
                       currentPlayer = 1;
                }
                if(isWon(row, column)) {
                        System.out.println("Congratulations Player " + winningPlayer + "you won the game ");
                        printBoard();
                        return;
                } else if (isDraw(row, column)) {
                           System.out.println("Its a draw!=");
                           printBoard();
                           return;
                }
                else {
                           moveCounter++;
                           enterCoordinates();
                }
        }
        //checks if there is a winning player after each turn
        public boolean isWon(int row, int column){
            /*if (!isVaildMove(row,column))
                     return false;*/
            if(row < 0 || row > 2 || column < 0 || column >2)
                return false;
            boolean isWon = false;
            char winningSymbol = gameBoard[row][column];
            for(int i = 0; i < 3; i++) {
                if(gameBoard[i][0] == winningSymbol && gameBoard[i][1] == winningSymbol && gameBoard[i][2] == winningSymbol)
                    isWon = true;
                else if(gameBoard[0][i] == winningSymbol && gameBoard[1][i] == winningSymbol && gameBoard[2][i] == winningSymbol)
                    isWon = true;
            }
                if(gameBoard[0][0] == winningSymbol && gameBoard[1][1] == winningSymbol && gameBoard[2][2] == winningSymbol)
                        isWon = true;
                if(gameBoard[2][0] == winningSymbol && gameBoard[1][1] == winningSymbol && gameBoard[0][2] == winningSymbol)
                        isWon = true;

            return isWon;
        }
        //checks if all fields on game board are set without a winner
        public boolean isDraw(int row, int column) {
                if(moveCounter == 8)
                        return true;
                return false;
        }
        //function to print out the gameboard
        public void printBoard(){
            System.out.println(toString(gameBoard[0]));
            //System.out.println("-------");
            System.out.println(toString(gameBoard[1]));
            //System.out.println("---------);
            System.out.println(toString(gameBoard[2]));
        }
        //adjustedtoString function to print out each row of game board properly
        private String toString(char[] a) {
            int iMax = a.length -1;
            StringBuilder b = new StringBuilder();
        b.append('[');
        for(int i = 0; ; i++){
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append("|");
        }
        }
    }