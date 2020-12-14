package chess;

import board.ChessBoardPosition;
import exceptions.GameException;
import exceptions.StatusException;

import java.util.HashMap;

public class ChessImpl implements Chess {
    private Status status = Status.START;
    HashMap<ChessColor, String> player = new HashMap<>();

    @Override
    public ChessColor pick(String playerName, ChessColor wantedColor) throws GameException, StatusException {
        if(this.status != Status.START && this.status != Status.ONE_PICKED){
            throw new StatusException("You called pick() in the wrong status.");
        }

        ChessColor takenColor = null;
        // already chosen a color?
        takenColor = this.getTakenColor(playerName, ChessColor.black);
        if(takenColor == null){
            takenColor = this.getTakenColor(playerName, ChessColor.white);
        }

        //imposter?
        if(takenColor == null && this.player.values().size() == 2){
            throw new GameException("Both colors are taken. Please wait, " + playerName);
        }

        //already chosen a color?
        if(takenColor != null){ // yes - color chosen
            // = wanted color?
            if(takenColor == wantedColor) return wantedColor;

            // change of heart - change color?
            if(this.player.get(wantedColor) == null){ // yes - color is available
                this.player.remove(takenColor);
                this.player.put(wantedColor, playerName);
                return wantedColor;
            } else{ // no - live with it
                return takenColor;
            }
        } else { // no - color not chosen yet
            // wanted color available?
            if(this.player.get(wantedColor) == null){ // yes - color available
                this.player.put(wantedColor, playerName);
                this.changeStatusAfterPickingColor();
                return wantedColor;
            } else { // no - color taken
                ChessColor otherColor = wantedColor == ChessColor.white ? ChessColor.black : ChessColor.white;
                this.player.put(otherColor, playerName);
                this.changeStatusAfterPickingColor();
                return otherColor;
            }
        }
    }

    private ChessColor getTakenColor(String playerName, ChessColor color){
        String name = this.player.get(color);
        if(name != null && name.equalsIgnoreCase(playerName)){
            return color;
        }
        return null;
    }

    private void changeStatusAfterPickingColor(){
        this.status = this.status == Status.START ? Status.ONE_PICKED : Status.ACTIVE_WHITE;
    }

    @Override
    public boolean setPosition(ChessColor color, ChessBoardPosition position) throws GameException, StatusException {
        if(this.status != Status.ACTIVE_BLACK && this.status != Status.ACTIVE_WHITE){
            throw new StatusException("You called setPosition() in the wrong status.");
        }
        return false;
    }
}
