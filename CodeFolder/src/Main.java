
import java.util.*;
import  java.io.*;

public  class Main {

    public  static void main(String[] args)
    {
        State game1 = new State();
        game1.Initializer();
        game1.print();
        game1.addElement(7,7,"O");
        game1.print();

    }

}

