import java.util.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.JComponent;
/*this is an example of a simple basic way to draw and modify shapes */
public class Grafics  extends JComponent  {
	public void paint(Graphics g) 
	{
		/*controls the Rectangle position x,y and width ,height*/
		g.setColor(Color.ORANGE);//needs to be before the draw
		//fills the inside of the rectangle with color
		g.fillRect(10, 10, 200, 200);
		//draws the rectangle x,y,width,height
		g.drawRect(10, 10, 200, 200);
		
	}
	public static void main(String[] args) {
		//Contractor
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*controls the panes/windows position x,y,width, height*/
		window.setBounds(10, 20, 400, 400);
		window.getContentPane().add(new Grafics());
		window.setVisible(true);
	}

}
