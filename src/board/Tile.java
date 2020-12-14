package board;

import chess.ChessColor;
import pieces.ChessPieceType;

public class Tile {
    private ChessColor color;
    private ChessPieceType piece;

    public Tile(ChessColor color){
        this.color = color;
    }

    public Tile(ChessColor color, ChessPieceType piece) {
        this.color = color;
        this.piece = piece;
    }

    public ChessColor getColor() {
        return color;
    }

    public void setColor(ChessColor color) {
        this.color = color;
    }

    public ChessPieceType getPiece() {
        return piece;
    }

    public void setPiece(ChessPieceType piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }
}



