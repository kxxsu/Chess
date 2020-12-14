package chess;

import board.ChessBoardPosition;
import exceptions.GameException;
import exceptions.StatusException;
import org.junit.Assert;
import org.junit.Test;
import protocolEngine.ChessProtocolEngine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ProtocolTests {

    public static final String MELISA = "Melisa";
    Chess chess = this.getChess();

    private Chess getChessEngine(InputStream is, OutputStream os, Chess gameEngine) {
        return new ChessProtocolEngine(is, os, gameEngine);
    }

    private Chess getChess() {
        return new ChessImpl();
    }


    @Test
    public void pickTest1() throws GameException, StatusException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Chess chessProtocolEngine = this.getChessEngine(null, baos, null);
        ChessColor melisaColor = chessProtocolEngine.pick(MELISA, ChessColor.black);

        // simulate network
        byte[] serializedBytes = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(serializedBytes);

        ChessReadTester chessReceiver = new ChessReadTester();
        Chess chessProtocolReceiver = this.getChessEngine(bais, null, chessReceiver);

        ChessProtocolEngine chessEngine = (ChessProtocolEngine) chessProtocolReceiver;
        chessEngine.read();

        Assert.assertTrue(chessReceiver.lastCallPick);
        Assert.assertTrue(chessReceiver.playerName.equalsIgnoreCase(MELISA));
        Assert.assertEquals(ChessColor.black, chessReceiver.color);
    }

    @Test
    public void setTest1() throws GameException, StatusException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Chess chessProtocolSender = this.getChessEngine(null, baos, null);

        ChessBoardPosition position = new ChessBoardPosition("C", 3);
        chessProtocolSender.setPosition(ChessColor.white, position);

        //simulate network
        byte[] serializedBytes = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(serializedBytes);

        ChessReadTester chessReceiver = new ChessReadTester();
        Chess chessProtocolReceiver = this.getChessEngine(bais, null, chessReceiver);

        //TODO
        ChessProtocolEngine chessEngine = (ChessProtocolEngine) chessProtocolReceiver;
        chessEngine.read();

        Assert.assertTrue(chessReceiver.lastCallSet);
        Assert.assertEquals(ChessColor.white, chessReceiver.color);
        Assert.assertTrue(chessReceiver.position.getXCoordinate().equalsIgnoreCase("C"));
        Assert.assertEquals(3, chessReceiver.position.getYCoordinate());

    }

    private class ChessReadTester implements Chess {

        private boolean lastCallPick = false;
        private boolean lastCallSet = false;

        private String playerName = null;
        private ChessColor color;
        private ChessBoardPosition position;

        @Override
        public ChessColor pick(String playerName, ChessColor wantedColor) throws GameException, StatusException {
            this.lastCallPick = true;
            this.lastCallSet = false;
            this.playerName = playerName;
            this.color = wantedColor;

            return wantedColor;
        }

        @Override
        public boolean setPosition(ChessColor color, ChessBoardPosition position) throws GameException, StatusException {
            this.lastCallSet = true;
            this.lastCallPick = false;
            this.color = color;
            this.position = position;

            return true;
        }
    }
}

