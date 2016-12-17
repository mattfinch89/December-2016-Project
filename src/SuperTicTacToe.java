import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.JPanel;

public class SuperTicTacToe implements KeyListener, MouseMotionListener, MouseListener {

	static int play = 0;
	static int mainColumn = -1, mainRow = -1;
	static int miniColumn = -1, miniRow = -1;
	
	static Board mainBoard;
	static Player p1, p2;
	
	
	SuperTicTacToe() throws IOException {
		// TODO Auto-generated constructor stub
		
		mainBoard = new MainBoard();
		p1 = new HumanPlayer(1);
		
		if (MainPanel.gameState == 3) {
			p2 = new HumanPlayer(2);
		} else {
			p2 = new HumanPlayer(2);
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (play % 2 == 0) {
			try {
				p1.move(e.getX(), e.getY());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			try {
				p2.move(e.getX(), e.getY());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void run() {

	}

	
	
}
