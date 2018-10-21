
import java.util.Scanner;
import java.util.*;
import  java.io.*;

public  class Main {





    public static State game1 = new State();
    public  static void main(String[] args)
    {
        boolean exit = false ;
        game1.Initializer();
        String Color;
        Scanner reader = new Scanner(System.in);
        System.out.println("choose X or O: ");
        Color = reader.nextLine();
        String OppositeColor;
        /**checks if given value is a desired value**/
        while(!(Color.equals("O"))&&!(Color.equals("X")))
        {
            System.out.println("choose X or O: ");
            Color = reader.nextLine();
        }
        /**creates the opposite color (the other player)**/
        OppositeColor=FindOpositeColore(Color);
        /**useful its a simple counter**/
        int count=1;

        while(exit == false)
        {
            /**scarifies which players turn it is by dividing with 2
             * if its the first players turn then count mod 2 should not be 0
             * player 1 count 1 3 5 7 9 11 13 15 17 19 21 23
             * player 2 count 2 4 6 8 10 12 14 16 18 20 22**/
            if(game1.isFull()){
                break;
            }
            if(count %2 == 0)
            {
                /**players 2 turn **/
                count = PlayerTurn(OppositeColor,count);
            }
            else
            {
                count = PlayerTurn(Color,count);
            }
            System.out.println("EXIT:?  ");
        }//end while
        reader.close();
    }//end main




    /**this function checks if the user has given the correct type of value (an integer)**/
    public static int TryCachFunction(String XorY, String tipos)
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
    private static String FindOpositeColore(String Color)
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
    private static int PlayerTurn(String Color ,int count )
    {
        System.out.println("Playing: "+Color);
        game1.Predict(Color);
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
    }
}//end Main

