package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	boolean displayPath = false;
	Maze m;
	int margin = 5;
	
	public MazePanel() {
		try { //
			m = new Maze("mazes.txt");//exists only in try
			
			for( int i = 0; i < m.maze.length; i++) {
				for (int j = 0; j < m.maze[i].length; j++) {
					System.out.print(m.maze[i][j]);
				}
				System.out.println();
			}
			
			if (MazeSolver.solveMaze(m)) {
				System.out.println("You won!");
			} else {
				System.out.println("No path");
			}
			
			for( int i = 0; i < m.maze.length; i++) {
				for (int j = 0; j < m.maze[i].length; j++) {
					System.out.print(m.maze[i][j]);
				}
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {//default exception
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void findPath() {
		displayPath = true;
		repaint();
	}
	
	public void cleanPath() {
		displayPath = false;
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth() / m.maze[0].length - margin;
		int height = getHeight() / m.maze.length - margin;
		
		int width2 = getWidth();
		int height2 = getHeight();
		
		
		Color pinkish = new Color(255, 204, 204);
		Color darkerPinkish = new Color(255, 153, 153);
		Color purple = new Color(204, 153, 255);
		Color purple2 = new Color(102, 0, 102);
		Color greenish = new Color(178, 255, 102);
		
		
		g.setColor(purple);
		g.fillRect( 0, 0, width2, height2);
		
		for( int i = 0; i < m.maze.length; i++) {//redove/kude w kolonit
			for (int j = 0; j < m.maze[i].length; j++) {//kolona
				if(m.maze[i][j] == 1 || m.maze[i][j] == 3) {
					g.setColor(Color.WHITE);
					g.fillRect(margin + j * (width + margin), margin + i * (height + margin), width, height);
				//System.out.print(m.maze[i][j]);
				} else if(m.maze[i][j] == 2) {
					g.setColor(darkerPinkish);
					g.fillRect(margin + j * (width + margin), margin + i * (height + margin), width, height);
				} else if(m.maze[i][j] == 0) { 
					g.setColor(purple2);
					g.fillRect(margin + j * (width + margin), margin + i * (height + margin), width, height);
				}
			}
			//System.out.println();
		}
		
		if (displayPath) {
		g.setColor(pinkish);
		for(Position p : m.path) {
			g.fillRect(margin + p.x * (width + margin), margin + p.y * (height + margin), width, height);
		}
	}
		
		
	}
}
