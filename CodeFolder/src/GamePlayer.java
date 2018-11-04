import java.util.ArrayList;
import java.util.Random;

public class GamePlayer {
    private int maxDepth;
    private String PlayerColor;

    public GamePlayer(int maxDepth, String PlayerColor) {
        this.maxDepth = maxDepth;
        this.PlayerColor = PlayerColor;
    }

    public Move MiniMax(State state) {
        if (PlayerColor.equals("X"))
        {
            return min(new State(state), 0);
        }
        else
            {
                return max(new State(state), 0);
        }
    }//end MiniMax

    public Move max(State state,int depth)
    {
        Random r = new Random();
        if(state.isFull()|| depth==maxDepth )
        {
            Move lastMove = new Move(state.getLastMove().getRow(),state.getLastMove().getCol(),state.evaluate());
            return lastMove;
        }
        ArrayList<State> children = new ArrayList<State>(state.getChildren("O"));
        Move maxMove = new Move(Integer.MIN_VALUE);
        for (State child : children)
        {   child.Predict("O");

            Move move = min(child,depth+1);
            if(move.getValue()>=maxMove.getValue())
            {
                if(move.getValue()==maxMove.getValue())
                {
                    if (r.nextInt(2)==0)
                    {
                        maxMove.setRow(child.getLastMove().getRow());
                        maxMove.setCol(child.getLastMove().getCol());
                        maxMove.setValue(move.getValue());
                    }
                }//end if2
                else
                    {
                        maxMove.setRow(child.getLastMove().getRow());
                        maxMove.setCol(child.getLastMove().getCol());
                        maxMove.setValue(move.getValue());
                    }//end else
            }// end if1
        }//end for
        return maxMove;
    }//end max

    public Move min(State state,int depth)
    {
        Random r = new Random();
        if(state.isFull()|| depth==maxDepth )
        {
            Move lastMove = new Move(state.getLastMove().getRow(),state.getLastMove().getCol(),state.evaluate());
            return lastMove;
        }
        ArrayList<State> children = new ArrayList<State>(state.getChildren("X"));
        Move minMove = new Move(Integer.MAX_VALUE);
        for (State child : children)
        {
            child.Predict("X");
            Move move = max(child,depth+1);
            if(move.getValue()<= minMove.getValue())
            {
                if(move.getValue()==minMove.getValue())
                {
                    if (r.nextInt(2)==0)
                    {
                        minMove.setRow(child.getLastMove().getRow());
                        minMove.setCol(child.getLastMove().getCol());
                        minMove.setValue(move.getValue());
                    }
                }//end if2
                else
                {
                    minMove.setRow(child.getLastMove().getRow());
                    minMove.setCol(child.getLastMove().getCol());
                    minMove.setValue(move.getValue());
                }//end else
            }// end if1
        }//end for
        return minMove;
    }//end min
}//end GamePlayer
