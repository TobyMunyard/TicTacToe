import java.util.*;

public class TicTacToe{

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        char[][] board = new char[3][3];
        char player = 'X';
        while(!isFull(board)){
        System.out.println(player + "'s turn! Enter the row you want to place " + player + " (0-2): ");
        int row, col;
        Scanner input = new Scanner(System.in);
        row = input.nextInt();
        System.out.println(player + "'s turn! Now the column: ");
        col = input.nextInt();
        if(!isValidMove(board, row, col)){
            System.out.println("Invalid move! Try Again.");
        }else{
            board[row][col] = player;
            printBoard(board);
            if(isWinner(board, 'X')){
                System.out.println("X won!");
                input.close();
                return;
            }
            if(isWinner(board, 'O')){
                System.out.println("O won!");
                input.close();
                return;
            }
            else if(isFull(board)){
                System.out.println("Draw!");
                input.close();
                return;
            }
            if(player == 'X'){
                player = 'O';
            }else{
                player = 'X';
            }
        }
        }
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                if(board[i][j] == '\u0000'){
                    System.out.print(" ");
                }
                System.out.print(board[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static boolean isWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static boolean isFull(char[][] board) { 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\u0000') {
                    return false;
                }
            }
        }
        System.out.println("The board is full!");
        printBoard(board);
        return true;
     }

     public static boolean isValidMove(char[][] board, int row, int col) {
        if(row < 3 && row > -1 && col < 3 && col > -1) {
            if(board[row][col] == '\u0000') {
                return true;
            }
        }
        return false;
     }
}