//========================================================================
//	Simple Pen Application in Java
//	������ ���콺 Ŭ������ ���� ���� �׸�
//	java.awt.Point ���
//========================================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public Point oldPoint = null;
	public Point newPoint = null;
	public boolean redPen = false;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}
	
	public PenApp() {
		setSize(600, 500);
		setTitle("Pen ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);

		oldPoint = new Point();
		newPoint = new Point();
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			newPoint = e.getPoint();

			if(e.getButton() == MouseEvent.BUTTON3)
				redPen = true;
			else
				redPen = false;
			
			repaint();
		}
	}

	public void paint(Graphics g) {
		if(redPen)
			g.setColor(Color.red);
		else
			g.setColor(Color.black);

		g.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);	
		oldPoint = newPoint;
	}
}