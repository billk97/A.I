
public class State {
    private int Width = 10, Height = 10;
    private String[][] LayoutTable = new String[Width][Height];
    private int score;

    /**
     * prints the corent state of the game
     **/
    public void print() {
        System.out.print("-------------------Start-----------------------");
        for (int row = 0; row < Width - 1; row++) {
            System.out.print("\n");
            for (int colum = 0; colum < Height - 1; colum++) {
                System.out.print(LayoutTable[row][colum] + " ");
            }
        }
        System.out.println("\n \n -------------------Stop-----------------------");
    }//end print

    /**
     * returns the Width
     **/
    public int getWidth() {
        return Width;
    }//end of getWidth

    /**
     * returns the height
     **/
    public int getHeight() {
        return Height;
    }

    /**
     * runs at the start of the game and initialies the game State
     **/
    public String[][] Initializer() {
        for (int i = 0; i < Width; i++) {
            System.out.print("\n");
            for (int j = 0; j < Height; j++) {
                LayoutTable[i][j] = "_";
            }
        }
        for (int i = 0; i < Width; i++) {
            LayoutTable[i][0] = "" + i;
        }
        for (int i = 0; i < Height; i++) {
            LayoutTable[0][i] = "" + i;
        }
        LayoutTable[4][4] = "O";
        LayoutTable[4][5] = "X";
        LayoutTable[5][4] = "X";
        LayoutTable[5][5] = "O";


        return LayoutTable;
    }//end Inotializer

    /**
     * allows the user to to add an element to the the game
     **/
    public void addElement(int x, int y, String Color) {
        LayoutTable[x][y] = Color;
    }//end addElement

    /**
     * keaps the score of the two players
     * returns a table with 2 values
     * CounterTable 0 for player 1
     * CounterTable 1 for player 2
     **/
    public int[] Score() {
        int[] CounterTable = {0, 0};
        for (int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                if (LayoutTable[i][j].equals("O")) {
                    CounterTable[0]++;
                } else if (LayoutTable[i][j].equals("X")) {
                    CounterTable[1]++;
                }
            }
        }
        System.out.print("Score: ");
        System.out.println("Player 1: " + CounterTable[0] + " " + "Player 2: " + CounterTable[1]);
        return CounterTable;
    }//end Score

    /**
     * this function ckecks if the given input is valid regarding the rules of
     * the game reversi
     **/
    public void Predict(String Color) {
        /**
         * ---->ROW<----
         * to add a element in a row you need at least two other element in the same row
         * 1 of the same cole one with a different
         * the elements need to have a element with different color  either directly above or under
         * ---->COLUMN<----
         * to add a element in a column you need at least two other element in the same Column
         * 1 of the same cole one with a different
         * the elements need to have a element with different color  either directly left or right **/
        String OppositeColor;
        if (Color.equals("O")) {
            OppositeColor = "X";
        } else {
            OppositeColor = "O";
        }

        int count;
        for (int i = 1; i < Width; i++) {
            for (int j = 1; j < Height; j++) {
                if (LayoutTable[i][j].equals(Color)) {
                    //  check the left
                    count = 0;
                    while (LayoutTable[i][j - 1 - count].equals(OppositeColor) && j - 1 - count > 1) {
                        if (LayoutTable[i][j - 2 - count].equals("_")) {
                            LayoutTable[i][j - 2 - count] = ".";
                        }
                        count++;
                    }
                    //check right
                    count = 0;
                    while (LayoutTable[i][j + 1 + count].equals(OppositeColor) && j + 1 + count <= 8) {
                        if (LayoutTable[i][j + 2 + count].equals("_")) {
                            LayoutTable[i][j + 2 + count] = ".";
                        }
                        count++;
                    }
                    //check up
                    count = 0;
                    while (LayoutTable[i - 1 - count][j].equals(OppositeColor) && i - 1 - count > 1) {
                        if (LayoutTable[i - 2 - count][j].equals("_")) {
                            LayoutTable[i - 2 - count][j] = ".";
                        }
                        count++;
                    }
                    //check down
                    count = 0;
                    while (LayoutTable[i + 1 + count][j].equals(OppositeColor) && i + 1 + count < 8) {
                        if (LayoutTable[i + 2 + count][j].equals("_")) {
                            LayoutTable[i + 2 + count][j] = ".";
                        }
                        count++;
                    }
                    //check diagonal up left
                    count = 0;
                    while (LayoutTable[i - 1 - count][j - 1 - count].equals(OppositeColor) && j - 1 - count > 1 && i - 1 - count > 1) {
                        if (LayoutTable[i - 2 - count][j - 2 - count].equals("_")) {
                            LayoutTable[i - 2 - count][j - 2 - count] = ".";
                        }
                        count++;
                    }
                    //check diagonal up right
                    count = 0;
                    while (LayoutTable[i - 1 - count][j + 1 + count].equals(OppositeColor) && j + 1 + count <= 8 && i - 1 - count > 1) {
                        if (LayoutTable[i - 2 - count][j + 2 + count].equals("_")) {
                            LayoutTable[i - 2 - count][j + 2 + count] = ".";
                        }
                        count++;
                    }
                    //check diagonal down left
                    count = 0;
                    while (LayoutTable[i + 1 + count][j - 1 - count].equals(OppositeColor) && j - 1 - count > 1 && i + 1 + count <= 8) {
                        if (LayoutTable[i + 2 + count][j - 2 - count].equals("_")) {
                            LayoutTable[i + 2 + count][j - 2 - count] = ".";
                        }
                        count++;
                    }
                    //check diagonal down right
                    count = 0;
                    while (LayoutTable[i + 1 + count][j + 1 + count].equals(OppositeColor) && j + 1 + count <= 8 && i + 1 + count <= 8) {
                        if (LayoutTable[i + 2 + count][j + 2 + count].equals("_")) {
                            LayoutTable[i + 2 + count][j + 2 + count] = ".";
                        }
                        count++;
                    }

                }
            }
        }

    }//end Predict

    /**
     * this function chacks if the given space in s "." or not
     **/
    public boolean isDot(int x, int y) {
        if (LayoutTable[x][y].equals(".")) {
            return true;

        } else {
            return false;
        }
    }

    /**
     * this functions deletes all the "." from the LayoutTable
     **/
    public void DeleteDot() {
        for (int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                if (LayoutTable[i][j].equals(".")) {
                    LayoutTable[i][j] = "_";
                }
            }
        }
    }

    /**
     * this function is responsible of flipping or reversing the Elements regarding reversi rules
     * Rules
     **/

    public void FlipElements(int i, int j, String Color) {
        int count;
        String OppositeColor;
        if (Color.equals("O")) {
            OppositeColor = "X";
        } else {
            OppositeColor = "O";
        }
        if (LayoutTable[i][j].equals(Color)) {
            //check left
            count = 0;
            while (LayoutTable[i][j - 1 - count].equals(OppositeColor) && j - 1 - count > 1) {

                if (LayoutTable[i][j - 2 - count].equals(Color)) {
                    for (int k = j - 1 - count; k <= j - 1; k++) {
                        LayoutTable[i][k] = Color;
                    }

                }
                count++;
            }
            //check right
            count = 0;
            while (LayoutTable[i][j + 1 + count].equals(OppositeColor) && j + 1 + count <= 8) {
                if (LayoutTable[i][j + 2 + count].equals(Color)) {
                    for (int k = j + 1 + count; k >= j + 1; k--) {
                        LayoutTable[i][k] = Color;
                    }

                }
                count++;
            }
            //check up
            count = 0;
            while (LayoutTable[i - 1 - count][j].equals(OppositeColor) && i - 1 - count > 1) {
                if (LayoutTable[i - 2 - count][j].equals(Color)) {
                    for (int k = i - 1 - count; k <= i - 1; k++) {
                        LayoutTable[k][j] = Color;

                    }

                }
                count++;
            }
            //check down
            count = 0;
            while (LayoutTable[i + 1 + count][j].equals(OppositeColor) && i + 1 + count < 8) {
                if (LayoutTable[i + 2 + count][j].equals(Color)) {
                    for (int k = i + 1 + count; k >= i + 1; k--) {
                        LayoutTable[k][j] = Color;

                    }

                }
                count++;
            }
            //check diagonal up left
            count = 0;
            while (LayoutTable[i - 1 - count][j - 1 - count].equals(OppositeColor) && j - 1 - count > 1 && i - 1 - count > 1) {
                int r = 0;
                if (LayoutTable[i - 2 - count][j - 2 - count].equals(Color)) {
                    for (int k = i - 1 - count; k <= i - 1; k++) {
                        LayoutTable[k][j - 1 - count + r] = Color;
                        r++;
                    }


                }
                count++;
            }
            //check diagonal up right
            count = 0;
            while (LayoutTable[i - 1 - count][j + 1 + count].equals(OppositeColor) && j + 1 + count <= 8 && i - 1 - count > 1) {


                if (LayoutTable[i - 2 - count][j + 2 + count].equals(Color)) {
                    int r = 0;
                    for (int k = i - 1 - count; k <= i - 1; k++) {
                        LayoutTable[k][j + 1 + count - r] = Color;
                        r++;
                    }

                }
                count++;
            }
            //check diagonal down left
            count = 0;
            while (LayoutTable[i + 1 + count][j - 1 - count].equals(OppositeColor) && j - 1 - count > 1 && i + 1 + count <= 8) {

                if (LayoutTable[i + 2 + count][j - 2 - count].equals(Color)) {
                    int r = 0;
                    for (int k = i + 1 + count; k >= i + 1; k--) {
                        LayoutTable[k][j - 1 - count + r] = Color;
                        r++;
                    }

                }
                count++;
            }
            //check diagonal down right
            count = 0;
            while (LayoutTable[i + 1 + count][j + 1 + count].equals(OppositeColor) && j + 1 + count <= 8 && i + 1 + count <= 8) {
                if (LayoutTable[i + 2 + count][j + 2 + count].equals(Color)) {
                    int r = 0;
                    for (int k = i + 1 + count; k >= i + 1; k--) {
                        LayoutTable[k][j + 1 + count - r] = Color;
                        r++;
                    }
                }
                count++;
            }
        }


    }


    /**
     * this function returns true when the x , y inserted is within
     * the border of the game WIDTH ,HEIGHT
     **/
    public boolean isInBorder(int x, int y) {
        if (x >= 1 && x <= 9 && y >= 1 && y <= 9)
            return true;
        else
            return false;

    }//end isInBorder

    public boolean isFull() {
        int counterX = 0;
        int counterO = 0;
        for (int row = 0; row < Width - 1; row++) {
            for (int colum = 0; colum < Height - 1; colum++) {
                if (LayoutTable[row][colum].equals("X")) {
                    counterX++;
                }
                if (LayoutTable[row][colum].equals("O")) {
                    counterO++;
                }
            }
        }
        if (((counterX + counterO) == 64)) {
            return true;
        }
        return false;

    }

    public int CountDot() {
        int counterDot = 0;
        for (int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                if (LayoutTable[i][j].equals(".")) {
                    counterDot++;
                }
            }
        }
        return counterDot;
    }

    public void FinalResult() {
        int counterX = 0;
        int counterO = 0;
        for (int row = 0; row < Width - 1; row++) {
            for (int colum = 0; colum < Height - 1; colum++) {
                if (LayoutTable[row][colum].equals("X")) {
                    counterX++;
                }
                if (LayoutTable[row][colum].equals("O")) {
                    counterO++;
                }
            }
        }
        if (counterX > counterO) {
            System.out.println("Game over. The winner is X with score " + counterX + ":" + counterO);

        } else if (counterX < counterO) {
            System.out.println("Game over. The winner is O with score " + counterO + ":" + counterX);

        } else if (counterX == counterO) {
            System.out.println("Game over. Its a tie with score " + counterO + ":" + counterX);

        }


    }
    // O gets the positive ++
    // X gets the negative --
    private void heuristic1()//mavra perisotera apo aspra
    {
        CalculateHeuresticScore();
    }
    //calculate who has the most elements int the game. O=+1 and for X=-1
    private void CalculateHeuresticScore(){
        for (int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                if (LayoutTable[i][j].equals("O")) {
                    score++;
                } else if (LayoutTable[i][j].equals("X")) {
                    score--;
                }
            }
        }
    }
    //gives points when you have the outline
    private  void find(int a,int b)
    {
        if(LayoutTable[a][b].equals("O"))
        {
            score=+10;
        }
        else if(LayoutTable[a][b].equals("X")){
            score=-10;
        }
    }
    private void Heuristic3()
    {
        for (int i=2; i<Width-1; i++)
        {
            find(1,i);
            find(i,1);
            find(8,i);
            find(i,8);
        }
//comment
    }

    private void heuristic2()// koitaw gonies
    {
        if (LayoutTable[1][1].equals("O")||LayoutTable[8][8].equals("O")||LayoutTable[1][8].equals("O")||LayoutTable[8][1].equals("O")) {
            score=score+100;
        } else if (LayoutTable[1][1].equals("X")||LayoutTable[8][8].equals("X")||LayoutTable[1][8].equals("X")||LayoutTable[8][1].equals("X")) {
            score=score-100;
        }
    }
}