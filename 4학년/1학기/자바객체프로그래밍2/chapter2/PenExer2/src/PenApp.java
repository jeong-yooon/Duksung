//=========================================================================
//	Simple Pen Application in Java
//	선의 끝점에 몇 번째 선인지를 표시하는 문자열을 그림
//=========================================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public int oldx = 0;
	public int oldy = 0;
	public int newx = 0;
	public int newy = 0;
	public int lineCount = 0;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
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
			lineCount = lineCount + 1;
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.drawLine(oldx, oldy, newx, newy);
		String str = lineCount + "번째 선";
		g.drawString(str, newx, newy);
		oldx = newx;
		oldy = newy;
	}
}