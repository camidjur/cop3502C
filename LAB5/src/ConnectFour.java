import java.util.Arrays;
import java.util.Scanner;

public class ConnectFour {
    public static void printBoard(char[][] array){

        for (int row = array.length-1; row >= 0; row--){
            for (int col = 0; col < array[0].length; col++){
                System.out.print(array[row][col]);
            }
            System.out.println();
        }
        // needs to be printed top down
        // prints board so that chip falls to the bottom
    }
    public static void initializeBoard(char [][] array){

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                array[row][col] = '-';
            }
        }
        // initializes the array with -
        // used to later print the board

    }
    public static int insertChip(char [][] array, int col, char chipType){
        // called after each player
        int i;
        for (i = 0; i <array.length; i++) {
            if (array[i][col] != '-') {
                continue;
            }
            array[i][col] = chipType;
            break;
        }
        return i;
        // inserts chip into array
        // makes sure that a token is not replaced
    }
    public static boolean checkIfWinner(char [][] array, int col, int row, char chipType){

        int count = 0;
        for ( int i= 0; i < array.length; i++){
            if (array[i][col] == chipType){
                count++;
            }
            else{
                count = 0;
            }
            if (count == 4){
                return true;
            }
        }
        for (int i = 0; i < array[row].length; i++){
            if(array[row][i] == chipType){
                count++;
            }
            else{
                count = 0;
            }
            if (count == 4){
                return true;
            }
        }
        return false;
        // checks if there is a winner after each move
        // only if there are 4 chips of the same type
    }
    public static boolean boardIsFull(char [][] array){
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                if (array[row][col] == '-') {
                    return false;
                }
            }
        }
        return true;
        // calls it a tie if the board is full
        // only gets called if there is no winner
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row;
        int column;
        int userInput;
        char [][] board = {};
        char player1chip = 'x';
        char player2chip = 'o';
        int chipsRow;

        System.out.println("What would you like the height of the board to be?");
        row = scanner.nextInt();
        System.out.println("What would you like the length of the board to be?");
        column = scanner.nextInt();
        board = new char[row][column];

        initializeBoard(board);
        printBoard(board);

        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        // prints initial circumstances
        // no need to be in loop

        while (true ) {

            System.out.println("Player 1: Which column would you like to choose?");
            userInput = scanner.nextInt();
            chipsRow = insertChip(board, userInput, player1chip);
            printBoard(board);
            if (checkIfWinner(board, userInput, chipsRow, player1chip)){
                System.out.println("Player 1 won the game!");
                break;
            }
             if (boardIsFull(board)){
                System.out.println("Draw. Nobody wins.");
                break;
            }

            System.out.println("Player 2: Which column would you like to choose?");
            userInput = scanner.nextInt();
            chipsRow = insertChip(board, userInput, player2chip);
            printBoard(board);
            if (checkIfWinner(board, userInput, chipsRow, player2chip)){
                System.out.println("Player 2 won the game!");
                break;
            }
             if (boardIsFull(board)){
                System.out.println("Draw. Nobody wins.");
                break;
            }
            // after each player goes it checks if they won
            // if they didn't the game continues
        }
        /* citations:
        - Exception out of bounds in insertChip method TA Zachary Utt
        - logic error when calling boardIsFull TA Zachary Utt
         - logic error with initialization of row and column TA Andrew*/

    }
}
