//==========================================================
//	Simple Rectangle Application in Java
//	�����쿡�� �� ���� ���콺 Ŭ������ û�� �簢������ ������ �׸��� ���α׷��� �ۼ�
//	������ ��ư���� ������ �簢���� ������ �׸�
//	ù ��° Ŭ������ �簢���� ������ �������� �ǰ�
//	�� ��° Ŭ������ �����ʾƷ� �������� ��
//	�簢���� �ִ� ������ 10��
//==========================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	final public int MAXRECTS = 10;
	public Rect rects[];
	public int rectCount = 0;
	public int upperLeftX, upperLeftY, lowerRightX, lowerRightY;
	public boolean firstClick = true;

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
					if(e.getButton() == MouseEvent.BUTTON3)
						rects[rectCount].color = Color.red;
					rectCount++;
				}
				firstClick = true;
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		for(int i = 0; i < rectCount; i++)
			rects[i].draw(g);
	}
}