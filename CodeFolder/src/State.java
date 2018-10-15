
public class State {
    private int Width =9 ,Heigth =9;
    private String [][] LayoutTable = new String[Width][Heigth];
    /**prints the corent state of the game**/
    public void print() {
        System.out .print("-------------------Start-----------------------");
        for (int row=0; row<Width ; row++)
        {
            System.out.print("\n");
            for(int colum=0; colum<Width; colum++){
                System.out.print(LayoutTable[row][colum]+" ");
            }
        }
        System.out .println("\n \n -------------------Stop-----------------------");
    }//end print
    /**runs at the start of the game and initialies the game State**/
    public String[][] Initializer ()
    {
        for (int i=0; i<Width ; i++)
        {
            System.out.print("\n");
            for(int j=0; j<Heigth; j++){
                LayoutTable[i][j]="_";
            }
        }
        for (int i=0; i<Width;i++)
        {
            LayoutTable[i][0]=""+i;
        }
        for (int i=0; i<Heigth;i++)
        {
            LayoutTable[0][i]=""+i;
        }
        LayoutTable[4][4]="O";
        LayoutTable[4][5]="X";
        LayoutTable[5][4]="X";
        LayoutTable[5][5]="O";
        return LayoutTable;
    }//end Inotializer
    /**allows the user to to add an element to the the game**/
    public void addElement(int x,int y,String Color )
    {
        LayoutTable[x][y]=Color;
    }//end addElement
    /**keaps the score of the two players
     * returns a table with 2 values
     * CounterTable 0 for player 1
     * CounterTable 1 for player 2
     * **/
    public int[]  Score()
    {
        int [] CounterTable = {0,0};
        for(int i=0; i<Width; i++)
        {
            for(int j=0; j< Heigth; j++)
            {
                if (LayoutTable[i][j].equals("O"))
                {
                    CounterTable[0]++;
                }
                else if (LayoutTable[i][j].equals("X"))
                {
                    CounterTable[1]++;
                }
            }
        }
        System.out.println("Player 1: "+CounterTable[0]+" "+"Player 2: "+CounterTable[1]);
        return CounterTable;
    }//end Score
    /**this function ckecks if the given input is valid regarding the rules of
     * the game reversi **/
    public boolean isValid(int x,int y,String Color)
    {
        /** TODO how to white the rules
         * ---->ROW<----
         * to add a element in a row you need at least two other element in the same row
         * 1 of the same cole one with a different
         * the elements need to have a element with different color  either directly above or under
         * ---->COLUMN<----
         * to add a element in a column you need at least two other element in the same Column
         * 1 of the same cole one with a different
         * the elements need to have a element with different color  either directly left or right **/
        return true;
    }//end iaValid
    /**this function returns true when the x , y inserted is within
     * the border of the game WIDTH ,HEIGHT **/
    public boolean isInBorder(int x,int y)
    {
        if( x>=0 && x<=9 && y>=0 && y<=9)
            return true;
        else
            return false;

    }//end isInBorder
}