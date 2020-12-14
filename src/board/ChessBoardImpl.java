package board;

public class ChessBoardImpl implements ChessBoard{
    private final Tile[][] board;

    public ChessBoardImpl(Tile[][] board) {
        this.board = board;
    }

    public Tile[][] getBoard() {
        return board;
    }

    @Override
    public void makeBoard(Tile[][] tiles) {

    }

    @Override
    public void fillBoard() {

    }
}
