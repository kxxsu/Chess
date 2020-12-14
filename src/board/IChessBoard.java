package board;

public interface IChessBoard {
    /**
     * Create a game board of colored tiles
     */
    void makeBoard();

    /**
     * Set pieces on their initial start positions on an empty board
     */
    void fillBoard();
}
