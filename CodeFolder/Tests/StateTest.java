import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {

    @Test
    public void addElement() {
    }

    @Test
    public void predictLeft() {
        State g1 = new State();
        g1.Initializer();
        g1.addElement(4,3,"O");
        g1.addElement(4,2,"O");
        g1.Predict("X");
        Assert.assertEquals(".",g1.getValue(4,1));
    }
    @Test
    public void predictRight() {
        State g1 = new State();
        g1.Initializer();
        g1.addElement(4,6,"X");
        g1.addElement(4,7,"X");
        g1.Predict("O");
        Assert.assertEquals(".",g1.getValue(4,8));
    }
    @Test
    public void predictUp() {
        State g1 = new State();
        g1.Initializer();
        g1.addElement(3,4,"O");
        g1.addElement(2,4,"O");
        g1.Predict("X");
        Assert.assertEquals(".",g1.getValue(1,4));
    }
    @Test
    public void predictDown() {
        State g1 = new State();
        g1.Initializer();
        g1.addElement(6,4,"X");
        g1.addElement(7,4,"X");
        g1.Predict("O");
        Assert.assertEquals(".",g1.getValue(8,4));
    }
    @Test
    public void predictDiagonalLeftUp() {
        State g1 = new State();
        g1.Initializer();
        g1.addElement(6,6,"X");
        g1.addElement(3,3,"O");
        g1.addElement(2,2,"O");
        g1.Predict("X");
        Assert.assertEquals(".",g1.getValue(1,1));
    }
    @Test
    public void predictDiagonalLeftUp2() {
        State g1 = new State();
        g1.Initializer();
        g1.addElement(5,6,"X");
        g1.addElement(6,7,"O");
        g1.addElement(3,4,"X");
        g1.Predict("O");
        Assert.assertEquals(".",g1.getValue(2,3));
    }
    @Test
    public void predictDiagonalRightUp() {
        State g1 = new State();
        g1.Initializer();
        g1.addElement(6,3,"O");
        g1.addElement(3,6,"X");
        g1.addElement(2,7,"X");
        g1.Predict("O");
        Assert.assertEquals(".",g1.getValue(1,8));
    }
    @Test
    public void predictDiagonalLeftDown() {
        State g1 = new State();
        g1.Initializer();
        g1.addElement(2,7,"O");
        g1.addElement(3,6,"X");
        g1.addElement(6,3,"X");
        g1.addElement(7,2,"X");
        g1.Predict("O");
        Assert.assertEquals(".",g1.getValue(8,1));
    }

    @Test
    public void flipElements() {
    }

    @Test
    public void finalResult() {
    }

    @Test
    public void getChildren() {
    }

    @Test
    public void getLastMove() {
    }

    @Test
    public void getLastColorPlayed() {
    }
}