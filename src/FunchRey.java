import java.awt.Cursor;
import java.io.IOException;

import javax.swing.JFrame;

public class FunchRey {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// Declare and initialize a JFrame
		JFrame myFrame = new JFrame();

		// Make the frame visible
		myFrame.setTitle("FunchReyGames");
		myFrame.setSize(700, 720);
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setAlwaysOnTop(true);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);

		// Create a panel
		MainPanel myPanel = new MainPanel();
		
		myPanel.setSize(700, 7250);

		// Put the panel inside the frame
		myFrame.setContentPane(myPanel);

		// Enable mouse motion listener
		myPanel.addMouseMotionListener(myPanel);
		myPanel.addMouseListener(myPanel);

		// Enable key listener
		myPanel.addKeyListener(myPanel);
		myPanel.requestFocus();
		
		// Make the panel visible 
		myPanel.setVisible(true);
		
		while (true) {
			
			// Run and paint the game, wait a bit in between
			myPanel.run();
			myPanel.repaint();
			Thread.sleep(30);
		}

	}

}
