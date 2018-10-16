
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
        if (Color.equals("O"))
        {
            OppositeColor="X";
        }
        else
        {
            OppositeColor="O";
        }
        int count=1;

        while(exit == false)
        {
            if(count %2 == 0)
            {
                System.out.println("Playing: "+OppositeColor);
                game1.Predict(OppositeColor);
                game1.Score();
                game1.print();
                int x=0 , y=0;

                System.out.println("X which row ");
                System.out.print("X: ");
                x = reader.nextInt();
                System.out.println("Y which column  ");
                System.out.print("Y: ");
                y = reader.nextInt();
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
                    System.out.println("Playing: "+Color);
                    game1.Predict(Color);
                    game1.Score();
                    game1.print();
                    int x=0 , y=0;

                    System.out.println("X which row ");
                    System.out.print("X: ");
                    x = reader.nextInt();
                    System.out.println("Y which column  ");
                    System.out.print("Y: ");
                    y = reader.nextInt();
                    if(x<=game1.getHeight()&&y<=game1.getWidth() && game1.isDot(x,y)== true && (Color.equals("X")||  Color.equals("O")))
                    {
                        game1.DeleteDot();
                        game1.addElement(x,y,Color);
                        count ++;
                    }
                    else
                    {
                        System.out.println("Move not valid please retry !");
                    }
                }
        }//end while
        reader.close();
    }//end main
}//end Main

