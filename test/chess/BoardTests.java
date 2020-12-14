package chess;

import board.ChessBoard;
import board.ChessBoardImpl;
import board.Tile;
import org.junit.Assert;
import org.junit.Test;

public class BoardTests {

    Tile[][] tiles = new Tile[8][8];
    ChessBoardImpl board = null;

    @Test
    public void goodSetColorTest() {
        Tile tile = new Tile(ChessColor.white);
        Assert.assertEquals(tile.getColor(), ChessColor.white);
        tile.setColor(ChessColor.black);
        Assert.assertEquals(tile.getColor(), ChessColor.black);
    }

    @Test
    public void goodTestBoardColorsTest() {
        board.makeBoard(tiles);
        Assert.assertEquals(board.getBoard()[0][0].getColor(), ChessColor.white);
        Assert.assertEquals(board.getBoard()[0][1].getColor(), ChessColor.black);
        Assert.assertEquals(board.getBoard()[0][2].getColor(), ChessColor.white);
    }
}
