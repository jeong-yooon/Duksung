//=====================================================================
//	Simple Pen Application in Java
//	멀티 윈도우
//=====================================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public static int oldx = 0;
	public static int oldy = 0;
	public static int newx = 0;
	public static int newy = 0;

	public static void main(String[ ] args) {
		PenApp window1 = new PenApp();
		PenApp window2 = new PenApp();
		window1.setVisible(true);
		window2.setVisible(true);
	}
	
	public PenApp() {
		setSize(600, 500);
		setTitle("Pen 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) { 
			newx = e.getX();
			newy = e.getY();
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.drawLine(oldx, oldy, newx, newy);
		oldx = newx;
		oldy = newy;
	}
}