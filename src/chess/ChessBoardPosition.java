package chess;

public class ChessBoardPosition {
    private final String xCoordinate;
    private final int yCoordinate;

    public ChessBoardPosition(String xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    String getXCoordinate(){
        return this.xCoordinate;
    }
    int getYCoordinate(){
        return this.yCoordinate;
    }
}
