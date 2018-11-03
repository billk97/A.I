import java.util.Scanner;
import java.util.*;
import  java.io.*;
public class Play {
    public  State game1 = new State();//creation of an Object State named game1
    public  int CountDotForEachPlayer=0;//a counter helps determine which player turn it is
    GamePlayer gamePlayer;
    int maxDepth = 3;
    public  void play()
    {
        boolean exit = false ;
        game1.Initializer();
        /**by Color we mean ether X od O **/
        String Color;
        Scanner reader = new Scanner(System.in);
        System.out.println("choose X or O: ");
        Color = reader.nextLine();
        String OppositeColor;//the opposite color ex. Color=O --> OppositeColor=X
        /**checks if given value is a desired value**/
        while(!(Color.equals("O"))&&!(Color.equals("X")))
        {
            System.out.println("choose X or O: ");
            Color = reader.nextLine();
        }
        /**creates the opposite color (the other player)**/
        OppositeColor=FindOpositeColore(Color);
        gamePlayer= new GamePlayer(maxDepth,OppositeColor);
        /**useful its a simple counter**/
        int count=1;

        while(exit == false)
        {
            /**scarifies which players turn it is by dividing with 2
             * if it's the first players turn then count mod 2 should not be 0
             * player 1 count 1 3 5 7 9 11 13 15 17 19 21 23
             * player 2 count 2 4 6 8 10 12 14 16 18 20 22**/
            if(game1.isFull()){
                game1.print();
                game1.FinalResult();//checks if game is over
                break;//exits
            }
            if(CountDotForEachPlayer==2){
                game1.FinalResult();//checks if game is over
                break;//exits
            }
            if(count %2 == 0)
            {

                /**players 2 turn **/
                count = AITurn(OppositeColor,count);
            }
            else
            {
                /**players 1 turn **/
                count =  PlayerTurn(Color,count);
            }
        }//end while
        reader.close();
    }//end Play
    /**this function checks if the user has given the correct type of value (an integer)**/
    public  int TryCachFunction(String XorY, String tipos)
    {
        Scanner reader = new Scanner(System.in);
        int y=0;
        while(true)
        {
            try
            {
                y = reader.nextInt();//could cause an exception if input is string
                break;
            }catch(Exception  e)
            {
                /**doing samething to prevent the exception **/
                System.out.println("Wrong Input");
                reader.next();//waits for the next INPUT
                System.out.println(XorY+" which  "+tipos+ " ");
                System.out.print(XorY+": ");
            }
        }
        return y;
    }//end of TryCachFunction
    /**nothing  spacial self explanatory **/
    private  String FindOpositeColore(String Color)
    {
        String OppositeColor="O";
        if (Color.equals("O"))
        {
            OppositeColor="X";
        }
        else if(Color.equals("X"))
        {
            OppositeColor="O";
        }
        return OppositeColor;
    }//end of FindOpositeColore
    /**gets called in the play function every time its time to make a move**/

    private int AITurn(String Color,int count)
    {
        System.out.println("Playing: "+Color);
        game1.Predict(Color);//gives the legal (game rules) next possible moves for the Color (puts a dot in that place)
        int counterDot=game1.CountDot();//count how many dots(next possible moves) are inside the table
        /**if there are no more . in the table for the player it means
         * there are no more valued moves  for him to play
         *prints the appropriate message and returns **/
        if(counterDot==0){
            count++;
            CountDotForEachPlayer++;
            System.out.println("You don't have any moves");
            return count;
        }
        CountDotForEachPlayer=0;
        game1.Score();
        game1.print();
        int x=0 , y=0;

        Move move = gamePlayer.MiniMax(game1);
        game1.DeleteDot();
        game1.addElement(move.getRow(),move.getCol(),Color);
        game1.FlipElements(move.getRow(),move.getCol(),Color);
        count ++;

        return count;
    }

    private  int PlayerTurn(String Color ,int count )
    {
        System.out.println("Playing: "+Color);
        game1.Predict(Color);//gives the legal (game rules) next possible moves for the Color (puts a dot in that place)
        int counterDot=game1.CountDot();//count how many dots(next possible moves) are inside the table
        /**if there are no more . in the table for the player it means
         * there are no more valued moves  for him to play
         *prints the appropriate message and returns **/
        if(counterDot==0){
            count++;
            CountDotForEachPlayer++;
            System.out.println("You don't have any moves");
            return count;
        }
        CountDotForEachPlayer=0;
        game1.Score();
        game1.print();
        int x=0 , y=0;
        System.out.println("X which row ");
        System.out.print("X: ");
        /**should catch the exception  **/
        x = TryCachFunction("X","row");
        System.out.println("Y which column  ");
        System.out.print("Y: ");
        /**should catch the exception  **/
        y = TryCachFunction("Y","column");
        if(x<=game1.getHeight()&&y<=game1.getWidth() && game1.isDot(x,y)== true && (Color.equals("X")||  Color.equals("O")))
        {
            game1.DeleteDot();
            game1.addElement(x,y,Color);
            game1.FlipElements(x,y,Color);
            count ++;
        }
        else
        {
            System.out.println("Move not valid please retry !");
        }
        return count;
    }//end PlayerTurn

    

}//end Play
