//bill
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

    }
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
    }
    /**allows the user to to add an element to the the game**/
    public void addElement(int x,int y,String Color )
    {
        LayoutTable[x][y]=Color;
    }
    /**keaps the score of the two players
     * returns a table with 2 values
     * CounterTable 0 for player 1
     * CounterTable 1 for player 2
     * **/
    public int[]  Score()
    {
        int [] CounterTable = {0,0};
        return CounterTable;
    }


}