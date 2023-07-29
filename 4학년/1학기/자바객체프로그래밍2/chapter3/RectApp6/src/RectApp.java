//========================================================
//	Simple Rectangle Application in Java
//	20������ ��Ƽ �簢�� ���� �� ����
//	������ ��ư Ŭ������ Ŭ�������� �簢������ �׷� �̵�
//========================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	final public int MAXRECTS = 20;
	public Rect rects[];
	public int rectCount = 0;

	public static void main(String[ ] args) {
		RectApp window = new RectApp();
		window.setVisible(true);
	}

	public RectApp() {
		setSize(600, 500);
		setTitle("Rect ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		rects = new Rect[MAXRECTS];
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			if(e.getButton() != MouseEvent.BUTTON3) {
			  if(rectCount < MAXRECTS) {
			    if(rectCount == 0) {
				  rects[0] = new Rect(x, y, x+70, y+50);
				  rectCount = 1;
			    }
			    else {
				  if(rects[rectCount-1].includes(x, y)) {
					  rects[rectCount] = new Rect(x, y, x+70, y+50);
					  rectCount++;
				  }
				}
			  }
			}
			else {	// ������ ��ư�̸�
				int firstRectX = rects[0].upperLeftX;	// ù ��° �簢���� ������ �������� ������
				int firstRectY = rects[0].upperLeftY;
				for(int i = 0; i < rectCount; i++) {
					int deltaX = rects[i].upperLeftX - firstRectX;	// ���������κ��� �� �簢����
					int deltaY = rects[i].upperLeftY - firstRectY;	// ������ ������������ �Ÿ�
					rects[i].moveTo(x+deltaX, y+deltaY);			// �� �簢���� (Ŭ����+�Ÿ�)�� �̵�
				}
			}
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < rectCount; i++)
			rects[i].draw(g);
	}
}