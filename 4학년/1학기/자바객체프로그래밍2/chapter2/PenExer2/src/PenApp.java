//=========================================================================
//	Simple Pen Application in Java
//	���� ������ �� ��° �������� ǥ���ϴ� ���ڿ��� �׸�
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
		setTitle("Pen ����");
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
		String str = lineCount + "��° ��";
		g.drawString(str, newx, newy);
		oldx = newx;
		oldy = newy;
	}
}