package chess;

import org.junit.Assert;
import org.junit.Test;

public class UsageTests {
    public static final String MELISA = "Melisa";
    public static final String HUSSY = "Huseyin";
    public static final String IMPOSTER = "Imposter";

    private Chess getChess(){
        return new ChessImpl();
    }

    @Test
    public void goodPickColor1() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.black);

        Assert.assertEquals(ChessColor.black, melisaColor);
    }
    @Test
    public void goodPickColor2() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.black);
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.white);

        Assert.assertEquals(ChessColor.black, melisaColor);
        Assert.assertEquals(ChessColor.white, huseyinColor);
    }

    @Test
    public void goodPickColor3() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.white);

        Assert.assertEquals(ChessColor.white, melisaColor);
        Assert.assertEquals(ChessColor.black, huseyinColor);
    }

    @Test
    public void goodPickColor4() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.white);
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);

        Assert.assertEquals(ChessColor.white, huseyinColor);
        Assert.assertEquals(ChessColor.black, melisaColor);
    }

    @Test(expected = StatusException.class)
    public void badPickColor3Times() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.white);
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);
        ChessColor imposterColor = chess.pick(IMPOSTER, ChessColor.white);
    }

    @Test
    public void goodPickColor5() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);
        //reconsidered
        melisaColor = chess.pick(MELISA, ChessColor.black);
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.white);

        Assert.assertEquals(ChessColor.black, melisaColor);
        Assert.assertEquals(ChessColor.white, huseyinColor);
    }

    @Test
    public void goodSet1() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.black);

        ChessBoardPosition position= new ChessBoardPosition("A", 3);
        Assert.assertFalse(chess.setPosition(ChessColor.white, position));
    }

    @Test(expected = GameException.class)
    public void badSetOutside1() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.black);

        ChessBoardPosition position = new ChessBoardPosition("Z", 6);

        chess.setPosition(ChessColor.black, position);
    }

    @Test(expected = GameException.class)
    public void badSetOutside2() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.black);

        ChessBoardPosition position = new ChessBoardPosition("E", 62);

        chess.setPosition(ChessColor.black, position);
    }

    @Test(expected = GameException.class)
    public void marginSet1() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.black);

        ChessBoardPosition position = new ChessBoardPosition("A", 8);
        Assert.assertFalse(chess.setPosition(ChessColor.white, position));
        position = new ChessBoardPosition("H", 8);
        Assert.assertFalse(chess.setPosition(ChessColor.black, position));
        position = new ChessBoardPosition("H", 1);
        Assert.assertFalse(chess.setPosition(ChessColor.white, position));
        position = new ChessBoardPosition("A", 1);
        Assert.assertFalse(chess.setPosition(ChessColor.black, position));
    }

    @Test(expected = StatusException.class)
    public void badStatus1() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessBoardPosition position = new ChessBoardPosition("B", 5);
        chess.setPosition(ChessColor.white, position);
    }

    @Test(expected = StatusException.class)
    public void badStatus2() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.black);

        ChessBoardPosition position = new ChessBoardPosition("A", 4);
        chess.setPosition(ChessColor.white, position);
        chess.pick(HUSSY, ChessColor.white);
    }

    @Test(expected = GameException.class)
    public void badSamePosition1() throws GameException, StatusException {
        Chess chess = this.getChess();
        ChessColor melisaColor = chess.pick(MELISA, ChessColor.white);
        ChessColor huseyinColor = chess.pick(HUSSY, ChessColor.black);

        ChessBoardPosition position = new ChessBoardPosition("A", 3);
        chess.setPosition(ChessColor.white, position);
        chess.setPosition(ChessColor.black, position);
    }

}
