package board;

import chess.ChessColor;

public class ChessBoard implements IChessBoard {
    private Tile[][] board;

    public ChessBoard() {
        this.board = new Tile[8][8];
        makeBoard();
        fillBoard();
    }

    public Tile[][] getBoard() {
        return board;
    }

    @Override
    public void makeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new Tile(ChessColor.white);
            }

        }
    }

    @Override
    public void fillBoard() {

    }
}
