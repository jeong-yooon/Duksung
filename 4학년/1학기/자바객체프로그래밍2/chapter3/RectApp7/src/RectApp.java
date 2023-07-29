//============================================================
//	Simple Rectangle Application in Java
//	20������ ��Ƽ �簢�� ���� �� ����
//	������ ��ư Ŭ������ Ŭ�������� �簢������ �׷� �̵�
//	java.awt.Rectangle Ŭ���� ���
//============================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	final public int MAXRECTS = 20;
	public Rectangle rects[];
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
		rects = new Rectangle[MAXRECTS];
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			if(e.getButton() != MouseEvent.BUTTON3) {
			  if(rectCount < MAXRECTS) {
			    if(rectCount == 0) {
				  rects[0] = new Rectangle(x, y, 70, 50);
				  rectCount = 1;
			    }
			    else {
				  if(rects[rectCount-1].contains(x, y)) {
					  rects[rectCount] = new Rectangle(x, y, 70, 50);
					  rectCount++;
				  }
				}
			  }
			}
			else {	// ������ ��ư�̸�
				int firstRectX = rects[0].x;
				int firstRectY = rects[0].y;
				for(int i = 0; i < rectCount; i++) {
					int deltaX = rects[i].x - firstRectX;
					int deltaY = rects[i].y - firstRectY;
					rects[i].setLocation(x+deltaX, y+deltaY);
				}
			}
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		for(int i = 0; i < rectCount; i++)
			g.drawRect(rects[i].x, rects[i].y,
						rects[i].width, rects[i].height);
	}
}