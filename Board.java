/*
The Board class represents the Tic Tac Toe board.
*/

public class Board {

    public static final int ROWS = 3;
    public static final int COLS = 3;
    public static final int CELLS = 9;

    // Cell[][] cells;
    Cell[] cells;
    int currentRow, currentCol;  // the current player's row and column

    /** Constructor to initialize the game board */
    public Board() {
        cells = new Cell[CELLS];  // Create the cells array
        for (int i = 0; i < CELLS; ++i) {
            cells[i] = new Cell(i, Player.Empty); // allocate element of the array
        }
    }

    /** Returns true if the game is a draw, aka if there aren't any more empty cells */
    public boolean isDraw() {
        int count = 0; 
        for (int i = 0; i < cells.length; i++)
        {
            if (cells[i].isEmpty())
            {
                count ++; 
            }
        }
        if (count == 0)
        {
            return true;
        }

        // TODO: Check every cell in the cells array
        // Return false if any of the cells is empty, otherwise return true if all the cells are filled
        return false;
    }

    // TODO: we should return true if player p has won, and false otherwise
    // This means we need to check all possible combinations of winning
    // If any of them is true, return true
    public boolean hasWon(Player p) {

        if (cells[0].player == p && cells[1].player == p && cells[2].player == p)
        {
            return true; 
        }
        else if (cells[3].player == p && cells[4].player == p && cells[5].player == p)
        {
            return true; 
        }
        else if (cells[6].player == p && cells[7].player == p && cells[8].player == p)
        {
            return true; 
        }
        else if (cells[0].player == p && cells[3].player == p && cells[6].player == p)
        {
            return true; 
        }
        else if (cells[1].player == p && cells[4].player == p && cells[7].player == p)
        {
            return true; 
        }
        else if (cells[2].player == p && cells[5].player == p && cells[8].player == p)
        {
            return true; 
        }
        else if (cells[0].player == p && cells[4].player == p && cells[8].player == p)
        {
            return true; 
        }
        else if (cells[2].player == p && cells[4].player == p && cells[6].player == p)
        {
            return true; 
        }


        return false;
    }   

    public void printBoard() {
        for (int i = 0; i < CELLS; i++) {
            cells[i].print();
            if(i != 2 && i != 5 && i != 8) {
                System.out.print("|");
            } else {
                System.out.println();
                System.out.println("-----------");
            }
        }
    }

    public void printEmptyBoard() {
        for (int i = 0; i < CELLS; i++) {
            System.out.print(" " + i + " ");
            if(i != 2 && i != 5 && i != 8) {
                System.out.print("|");
            } else {
                System.out.println();
                System.out.println("-----------");
            }
        }
    }

}