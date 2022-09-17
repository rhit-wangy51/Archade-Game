package Main;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		setWindow();
	}
	
	
	private static void setWindow() {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(900, 700));
		
		JPanel panel = new JPanel();
		
		JLabel instructionLabel = new JLabel("");
		
		panel.add(instructionLabel);
		
		frame.add(panel, BorderLayout.NORTH);

		Component component = new Component(instructionLabel);
		frame.add(component);
		
		
		frame.addKeyListener(new PlayerKeyListener(component));
		

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
