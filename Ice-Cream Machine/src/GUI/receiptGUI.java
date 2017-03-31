package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;

public class receiptGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					receiptGUI window = new receiptGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public receiptGUI() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 102));
		
		JPanel topPanel = new JPanel();
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel bannerPanel = new JPanel();
		bannerPanel.setBackground(new Color(0, 51, 255));
		topPanel.add(bannerPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Thanks for your support");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		bannerPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		topPanel.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Ice-Cream :");
		panel.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setColumns(3);
		panel.add(textArea);
		
		JPanel panel_2 = new JPanel();
		topPanel.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("Toppings :");
		panel_2.add(lblNewLabel_3);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setColumns(3);
		panel_2.add(textArea_2);
		
		JPanel midPanel = new JPanel();
		frame.getContentPane().add(midPanel, BorderLayout.CENTER);
		midPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		midPanel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Cone :");
		panel_1.add(lblNewLabel_2);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setColumns(3);
		panel_1.add(textArea_1);
		
		JPanel panel_3 = new JPanel();
		midPanel.add(panel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("Total :");
		panel_3.add(lblNewLabel_4);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setColumns(3);
		textArea_3.setEditable(false);
		panel_3.add(textArea_3);
		
		JLabel lblNewLabel_5 = new JLabel("Change :");
		panel_3.add(lblNewLabel_5);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setColumns(3);
		textArea_4.setEditable(false);
		panel_3.add(textArea_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 51, 255));
		midPanel.add(panel_4, BorderLayout.SOUTH);
		
		JLabel lblmay = new JLabel("16-May-2017");
		lblmay.setForeground(new Color(255, 255, 255));
		panel_4.add(lblmay);
		
		
	}

}
