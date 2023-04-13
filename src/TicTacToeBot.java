import java.util.Arrays;
import java.util.Scanner;

// Class represents a tictactoe game
public class TicTacToeBot {

    // class variables
    public char[][] gameBoard = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
    };

    public int currentPlayer = 1;
    public int currentRowNumber;
    public int currentColumnNumber;
    public int moveCounter = 0;

    // main function to init class instance and start a game
    public static void main(String[] args) {
        TicTacToeBot test = new TicTacToeBot();


        test.initGame();
    }

    // function to start a game
    public void initGame() {
        enterCoordinates();
    }

    // function to take row and column index of each player
    public void enterCoordinates() {
        if(currentPlayer == 1) {
            System.out.println("Player " + currentPlayer + "`s turn");
            printBoard();
            Scanner in = new Scanner(System.in);
            System.out.println("enter row number:");
            currentRowNumber = in.nextInt();
            if(currentRowNumber >= 1 && currentRowNumber <= 3) {
                System.out.println("enter column number:");
                currentColumnNumber = in.nextInt();
                if(!(currentColumnNumber >= 1 && currentColumnNumber <= 3)) {
                    in.close();
                    throw new IllegalArgumentException("please enter column number between 1 and 3");
                }
            }
            else {
                in.close();
                throw new IllegalArgumentException("please enter row number between 1 and 3");
            }
            tryMove();
            in.close();
        }
        else {
            printBoard();
            botMoves();
        }

    }

    public void botMoves() {

        int[] botMove = getBotMove();
        //System.out.println(Arrays.toString(botMove));
        executeMove(botMove[0],botMove[1]);

    }
    // tries to execute a turn with fiven row and column index
    public void tryMove() {

        if(isValidMove(currentRowNumber-1, currentColumnNumber-1)) {
            executeMove(currentRowNumber-1,currentColumnNumber-1);
        }else{
            System.out.println("move is invalid please enter new coordinates");
            enterCoordinates();
        };
    }

    // checks if a turn is valid
    public boolean isValidMove(int row, int column) {
        return gameBoard[row][column] == ' ' && row >= 0 && row <= 2 && column >= 0 && column <= 2;
    }

    // executes a turn and changes the game board appropriately
    public void executeMove(int row, int column) {
        int winningPlayer = currentPlayer;

        if(currentPlayer == 1) {
            gameBoard[row][column] = 'X';
            currentPlayer = 2;
        }
        else {
            gameBoard[row][column]  = 'O';
            currentPlayer = 1;
        }

        if(isWon(row, column)) {
            System.out.println("Congratulations Player " + winningPlayer  + " you won the game");
            printBoard();
            return;
        }
        else if(isDraw(row, column)) {
            System.out.println("Its a draw!");
            printBoard();
            return;
        }
        else {
            moveCounter++;
            enterCoordinates();
        }

    }

    // checks if there is a winning player after each turn
    public boolean isWon(int row, int column) {
		/*if(!isValidMove(row,column))
			return false;*/
        if(row < 0 || row > 2 || column < 0 || column > 2)
            return false;
        boolean isWon = false;
        char winningSymbol = gameBoard[row][column];
        for(int laufindex = 0; laufindex < 3;laufindex++) {
            if(gameBoard[laufindex][0] == winningSymbol && gameBoard[laufindex][1] == winningSymbol && gameBoard[laufindex][2] == winningSymbol)
                isWon = true;
            else if(gameBoard[0][laufindex] == winningSymbol && gameBoard[1][laufindex] == winningSymbol && gameBoard[2][laufindex] == winningSymbol)
                isWon = true;
        }
        if(gameBoard[0][0] == winningSymbol && gameBoard[1][1] == winningSymbol && gameBoard[2][2] == winningSymbol)
            isWon = true;
        if(gameBoard[2][0] == winningSymbol && gameBoard[1][1] == winningSymbol && gameBoard[0][2] == winningSymbol)
            isWon = true;

        return isWon;
    }

    // checks if all fields on game board are set without a winner
    public boolean isDraw(int row, int column) {
        if(moveCounter == 8)
            return true;
        return false;
    }

    // function to print out the gameboard
    public void printBoard() {
        System.out.println(toString(gameBoard[0]));
        //System.out.println("-------");
        System.out.println(toString(gameBoard[1]));
        //System.out.println("-------");
        System.out.println(toString(gameBoard[2]));
    }

    // adjustedtoString function to print out each row of game board properly
    private String toString(char[] a) {
        int iMax = a.length - 1;
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append("|");
        }
    }

    public int[] getBotMove() {
        int[] botMove = winningTurn('O');
        if(botMove.length != 0) {
            return botMove;
        }
        else {
            botMove = winningTurn('X');
            if(botMove.length != 0) {
                return botMove;
            }
        }

        for(int i = 0;i< 3;i++) {
            for(int j = 0; j <3; j++) {
                if(gameBoard[i][j] == ' ') {
                    botMove = new int[2];
                    botMove[0] = i;
                    botMove[1] = j;
                }
            }
        }
        return botMove;
    }

    private int[] winningTurn(char playerSymbol) {
        boolean winningTurn = false;
        char winningSymbol = playerSymbol ;
        int[] winningCoords = new int[2];

        for(int laufindex = 0; laufindex< 3;laufindex++) {
            if(gameBoard[laufindex][0] == winningSymbol && gameBoard[laufindex][1] == winningSymbol && gameBoard[laufindex][2] == ' ') {
                winningTurn = true;
                winningCoords[0] = laufindex;
                winningCoords[1] = 2;
            }

            else if(gameBoard[laufindex][0] == winningSymbol && gameBoard[laufindex][2] == winningSymbol && gameBoard[laufindex][1] == ' ') {
                winningTurn = true;
                winningCoords[0] = laufindex;
                winningCoords[1] = 1;
            }

            else if(gameBoard[laufindex][0] == ' ' && gameBoard[laufindex][1] == winningSymbol && gameBoard[laufindex][2] == winningSymbol) {
                winningTurn = true;
                winningCoords[0] = laufindex;
                winningCoords[1] = 0;
            }
            else if(gameBoard[0][laufindex] == winningSymbol && gameBoard[1][laufindex] == winningSymbol && gameBoard[2][laufindex] == ' ') {
                winningTurn = true;
                winningCoords[0] = 2;
                winningCoords[1] = laufindex;
            }

            else if(gameBoard[0][laufindex] == winningSymbol && gameBoard[2][laufindex] == winningSymbol && gameBoard[1][laufindex] == ' ') {
                winningTurn = true;
                winningCoords[0] = 1;
                winningCoords[1] = laufindex;
            }

            else if(gameBoard[0][laufindex] == ' ' && gameBoard[1][laufindex] == winningSymbol && gameBoard[2][laufindex] == winningSymbol) {
                winningTurn = true;
                winningCoords[0] = 0;
                winningCoords[1] = laufindex;
            }
        }

        if(gameBoard[0][0] == winningSymbol && gameBoard[1][1] == winningSymbol && gameBoard[2][2] == ' ') {
            winningTurn = true;
            winningCoords[0] = 2;
            winningCoords[1] = 2;
        }
        else if(gameBoard[0][0] == winningSymbol && gameBoard[1][1] == ' ' && gameBoard[2][2] == winningSymbol) {
            winningTurn = true;
            winningCoords[0] = 1;
            winningCoords[1] = 1;
        }
        else if(gameBoard[0][0] == ' ' && gameBoard[1][1] == winningSymbol && gameBoard[2][2] == winningSymbol) {
            winningTurn = true;
            winningCoords[0] = 0;
            winningCoords[1] = 0;
        }

        else if(gameBoard[0][2] == winningSymbol && gameBoard[1][1] == winningSymbol && gameBoard[2][0] == ' ') {
            winningTurn = true;
            winningCoords[0] = 2;
            winningCoords[1] = 0;
        }
        else if(gameBoard[0][2] == winningSymbol && gameBoard[1][1] == ' ' && gameBoard[2][0] == winningSymbol) {
            winningTurn = true;
            winningCoords[0] = 1;
            winningCoords[1] = 1;
        }
        else if(gameBoard[0][2] == ' ' && gameBoard[1][1] == winningSymbol && gameBoard[2][0] == winningSymbol) {
            winningTurn = true;
            winningCoords[0] = 0;
            winningCoords[1] = 2;
        }


        if(winningTurn) {
            return winningCoords;
        }
        return new int[0];

    }

}