import java.util.ArrayList;
import java.util.Random;
/**this class is responsible for the the implantation of the min max algorithm   **/
public class GamePlayer {
    /**this variable stores the max depth that the min max algorithm will search**/
    private int maxDepth;
    /**this variable stores the color of the player X ,O*/
    private String PlayerColor;

    /**Constructor of GamePlayer **/
    public GamePlayer(int maxDepth, String PlayerColor) {
        this.maxDepth = maxDepth;
        this.PlayerColor = PlayerColor;
    }
    /**this function determines which player plays as  min and
     * which as max
     * X gets min
     * O gets max
     * **/
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
    /**this function  implements the max algorithm
     * which picks the leaf with the highest score  **/
    public Move max(State state,int depth)
    {
        /**creation of a object named r type Random **/
        Random r = new Random();
        /**checks if the board is full of the max Depth
         * has been reached **/
        if(state.isFull()|| depth==maxDepth )
        {
            /**returns the last move in the bottom of the tree**/
            Move lastMove = new Move(state.getLastMove().getRow(),state.getLastMove().getCol(),state.evaluate());
            return lastMove;
        }
        /**creation of an arrayList type State that will store the children's (leaf) for the player X* */
        ArrayList<State> children = new ArrayList<State>(state.getChildren("X"));
        /**the min value**/
        Move maxMove = new Move(Integer.MIN_VALUE);

        for (State child : children)
        {
            /**predicts the move of each chilled**/
            child.Predict("X");
            /**calls the min algorithm with values child and ads 1 to the dept
             * for the next lever **/
            Move move = min(child,depth+1);
            /**pruning
             * if the value of returned is bigger of the max Move value **/
            if(move.getValue()>=maxMove.getValue())
            {
                /**pruning
                 * if the value of returned is equal with the max Move value **/
                if(move.getValue()==maxMove.getValue())
                {
                    /**picks one randomly **/
                    if (r.nextInt(2)==0)
                    {
                        maxMove.setRow(child.getLastMove().getRow());
                        maxMove.setCol(child.getLastMove().getCol());
                        maxMove.setValue(move.getValue());
                    }
                }//end if2
                else
                    {
                        /**else sets the value**/
                        maxMove.setRow(child.getLastMove().getRow());
                        maxMove.setCol(child.getLastMove().getCol());
                        maxMove.setValue(move.getValue());
                    }//end else
            }// end if1
        }//end for
        return maxMove;
    }//end max

    /**this function  implements the max algorithm
     * which picks the leaf with the minimum score  **/
    public Move min(State state,int depth)
    {
        /**creation of a object named r type Random **/
        Random r = new Random();
        /**checks if the board is full of the max Depth
         * has been reached **/
        if(state.isFull()|| depth==maxDepth )
        {
            /**returns the last move in the bottom of the tree**/
            Move lastMove = new Move(state.getLastMove().getRow(),state.getLastMove().getCol(),state.evaluate());
            return lastMove;
        }
        /**creation of an arrayList type State that will store the children's (leaf) for the player O* */
        ArrayList<State> children = new ArrayList<State>(state.getChildren("O"));
        /**the max value**/
        Move minMove = new Move(Integer.MAX_VALUE);
        /**loops the array list children  until there are no more elements**/
        for (State child : children)
        {
            /**predicts the move of each chilled**/
            child.Predict("O");
            /**calls the min algorithm with values child and ads 1 to the dept
             * for the next lever **/
            Move move = max(child,depth+1);
            /**pruning
            * if the value of returned is bigger of the max Move value **/
            if(move.getValue()<= minMove.getValue())
            {
                /**pruning
                 * if the value of returned is equal with the max Move value **/
                if(move.getValue()==minMove.getValue())
                {
                    /**picks one randomly **/
                    if (r.nextInt(2)==0)
                    {
                        minMove.setRow(child.getLastMove().getRow());
                        minMove.setCol(child.getLastMove().getCol());
                        minMove.setValue(move.getValue());
                    }
                }//end if2
                else
                {
                    /**else sets the value**/
                    minMove.setRow(child.getLastMove().getRow());
                    minMove.setCol(child.getLastMove().getCol());
                    minMove.setValue(move.getValue());
                }//end else
            }// end if1
        }//end for
        return minMove;
    }//end min
}//end GamePlayer
