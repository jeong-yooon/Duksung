//===================================================
//	Simple Line Application in Java
//	2장의 Pen 응용을 Line 클래스를 정의해서 구현
//===================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public Line theLine = null;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}

	public PenApp() {
		setSize(600, 500);
		setTitle("Line 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			if(theLine == null) {
				theLine = new Line(0, 0, x, y);
			}
			else {
				int tmpX = theLine.endX;
				int tmpY = theLine.endY;
				theLine = new Line(tmpX, tmpY, x, y);
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		if(theLine != null)
			theLine.draw(g);
	}
}