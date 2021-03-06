package GUI;

import java.awt.Container;

import javax.swing.JFrame;

import Database.DatabaseClasses;
import GUI.Login;

/**
 * 
 * @author Shun Wen Chook
 *
 */

@SuppressWarnings("serial")
public class mainFrame extends JFrame {

	public mainFrame() {
		super("Ice Cream Machine");

		Container c = getContentPane();
		c.add(new Login(c));
		setSize(700, 700);
		setVisible(true);
	}

	public static void main(String[] args) {
		DatabaseClasses.init(); // starts up a Database connection

		new mainFrame();
	}

}
