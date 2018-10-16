
import java.util.*;
import  java.io.*;

public  class Main {

    //TODO ANAPODOGIRISMA
    //TODO
    public  static void main(String[] args)
    {
        State game1 = new State();
        game1.Initializer();
        game1.print();
        game1.addElement(7,7,"O");
        game1.print();
        game1.Score();
        game1.addElement(5,3,"X");
        game1.print();
        game1.addElement(5,2,"X");
        game1.print();
        game1.addElement(4,3,"X");
        game1.print();
        game1.addElement(5,6,"X");
        game1.print();
        game1.addElement(5,5,"X");
        game1.print();


        game1.Predict("O");
        game1.print();

    }

}

