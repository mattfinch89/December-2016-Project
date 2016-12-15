import java.awt.Window;

import javax.swing.JFrame;

public class ConnectFourMain{
	public static void main(String[] args)
	{
		JFrame fr = new JFrame(); // similar to scanner
		
		//configures frame
		fr.setTitle("Square Up!");
		fr.setSize(700, 700);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		//makes visible
		fr.setVisible(true);
		
		Connect cf = new Connect();
		cf.setGrid(7, 6);
		
		if (cf.rounds % 1 == 0){
			
		}
		else {
			
		}
		
	}
}
