//========================================================
//	Simple Rectangle Application in Java
//	������ ������ 2���� ���콺 Ŭ������ ù��° �簢���� �׸���
//	�̾����� 2���� Ŭ������ �ι�° �簢���� �ױ�
//	�簢�� �� ū ���� ���������� ǥ�õǰ� ���� ���� �ʷϻ����� ǥ��
//	Rect Ŭ������ color �ʵ�� area �޼ҵ� �߰�
//========================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	public Rect firstRect = null;
	public Rect secondRect = null;
	public int firstX, firstY, secondX, secondY;
	public int thirdX, thirdY, fourthX, fourthY;
	public int clickCount = 0;

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
			
			switch(clickCount) {
				case 0: firstX = x; firstY = y; clickCount++; break;
				case 1: secondX = x; secondY = y; clickCount++;
						firstRect = new Rect(firstX, firstY, secondX, secondY);
						repaint();
						break;
				case 2: thirdX = x; thirdY = y; clickCount++; break;
				case 3: fourthX = x; fourthY = y; clickCount = 0;
						secondRect = new Rect(thirdX, thirdY, fourthX, fourthY);
						repaint();
			}
		}
	}
	
	public void paint(Graphics g) {	
		if(firstRect != null)
		      firstRect.draw(g);
		if(secondRect != null)
			  secondRect.draw(g);

		if(firstRect != null && secondRect != null) {
			if(firstRect.area() > secondRect.area()) {
				firstRect.color = Color.red;
				secondRect.color = Color.green;
			}
			else {
				firstRect.color = Color.green;
				secondRect.color = Color.red;
			}
			firstRect.draw(g);
			secondRect.draw(g);
			firstRect = null;
			secondRect = null;
		}
	}
}