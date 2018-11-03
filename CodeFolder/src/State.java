import java.util.ArrayList;

public class State {
    private int Width = 10, Height = 10;
    private String[][] LayoutTable;
    private int score;
    private Move LastMove;
    private  String LastColorPlayed;

    /**
     * prints the current state of the game
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
    }//end Initializer

    /**
     * allows the user to to add an element to the the game
     **/
    public void addElement(int x, int y, String Color) {
        LastMove = new Move(x,y);
        LayoutTable[x][y] = Color;
        LastColorPlayed=Color;
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
        /**two for to cross/check the hole table **/
        for (int i = 1; i < Width; i++) {
            for (int j = 1; j < Height; j++) {
                //every time it finds the color its given
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
                    }//end while
                }//end if
            }//end for(j)
        }//end for(i)

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
     * this function is responsible of flipping or reversing the Elements regarding
     * reversi rules Rules same concept with the Predict
     **/

    public void FlipElements(int i, int j, String Color) {
        int count;
        String OppositeColor; //local variable for opposite color
        if (Color.equals("O")) {
            OppositeColor = "X";
        } else {
            OppositeColor = "O";
        }
        //every time it finds the color its given
        if (LayoutTable[i][j].equals(Color)) {
            //check left
            count = 0;
            while (LayoutTable[i][j - 1 - count].equals(OppositeColor) && j - 1 - count > 1) {
                //if it finds a same Color it stops
                if (LayoutTable[i][j - 2 - count].equals(Color)) {
                    //changer every color between Color and Color
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
            }//end while
        }//enf if
    }// end FlipElements


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

    /**
     * this function checks if the table is Full and all rows
     * and columns are occupied
     **/
    public boolean isFull() {
        int counterX = 0;
        int counterO = 0;
        //checks the hole table
        for (int row = 0; row < Width - 1; row++) {
            for (int colum = 0; colum < Height - 1; colum++) {
                if (LayoutTable[row][colum].equals("X")) {
                    //increases every time it finds X
                    counterX++;
                }
                if (LayoutTable[row][colum].equals("O")) {
                    //increases every time it finds O
                    counterO++;
                }
            }
        }
        //check to see if the sum is = 64 = 8*8
        if (((counterX + counterO) == 64)) {
            return true;
        }
        return false;
    }//end isFull

    /**
     * this function counts every dot(.)(next Move) in the table
     **/
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
    }// end CountDot

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
    }//end FinalResult

    // O gets the positive ++
    // X gets the negative --

    /****/
    private void heuristic1()//mavra perisotera apo aspra
    {
        CalculateHeuresticScore();
    }

    /**
     * calculate who has the most elements int the game. O=+1 and for X=-1
     * if the result is positive it means that O is wining
     * if negative X IS wining
     **/
    private void CalculateHeuresticScore() {
        for (int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                if (LayoutTable[i][j].equals("O")) {
                    score++;
                } else if (LayoutTable[i][j].equals("X")) {
                    score--;
                }
            }
        }
    }//endCalculateHeuristicScore

    //gives points when you have the outline
    private void find(int a, int b) {
        if (LayoutTable[a][b].equals("O")) {
            score += 10;
        } else if (LayoutTable[a][b].equals("X")) {
            score -= 10;
        }
    }//end find

    //gives points when you have the outline
    private void heuristic3() {
        for (int i = 2; i < Width - 1; i++) {
            find(1, i);
            find(i, 1);
            find(8, i);
            find(i, 8);
        }
    }// end Heuristic3

    /**
     * in reverci the corners are the most important to win sow
     * if X or Y is plays a move in a corner
     * the score goose up by a lot
     **/
    private void heuristic2() {
        if (LayoutTable[1][1].equals("O") || LayoutTable[8][8].equals("O") || LayoutTable[1][8].equals("O") || LayoutTable[8][1].equals("O")) {
            score = score + 100;
        } else if (LayoutTable[1][1].equals("X") || LayoutTable[8][8].equals("X") || LayoutTable[1][8].equals("X") || LayoutTable[8][1].equals("X")) {
            score = score - 100;
        }
    }//end heuristic2

    /**
     * in reverci the corners are the most important to win sow
     * the positions that unlock the corners are the wurst moves that someone can play
     **/
    //finds the vulnerable positions
    private void findVulnPositions(int a, int b) {
        if (LayoutTable[a][b].equals("O")) {
            score -= 25;
        } else if (LayoutTable[a][b].equals("X")) {
            score += 25;
        }
    }//end findVulnPositions

    //heuristic about the vulnerable positions
    private void heuristic4() {

        findVulnPositions(1, 2);
        findVulnPositions(2, 1);
        findVulnPositions(2, 2);
        findVulnPositions(1, 7);
        findVulnPositions(2, 7);
        findVulnPositions(2, 8);
        findVulnPositions(7, 1);
        findVulnPositions(7, 2);
        findVulnPositions(8, 2);
        findVulnPositions(7, 7);
        findVulnPositions(8, 7);
        findVulnPositions(7, 8);
    }//end heuristic4

    //ftiaxnei ta paidia kai ta emfanizei
    public ArrayList<State> getChildren(String Color) {
        ArrayList<State> children = new ArrayList<State>();
        for (int row = 0; row < Width-1; row++) {
            for (int col = 0; col < Height-1; col++) {
                if (LayoutTable[row][col].equals(".")) {
                    State child = new State(this); //ftiaxnw kainoyrgio state
                    child.DeleteDot();              // afth einai h diadikasia
                    child.addElement(row, col, Color);  // otan vazw kanoyrgio pioni
                    child.FlipElements(row, col, Color); //sto paixnidi. etsi paragw epomenes kinhseis
                    children.add(child);         //prosthetw sthn array list ta paidia
                }
            }
        }
       /* for (int k = 0; k < children.size(); k++) {
            children.get(k).evaluate();
            children.get(k).print();               //emfanizw ta paidia
        }*/
        return children;
    }

    //copy constractor to xrhsimopoiw sth getChildren gia na parago tis pithanes kinhseis
    public State(State state) {
        LastMove = state.LastMove;
        LastColorPlayed=state.LastColorPlayed;
        score=0;
        LayoutTable = new String[Width][Height];
        for (int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                LayoutTable[i][j] = state.LayoutTable[i][j];
            }
        }
    }

    // o kenos constractoras o opoios arxikopoiei to pinaka mas
    public State() {
        LastColorPlayed="O";
        LayoutTable = new String[Width][Height];
        LastMove = new Move();
    }
    public  Move getLastMove()
    {
        return LastMove;
    }

    public int evaluate(){
        heuristic1();
        heuristic2();
        heuristic3();
        heuristic4();
        System.out.println("to score sthn evaluate einai: "+score);
        return score;
    }

    public String getLastColorPlayed()
    {
        return  LastColorPlayed;
    }


}