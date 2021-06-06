package maze;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class MazeControl extends JPanel{

	private MazePanel mazePanel = new MazePanel();
	
	private JButton findPathBtn = new JButton("Find Path");
	private JButton cleanPathBtn = new JButton("Reset");
	
	public MazeControl() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		add(mazePanel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 153, 255));
		findPathBtn.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		findPathBtn.setBackground(new Color(255, 153, 153));
		buttonPanel.add(findPathBtn);
		cleanPathBtn.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		cleanPathBtn.setBackground(new Color(255, 153, 153));
		buttonPanel.add(cleanPathBtn);
		add(buttonPanel, BorderLayout.SOUTH);
	
		findPathBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			mazePanel.findPath();
			}
		});
		
		cleanPathBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			mazePanel.cleanPath();
			}
		});
	}
	
}
