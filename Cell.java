/*
This class represents a single cell in the tic tac toe board.
*/

public class Cell {

    // player = 0 if empty
    // player = 1 if filled with an x
    // player = 2 if filled with an o
    Player player;
    public int cellNumber;

    public Cell(int cellNumber, Player p) {
        this.cellNumber = cellNumber;
        this.player = p;
    }

    public boolean isEmpty() {
        return (this.player == Player.Empty);
    }

    public void print() {
        switch (player) {
            case PlayerX:  System.out.print(" X "); break;
            case PlayerO: System.out.print(" O "); break;
            case Empty:  System.out.print("  "); break;
        }
    }
}