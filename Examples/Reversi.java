import java.util.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reversi extends JFrame {
	// construct of a Button named StartButton
	JButton StartButton = new JButton("Start"); 
	JButton ExitButton = new JButton("Exit"); 
	Reversi(String title)
	{
		/*Nothing before the super!!*/
		super(title);  // invoke the JFrame constructor
		Dimension MyButtonSize = new Dimension(400,200);
		JPanel panel = new JPanel(new BorderLayout(8, 8));
		setLayout(new FlowLayout()); // set the layout manager
		/*changes the button size first width, height */
		StartButton.setPreferredSize(new Dimension(400,200));
		panel.add(StartButton,BorderLayout.NORTH);
		add(StartButton);  // add the button to the JFrame
		ExitButton.setPreferredSize(MyButtonSize);
		panel.add(ExitButton,BorderLayout.SOUTH);
		add(ExitButton);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		Reversi frm = new Reversi("Button Demo");
		frm.setSize( 900, 900 );     //sets the frame width and height respectively
	    frm.setVisible( true );  //sets the frame visible 

	}

}
