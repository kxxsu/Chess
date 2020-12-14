package protocolEngine;

import chess.Chess;
import board.ChessBoardPosition;
import chess.ChessColor;
import exceptions.GameException;
import exceptions.StatusException;

import java.io.*;

public class ChessProtocolEngine implements Chess {
    private final OutputStream os;
    private final InputStream is;
    private final Chess gameEngine;

    public static final int METHOD_PICK = 0;
    public static final int METHOD_SET = 1;

    public static final int COLOR_BLACK = 0;
    public static final int COLOR_WHITE = 1;

    private static final String ERROR_COMMAND = "Could not serialize command.";
    private static final String ERROR_COLOR = "Unknown color: ";
    private static final String ERROR_METHOD_ID = "Unknown method ID: ";

    public ChessProtocolEngine(InputStream is, OutputStream os, Chess gameEngine) {
        this.os = os;
        this.is = is;
        this.gameEngine = gameEngine;
    }

    @Override
    public ChessColor pick(String playerName, ChessColor wantedColor) throws GameException, StatusException {
        DataOutputStream dos = new DataOutputStream(this.os);

        try {
            //write method id
            dos.writeInt(METHOD_PICK);
            dos.writeUTF(playerName);

            switch (wantedColor) {
                case black:
                    dos.writeInt(COLOR_BLACK);
                    break;
                case white:
                    dos.writeInt(COLOR_WHITE);
                    break;
                default:
                    throw new GameException(ERROR_COLOR + wantedColor);
            }
        } catch (IOException e) {
            throw new GameException(ERROR_COMMAND, e);
        }

        return null; //TODO
    }

    public void deserializePick() throws GameException {
        DataInputStream dis = new DataInputStream(this.is);
        ChessColor wantedColor = null;

        try {
            String playerName = dis.readUTF();
            int colorInt = dis.readInt();

            switch (colorInt) {
                case COLOR_BLACK:
                    wantedColor = ChessColor.black;
                    break;
                case COLOR_WHITE:
                    wantedColor = ChessColor.white;
                    break;
                default:
                    throw new GameException(ERROR_COLOR + wantedColor);
            }
            this.gameEngine.pick(playerName, wantedColor);

        } catch (IOException | StatusException e) {
            throw new GameException(ERROR_COMMAND, e);
        }

    }

    @Override
    public boolean setPosition(ChessColor color, ChessBoardPosition position) throws GameException, StatusException {
        DataOutputStream dos = new DataOutputStream(this.os);

        try {
            dos.writeInt(METHOD_SET);

            switch (color) {
                case black:
                    dos.writeInt(COLOR_BLACK);
                    break;
                case white:
                    dos.writeInt(COLOR_WHITE);
                    break;
                default:
                    throw new GameException(ERROR_COLOR + color);
            }

            dos.writeUTF(position.getXCoordinate());
            dos.writeInt(position.getYCoordinate());

        } catch (IOException e) {
            throw new GameException(ERROR_COMMAND, e);
        }

        return false;
    }

    public void deserializeSet() throws GameException {
        DataInputStream dis = new DataInputStream(this.is);
        ChessColor color = null;

        try {
            int colorInt = dis.readInt();

            switch (colorInt) {
                case COLOR_BLACK:
                    color = ChessColor.black;
                    break;
                case COLOR_WHITE:
                    color = ChessColor.white;
                    break;
                default:
                    throw new GameException(ERROR_COLOR + color);
            }

            String xCoordinate = dis.readUTF();
            int yCoordinate = dis.readInt();

            ChessBoardPosition position = new ChessBoardPosition(xCoordinate, yCoordinate);

            this.gameEngine.setPosition(color, position);

        } catch (IOException | StatusException e) {
            throw new GameException(ERROR_COMMAND, e);
        }
    }


    public void read() throws GameException {
        DataInputStream dis = new DataInputStream(this.is);

        try {
            int commandID = dis.readInt();
            switch (commandID) {
                case METHOD_PICK:
                    this.deserializePick();
                    break;
                case METHOD_SET:
                    this.deserializeSet();
                    break;
                default:
                    throw new GameException(ERROR_METHOD_ID + commandID);
            }
        } catch (IOException e) {
            throw new GameException(ERROR_COMMAND, e);
        }
    }

}
