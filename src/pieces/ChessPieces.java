package pieces;

import chess.ChessColor;

public abstract class ChessPieces {
    ChessColor color;
    ChessPieceType type;

    public ChessPieces(ChessColor color, ChessPieceType type) {
        this.color = color;
        this.type = type;
    }
}
