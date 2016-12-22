import java.awt.Window;
import java.io.IOException;

import javax.swing.JFrame;

public class ConnectFourMain{
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		JFrame fr = new JFrame(); // similar to scanner
		
		//configures frame
		fr.setTitle("Connect 4");
		fr.setSize(700, 722);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		//makes visible
		fr.setVisible(true);
		
		Connect cf = new Connect();
		cf.setSize(700, 800);
		
		cf.setVisible(true);
		fr.setContentPane(cf);
		// put the panel inside the frame

		// enable mouse motion listener
		cf.addMouseMotionListener(cf);
		// enable key listener
//
		cf.addKeyListener(cf);
		cf.addMouseListener(cf);
		cf.requestFocus();
		cf.setVisible(true);
		
		while(true)
		{
			cf.run();
			cf.repaint();
			Thread.sleep(16);
		}
		
	}
}
