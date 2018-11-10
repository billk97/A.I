/**
 * A class describing ta move int the board
 * Every produced child corresponding to a move
 * and we need to keep the moves as well as the states**/
public class Move {

    private int row;
    private int col;
    private int value;
    /**empty constructor Move **/
    public Move()
    {
        this.row=-1;
        this.col=-1;
        this.value=-1;
    }
    /**constructor with 1 variable **/
    public Move(int Value)
    {
        this.row=-1;
        this.col=-1;
        this.value=Value;
    }
    /**constructor with 3 variable **/
    public Move (int row,int col)
    {
        this.row=row;
        this.col=col;
        this.value=-1;
    }
    /**constructor  with 3 variable**/
    public Move(int row,int col,int value )
    {
        this.row =  row;
        this.col = col;
        this.value = value;
    }
    /**returns the row*/
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    /**returns the column */
    public int getCol() {
        return col;
    }
    /**gets the column **/
    public void setCol(int col) {
        this.col = col;
    }
    /**gets the value inside **/
    public int getValue() {
        return value;
    }
    /**sets the value inside **/
    public void setValue(int value) {
        this.value = value;
    }
}
