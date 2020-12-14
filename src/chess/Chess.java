package chess;

import board.ChessBoardPosition;
import exceptions.GameException;
import exceptions.StatusException;

public interface Chess {
    /**
     * Pick a color to play
     * @param playerName player name
     * @param wantedColor player asks for this color. It can be a race condition.
     * @return selected color
     * @throws GameException both colors are already taken. Third player tries to enter.
     * @throws StatusException can only be called if game has not started yet
     */
    ChessColor pick(String playerName, ChessColor wantedColor) throws GameException, StatusException;

    /**
     * set a piece on a position on the board
     * @param color color of piece
     * @param position position on the board, structured by coordinates
     * @return true if won, false if otherwise
     * @throws GameException position out of bounds, or position occupied
     * @throws StatusException not on status play
     */
    boolean setPosition(ChessColor color, ChessBoardPosition position)throws GameException, StatusException;
}
