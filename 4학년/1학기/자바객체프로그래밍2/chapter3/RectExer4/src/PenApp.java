//==========================================================
//	Simple Line Application in Java
//	�ι��� Ŭ������ ���� ����, ù��° Ŭ������ ���� �������̰� �ι�° Ŭ������ ���� ����
//==========================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public Line theLine = null;
	public int startX, startY;
	public int endX, endY;
	public boolean firstClick = true;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}

	public PenApp() {
		setSize(600, 500);
		setTitle("Line ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			if(firstClick) {
				startX = x;
				startY = y;
				firstClick = false;
			}
			else {
				endX = x;
				endY = y;
				theLine = null;
				theLine = new Line(startX, startY, endX, endY);
				firstClick = true;
				repaint();
			}
		}
	}

	public void paint(Graphics g) {
		if(theLine != null)
			theLine.draw(g);
	}
}