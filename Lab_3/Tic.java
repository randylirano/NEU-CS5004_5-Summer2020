/**
 * Tic.java
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * CS5005 Lab 3: Problem 1 - Tic Tac Toe.
 * This class serves as a simple Tic Tac Toe game printer.
 *
 * @author Randy Lirano
 * @since 2020-05-21
 */

public class Tic {
    // The name of the tic tac toe board
    private String boardName;
    // The board will be represented using 2D array
    private final String[][] board;

    /**
     * Constructor for Tic object
     */
    public Tic(String boardName) {
        this.boardName = boardName;
        this.board = new String[][] {{"_", "_", "_",},
                                     {"_", "_", "_",},
                                     {"_", "_", "_",}};
    }

    public String getBoardName() {
        return this.boardName;
    }

    public String getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void setBoardCell(int row, int col, String val) {
        this.board[row][col] = val;
    }

    public void printBoard() {
        System.out.printf("%s:\n", getBoardName());
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                System.out.printf("  %s  ", getBoardCell(row, col));
            }
            System.out.println();
        }
    }

    public void readBoardKbd(Scanner console) {
        for(String element: this.board[console.nextInt()]) {
            System.out.printf("%s  ", element);
        }
    }

    public void readBoardFile(Scanner inputFile) {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                this.setBoardCell(row, col, inputFile.next());
            }
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        // Default, empty board, exercising constructor and printBoard
        // Tic boardA = new Tic("Board A");
        // boardA.printBoard();

        // System.out.println();

        // Sample winning board for X, using constructor and setter manually
        // Tic boardB = new Tic("Board B");
        // boardB.setBoardCell(0, 0, "X");
        // boardB.setBoardCell(1, 1, "X");
        // boardB.setBoardCell(2, 2, "X");
        // boardB.setBoardCell(0, 2, "O");
        // boardB.setBoardCell(1, 2, "O");
        // boardB.printBoard();

        // Read a board B from the keyboard
        // System.out.println("Provide row number (Entry should be between 0 and 2): ");
        // boardB.readBoardKbd(console);

        // Read provided input text file
        // Build board based on the provided file
        Tic boardC = new Tic("Board C");
        // Initialize scanner to readbinput file
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(new FileInputStream("board1.txt"));
        }
        catch(FileNotFoundException e) {
            // If the file could not be found, this code is executed
            System.out.println("File not found. Quitting.");
            System.exit(0);
        }
        boardC.readBoardFile(inputFile);
        boardC.printBoard();
        inputFile.close();

        // Read multiple boards
        Scanner inputFile2 = null;
        System.out.println("Read multiple boards from a file");
        try {
            inputFile2 = new Scanner(new FileInputStream("board2.txt"));
        }
        catch(FileNotFoundException e) {
            // If the file could not be found, this code is executed
            System.out.println("File not found. Quitting.");
            System.exit(0);
        }
        int count = inputFile2.nextInt();
        Tic[] boardArray = new Tic[count];
        for(int boardNum = 0; boardNum < count; boardNum++) {
            boardArray[boardNum] = new Tic("Board " + boardNum);
            boardArray[boardNum].readBoardFile(inputFile2);
            boardArray[boardNum].printBoard();
        }
        inputFile2.close();
        console.close();
    }
    
}