//===========================================================
//	Simple Rectangle Application in Java
//	��Ƽ �簢�� ����
//	������ �簢���� ������ ��ư����  Ŭ���ϸ� �ʷ� �簢������ ����
//===========================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	final public int MAXRECTS = 10;
	public Rect rects[];
	public int rectCount = 0;
	public int upperLeftX, upperLeftY, lowerRightX, lowerRightY;
	public boolean firstClick=true;

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
			// ������ ��ư�� �ƴϸ�
			if(e.getButton() != MouseEvent.BUTTON3) {
				if(firstClick) {
					upperLeftX = e.getX();
					upperLeftY = e.getY();
					firstClick = false;
				}
				else {
					lowerRightX = e.getX();
					lowerRightY = e.getY();
					if(rectCount < MAXRECTS) {
						rects[rectCount] = new Rect(upperLeftX, upperLeftY, lowerRightX, lowerRightY);
						rectCount++;
					}
					firstClick = true;
				}
			}
			// ������ ��ư�̸�
			else {
				for(int i = 0; i < rectCount; i++) {
					int tempX = e.getX();
					int tempY = e.getY();
					if(rects[i].includes(tempX, tempY)) {
						rects[i].color = Color.green;
						break;
					}
				}
			}
			repaint();
		}
	}
		
	public void paint(Graphics g) {
		for(int i=0; i<rectCount; i++)
			rects[i].draw(g);
	}
}