//==============================================================
//	Simple Rectangle Application in Java
//==============================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	public Rect theRectangle = null;

	public static void main(String[ ] args) {
		RectApp window = new RectApp();
		window.setVisible(true);
	}

	public RectApp() {
		setSize(600, 500);
		setTitle("Rect ÀÀ¿ë");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			if(theRectangle == null) {
				theRectangle = new Rect(x, y, x+70, y+50);
			}
			else {
				if(theRectangle.includes(x, y))
					theRectangle.moveTo(x, y);
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		if(theRectangle != null)
			theRectangle.draw(g);
	}
}