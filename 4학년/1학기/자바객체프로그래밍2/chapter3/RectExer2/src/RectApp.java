//========================================================
//	Simple Rectangle Application in Java
//	�簢�� �� ���� ��ư�� �̵�, �簢�� �� ������ ��ư�� ���� ���ΰ� 5�ȼ��� Ŀ��
//	getter�� setter ���
//========================================================

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
		setTitle("Rect ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			// ���콺 ���� ��ư�̸�
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(theRectangle == null) {
					theRectangle = new Rect(x, y, x+70, y+50);
				}
				else {
					if(theRectangle.includes(x, y))
						theRectangle.moveTo(x, y);
				}
			}
			// ������ ��ư���� �簢���� ����, ���� 5�� ����
			else if(e.getButton() == MouseEvent.BUTTON3) {
				if(theRectangle != null) {
					if(theRectangle.includes(x, y)) {
						int tempX = theRectangle.getLowerRightX() + 5;
						int tempY = theRectangle.getLowerRightY() + 5;
						theRectangle.setLowerRightX(tempX);
						theRectangle.setLowerRightY(tempY);
					}
				}
			}
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		if(theRectangle != null)
			theRectangle.draw(g);
	}
}