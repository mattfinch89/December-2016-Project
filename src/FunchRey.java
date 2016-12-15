import java.awt.Cursor;
import java.io.IOException;

import javax.swing.JFrame;

public class FunchRey {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// declare and initialize a JFrame
		JFrame myFrame = new JFrame();

		// make our frame visible
		myFrame.setTitle("FunchReyGames");
		myFrame.setSize(700, 700);
		myFrame.setResizable(false);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setAlwaysOnTop(true);
		myFrame.setLocationRelativeTo(null);

		myFrame.setVisible(true);

		// create a panel
		MainPanel myPanel = new MainPanel();
		

		myPanel.setSize(700, 700);

		// put the panel inside the frame
		myFrame.setContentPane(myPanel);

		// enable mouse motion listener
		myPanel.addMouseMotionListener(myPanel);
		myPanel.addMouseListener(myPanel);

		// enable key listener

		myPanel.addKeyListener(myPanel);
		myPanel.requestFocus();
		myPanel.setVisible(true);
		
		while (true) {

			myPanel.run();
			Thread.sleep(30);
			myPanel.repaint();
		}

	}

}
