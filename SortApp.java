package thirteen;

import java.awt.*;
import javax.swing.*;

public class SortApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\joana\\Downloads\\television.png"));
		frame.setSize(590, 554);
		frame.getContentPane().add(new SortControll());
		frame.setTitle("Sorty");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
