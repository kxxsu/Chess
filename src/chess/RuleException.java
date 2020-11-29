package chess;

public class RuleException extends Exception{

    /**
     * Used if player attempts an invalid move
     */
    public RuleException(){
        super();
    }
    public RuleException(String message){
        super(message);
    }
    public RuleException(String message, Throwable t){
        super(message, t);
    }
}
