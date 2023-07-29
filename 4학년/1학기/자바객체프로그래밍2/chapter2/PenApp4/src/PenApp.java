//======================================================================
//	Simple Pen Application in Java
//	�� ���� ���콺 Ŭ������ ���� ����
//	Point Ŭ���� �����ؼ� ���
//======================================================================

import java.awt.*;
import java.awt.event.*;

class Pt {
	int x;
	int y;
}

public class PenApp extends Frame {
	public Pt startPoint = null;
	public Pt endPoint = null;
	public boolean firstClick = true;

	public static void main(String[] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}
	
	public PenApp() {
		setSize(600, 500);
		setTitle("Pen ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		
		startPoint = new Pt();
		endPoint = new Pt();
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			if(firstClick) {
				startPoint.x = e.getX();
				startPoint.y = e.getY();
				firstClick = false;
			}
			else {
				endPoint.x = e.getX();
				endPoint.y = e.getY();
				firstClick = true;
				repaint();
			}
		}
	}

	public void paint(Graphics g) {
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
	}
}