import java.util.Scanner;
/**
 * The main class for the Tic-Tac-Toe 
 * It acts as the overall controller of the game.
 * Inspired by: https://www.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe.html
 */

public class GameMain {
    private Board board;            // the game board
    private Player currentPlayer;     // the current player (of enum Seed)

    private static Scanner in = new Scanner(System.in);  // input Scanner

    // TODO: Fill in the missing statements to set up the game!
    public GameMain() {
        board = new Board();  // allocate game-board
        board.printEmptyBoard();
        currentPlayer = Player.PlayerX;       // CROSS plays first
        while(!board.isDraw()) {
            // 1. While we are playing the game, first we want to print the current state of the board
                board.printBoard(); 
            
            // 2. We want to print out whose turn it is (the current player)
                printCurrentPlayer(currentPlayer);
            // 3. We want the current player to make a move
                playerMove(currentPlayer); 

            if (board.hasWon(currentPlayer)) { 
                board.printBoard();
                switch (currentPlayer) { 
                    case PlayerO: System.out.println("Congrats, Player O has won!");
                    case PlayerX: System.out.println("Congrats, Player X has won!");
                }
                return;
            }
            // 4. We want to switch the current player to the next player.
            currentPlayer = switchPlayer(currentPlayer);
        }
        board.printBoard();
        System.out.println("Game over.");
    }

    /** The player with "theSeed" makes one move, with input validation.
     Update Cell's content, Board's currentRow and currentCol. */
    public void playerMove(Player p) {
        boolean validInput = false;  // for validating input
        do {
        if (p == Player.PlayerX) {
            System.out.print("Player 'X', enter your move (0-8): ");
        } else {
            System.out.print("Player 'O', enter your move (0-8): ");
        }
        int entry = in.nextInt();
        if (entry >= 0 && entry <=8
                && board.cells[entry].player == Player.Empty) {
            board.cells[entry].player = p;
            validInput = true; // input okay, exit loop
        } else {
            System.out.println("This move at " + (entry)
                     + " is not valid. Try again...");
        }
        } while (!validInput);   // repeat until input is valid
    }

    public Player switchPlayer(Player p) {
        switch (p) {
            case PlayerX:  return Player.PlayerO;
            default: return Player.PlayerX;
        }
    }
    
    // TODO: If it is player X's turn, we should print that out
    // If it is player O's turn, we should print that out instead.
    public void printCurrentPlayer(Player p) {
        if (p == Player.PlayerX)
        {
            System.out.println ("It is player X's turn");
        }
        else 
        {
            System.out.println ("It is player Y's turn");
        }
    }

    public static void main(String[] args) {
        new GameMain();
    }
}