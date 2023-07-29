//=====================================================================
//	Simple Pen Application in Java
//	두 번의 마우스 클릭으로 빨간 사각형을 그림
//=====================================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public boolean firstClick = true;

	public static void main(String[] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}
	
	public PenApp() {
		setSize(600, 500);
		setTitle("Pen 응용");
		addMouseListener(new MouseKeeper());
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) { 
			if(firstClick) {
				x1 = e.getX();
				y1 = e.getY();
				firstClick = false;
			}
			else {
				x2 = e.getX();
				y2 = e.getY();
				firstClick = true;
				repaint();
			}
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.drawLine(x1, y1, x2, y1);
		g.drawLine(x2, y1, x2, y2);
		g.drawLine(x2, y2, x1, y2);
		g.drawLine(x1, y2, x1, y1);
	}
}