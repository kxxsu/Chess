package chess;

import board.ChessBoard;
import board.Tile;
import org.junit.Assert;
import org.junit.Test;
import pieces.ChessPiece;
import pieces.ChessPieceType;

public class BoardTests {

    ChessBoard board = new ChessBoard();

    @Test
    public void goodSetColorTest() {
        Tile tile = new Tile(ChessColor.white);
        Assert.assertEquals(tile.getColor(), ChessColor.white);
        tile.setColor(ChessColor.black);
        Assert.assertEquals(tile.getColor(), ChessColor.black);
    }

    @Test
    public void goodTestBoardColorsTest() {
        Assert.assertEquals(board.getBoard()[0][0].getColor(), ChessColor.white);
        Assert.assertEquals(board.getBoard()[0][1].getColor(), ChessColor.black);
        Assert.assertEquals(board.getBoard()[0][2].getColor(), ChessColor.white);
        Assert.assertEquals(board.getBoard()[1][0].getColor(), ChessColor.black);
        Assert.assertEquals(board.getBoard()[1][1].getColor(), ChessColor.white);
        Assert.assertEquals(board.getBoard()[1][2].getColor(), ChessColor.black);


    }

    @Test
    public void goodNotNullTest() {
        Assert.assertNotNull(board);
    }

    @Test
    public void goodBlackPiecesExistTest() {
        Assert.assertNotNull(board.getBoard()[0][0].getPiece());
        Assert.assertNotNull(board.getBoard()[0][1].getPiece());
        Assert.assertNotNull(board.getBoard()[0][2].getPiece());
        Assert.assertNotNull(board.getBoard()[0][3].getPiece());
        Assert.assertNotNull(board.getBoard()[0][4].getPiece());
        Assert.assertNotNull(board.getBoard()[0][5].getPiece());
        Assert.assertNotNull(board.getBoard()[0][6].getPiece());
        Assert.assertNotNull(board.getBoard()[0][7].getPiece());
        Assert.assertNotNull(board.getBoard()[1][0].getPiece());
        Assert.assertNotNull(board.getBoard()[1][1].getPiece());
        Assert.assertNotNull(board.getBoard()[1][2].getPiece());
        Assert.assertNotNull(board.getBoard()[1][3].getPiece());
        Assert.assertNotNull(board.getBoard()[1][4].getPiece());
        Assert.assertNotNull(board.getBoard()[1][5].getPiece());
        Assert.assertNotNull(board.getBoard()[1][6].getPiece());
        Assert.assertNotNull(board.getBoard()[1][7].getPiece());
    }

    @Test
    public void goodWhitePiecesExistTest() {
        Assert.assertNotNull(board.getBoard()[7][0].getPiece());
        Assert.assertNotNull(board.getBoard()[7][1].getPiece());
        Assert.assertNotNull(board.getBoard()[7][2].getPiece());
        Assert.assertNotNull(board.getBoard()[7][3].getPiece());
        Assert.assertNotNull(board.getBoard()[7][4].getPiece());
        Assert.assertNotNull(board.getBoard()[7][5].getPiece());
        Assert.assertNotNull(board.getBoard()[7][6].getPiece());
        Assert.assertNotNull(board.getBoard()[7][7].getPiece());
        Assert.assertNotNull(board.getBoard()[6][0].getPiece());
        Assert.assertNotNull(board.getBoard()[6][1].getPiece());
        Assert.assertNotNull(board.getBoard()[6][2].getPiece());
        Assert.assertNotNull(board.getBoard()[6][3].getPiece());
        Assert.assertNotNull(board.getBoard()[6][4].getPiece());
        Assert.assertNotNull(board.getBoard()[6][5].getPiece());
        Assert.assertNotNull(board.getBoard()[6][6].getPiece());
        Assert.assertNotNull(board.getBoard()[6][7].getPiece());
    }

    @Test
    public void goodCenterPartClearAtStart() {
        Assert.assertTrue(board.getBoard()[2][0].isEmpty());
        Assert.assertTrue(board.getBoard()[2][1].isEmpty());
        Assert.assertTrue(board.getBoard()[2][2].isEmpty());
        Assert.assertTrue(board.getBoard()[2][3].isEmpty());
        Assert.assertTrue(board.getBoard()[2][4].isEmpty());
        Assert.assertTrue(board.getBoard()[2][5].isEmpty());
        Assert.assertTrue(board.getBoard()[2][6].isEmpty());
        Assert.assertTrue(board.getBoard()[2][7].isEmpty());
        Assert.assertTrue(board.getBoard()[3][0].isEmpty());
        Assert.assertTrue(board.getBoard()[3][1].isEmpty());
        Assert.assertTrue(board.getBoard()[3][2].isEmpty());
        Assert.assertTrue(board.getBoard()[3][3].isEmpty());
        Assert.assertTrue(board.getBoard()[3][4].isEmpty());
        Assert.assertTrue(board.getBoard()[3][5].isEmpty());
        Assert.assertTrue(board.getBoard()[3][6].isEmpty());
        Assert.assertTrue(board.getBoard()[3][7].isEmpty());
        Assert.assertTrue(board.getBoard()[4][0].isEmpty());
        Assert.assertTrue(board.getBoard()[4][1].isEmpty());
        Assert.assertTrue(board.getBoard()[4][2].isEmpty());
        Assert.assertTrue(board.getBoard()[4][3].isEmpty());
        Assert.assertTrue(board.getBoard()[4][4].isEmpty());
        Assert.assertTrue(board.getBoard()[4][5].isEmpty());
        Assert.assertTrue(board.getBoard()[4][6].isEmpty());
        Assert.assertTrue(board.getBoard()[4][7].isEmpty());
        Assert.assertTrue(board.getBoard()[5][0].isEmpty());
        Assert.assertTrue(board.getBoard()[5][1].isEmpty());
        Assert.assertTrue(board.getBoard()[5][2].isEmpty());
        Assert.assertTrue(board.getBoard()[5][3].isEmpty());
        Assert.assertTrue(board.getBoard()[5][4].isEmpty());
        Assert.assertTrue(board.getBoard()[5][5].isEmpty());
        Assert.assertTrue(board.getBoard()[5][6].isEmpty());
        Assert.assertTrue(board.getBoard()[5][7].isEmpty());
    }

    @Test
    public void goodPawnsOnPosition() {
        Assert.assertEquals(board.getBoard()[1][0].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][1].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][2].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][3].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][4].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][5].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][6].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][7].getPiece(), ChessPieceType.Pawn);

        Assert.assertEquals(board.getBoard()[6][0].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][1].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][2].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][3].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][4].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][5].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][6].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][7].getPiece(), ChessPieceType.Pawn);
    }

    @Test
    public void goodPawnsColors() {
        Assert.assertEquals(board.getBoard()[1][0].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][1].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][2].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][3].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][4].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][5].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][6].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[1][7].getPiece(), ChessPieceType.Pawn);

        Assert.assertEquals(board.getBoard()[6][0].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][1].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][2].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][3].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][4].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][5].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][6].getPiece(), ChessPieceType.Pawn);
        Assert.assertEquals(board.getBoard()[6][7].getPiece(), ChessPieceType.Pawn);

    }

    @Test
    public void goodWhitePawnsOnPosition() {

    }

    @Test
    public void goodRooksOnPosition() {
        Assert.assertEquals(board.getBoard()[0][0].getPiece(), ChessPieceType.Rook);
        Assert.assertEquals(board.getBoard()[0][7].getPiece(), ChessPieceType.Rook);

        Assert.assertEquals(board.getBoard()[7][7].getPiece(), ChessPieceType.Rook);
        Assert.assertEquals(board.getBoard()[7][7].getPiece(), ChessPieceType.Rook);
    }

    @Test
    public void goodKnightsOnPosition() {
        Assert.assertEquals(board.getBoard()[0][1].getPiece(), ChessPieceType.Knight);
        Assert.assertEquals(board.getBoard()[0][6].getPiece(), ChessPieceType.Knight);

        Assert.assertEquals(board.getBoard()[7][1].getPiece(), ChessPieceType.Knight);
        Assert.assertEquals(board.getBoard()[7][6].getPiece(), ChessPieceType.Knight);
    }

    @Test
    public void goodBishopsOnPosition() {
        Assert.assertEquals(board.getBoard()[0][2].getPiece(), ChessPieceType.Bishop);
        Assert.assertEquals(board.getBoard()[0][5].getPiece(), ChessPieceType.Bishop);

        Assert.assertEquals(board.getBoard()[7][2].getPiece(), ChessPieceType.Bishop);
        Assert.assertEquals(board.getBoard()[7][5].getPiece(), ChessPieceType.Bishop);
    }

    @Test
    public void goodQueensOnPosition() {
        Assert.assertEquals(board.getBoard()[0][3].getPiece(), ChessPieceType.Queen);

        Assert.assertEquals(board.getBoard()[7][3].getPiece(), ChessPieceType.Queen);
    }

    @Test
    public void goodKingsOnPosition() {
        Assert.assertEquals(board.getBoard()[0][4].getPiece(), ChessPieceType.King);

        Assert.assertEquals(board.getBoard()[7][4].getPiece(), ChessPieceType.King);
    }

}
