//=========================================================================
//	Simple Pen Application in Java
//	������ ���콺 Ŭ������ ���� ���� ����
//	�̾����� ���� ��ư Ŭ������ ���� ���� ���������� Ŭ�������� ���� �׸�
//	java.awt.Point ���
//=========================================================================

import java.awt.*;
import java.awt.event.*;

public class PenApp extends Frame {
	public Point oldPoint = null;
	public Point newPoint = null;

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
			// PenExer4
			if(e.getButton() != MouseEvent.BUTTON3) {
				oldPoint = newPoint;
				newPoint = e.getPoint();
			}
			else {
				newPoint = oldPoint;
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
	}
}