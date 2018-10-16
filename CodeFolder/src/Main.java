
import javafx.scene.transform.Scale;
import java.util.Scanner;
import java.util.*;
import  java.io.*;

public  class Main {

    //TODO ANAPODOGIRISMA
    //TODO
    public  static void main(String[] args)
    {
        State game1 = new State();
        boolean exit = false ;
        game1.Initializer();
        String Color= "O";
        Scanner reader = new Scanner(System.in);
        System.out.println("choose X or O: ");
        Color = reader.nextLine();
        String OppositeColor ="X";
        /** checks if given value is a desired value**/
        while(!(Color.equals("O"))&&!(Color.equals("X")))
        {
            System.out.println("choose X or O: ");
            Color = reader.nextLine();

        }
        /**creates the opposite color (the other player)**/
        if (Color.equals("O"))
        {
            OppositeColor="X";
        }
        else if(Color.equals("X"))
        {
            OppositeColor="O";
        }
        /**useful its a simple counter**/
        int count=1;

        while(exit == false)
        {
            /**scarifies which players turn it is by dividing with 2
             * if its the first players turn then count mod 2 should not be 0
             * player 1 count 1 3 5 7 9 11 13 15 17 19 21 23
             * player 2 count 2 4 6 8 10 12 14 16 18 20 22**/
            if(count %2 == 0)
            {
                /**players 2 turn **/
                System.out.println("Playing: "+OppositeColor);
                game1.Predict(OppositeColor);//predicts the next move
                game1.Score();
                game1.print();
                int x=0 , y=0;
                System.out.println("X which row ");
                System.out.print("X: ");
                /**should catch the exception  **/
                while(true)
                {
                    try
                    {
                        x = reader.nextInt();//could cause an exception if input is string
                        break;
                    }
                    catch(Exception  e)
                    {
                        /**doing samething to prevent the exception **/
                        System.out.println("Wrong Input");
                        reader.next();//waits for the next INPUT
                        System.out.println("X which row ");
                        System.out.print("X: ");
                        x = reader.nextInt();
                    }
                }
                System.out.println("Y which column  ");
                System.out.print("Y: ");
                /**should catch the exception  **/
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
                        System.out.println("Y which column  ");
                        System.out.print("Y: ");
                    }
                }
                if(x<=game1.getHeight()&&y<=game1.getWidth() && game1.isDot(x,y)== true && (OppositeColor.equals("X")||  OppositeColor.equals("O")))
                {
                    game1.DeleteDot();
                    game1.addElement(x,y,OppositeColor);
                    count ++;
                }
                else
                {
                    System.out.println("Move not valid please retry !");
                }
            }
            else
                {
                    /**players 1 turn **/
                    System.out.println("Playing: "+Color);
                    game1.Predict(Color);
                    game1.Score();
                    game1.print();
                    int x=0 , y=0;
                    System.out.println("X which row ");
                    System.out.print("X: ");
                    /**should catch the exception  **/
                    while(true)
                    {
                        try
                        {
                            x = reader.nextInt();//could cause an exception if input is string
                            break;
                        }catch(InputMismatchException   ex)
                        {
                            /**doing samething to prevent the exception **/
                            System.out.println("Wrong Input");
                            reader.next();//waits for the next INPUT
                            System.out.println("X which row ");
                            System.out.print("X: ");
                        }
                    }

                    System.out.println("Y which column  ");
                    System.out.print("Y: ");
                    /**should catch the exception  **/
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
                            System.out.println("Y which column  ");
                            System.out.print("Y: ");
                        }
                    }


                    if(x<=game1.getHeight()&&y<=game1.getWidth() && game1.isDot(x,y)== true && (Color.equals("X")||  Color.equals("O")))
                    {
                        game1.DeleteDot();
                        game1.addElement(x,y,Color);
                       // game1.FlipElements(x,y,Color);
                        count ++;
                    }
                    else
                    {
                        System.out.println("Move not valid please retry !");
                    }
                }
            System.out.println("EXIT?  ");

        }//end while
        reader.close();
    }//end main
}//end Main

