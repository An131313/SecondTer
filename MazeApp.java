package maze;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MazeApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Color purple = new Color(204, 153, 255);
		frame.getContentPane().setBackground(purple);
		frame.setBackground(purple);
		frame.setSize(720, 500);
		frame.add(new MazeControl());
//		frame.getContentPane().add(new MazeControl());
		frame.setTitle("Maze");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
//		JFrame frame = new JFrame();
//		frame.getContentPane().setBackground(Color.BLACK);
//		frame.setBackground(Color.WHITE);
//		frame.setSize(1024, 800);
//		MazeControl mazeControl = new MazeControl();
//		mazeControl.setBackground(Color.BLACK);
//		frame.getContentPane().add(mazeControl);
//		frame.setTitle("Maze");
//		frame.setLocationRelativeTo(null); // Center the frame
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
	}
}
