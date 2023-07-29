//=======================================================
//	Simple Rectangle Application in Java
//	�簢�� �� ���� ��ư�� 10�ȼ� Ŀ���� �̵�
//	�簢�� �� ������ ��ư�� ���� �簢������ �ٲ�� 10�ȼ� �۾���
//	Rect Ŭ������ color �ʵ� moveEnlarge �޼ҵ� �߰�
//=======================================================

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
					if(theRectangle.includes(x, y)) {
						//=====
						theRectangle.color = Color.blue;
						theRectangle.moveEnlarge(x, y, 10);
					}
				}
			}
			// ������ ��ư���� �簢���� ����, ���� 5�� ����
			else if(e.getButton() == MouseEvent.BUTTON3) {
				if(theRectangle != null) {
					if(theRectangle.includes(x, y)) {
						//=====
						theRectangle.color = Color.red;
						theRectangle.lowerRightX = theRectangle.lowerRightX - 10;
						theRectangle.lowerRightY = theRectangle.lowerRightY - 10;
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