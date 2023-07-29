//========================================================
//	Simple Circle Application in Java
//	Ŭ������ �������� �ϰ� �������� 40�� ���� ���� ������ �׸�
//	���� Ŭ������ ���� �������̸� ������ �̵�
//	������ ��ư Ŭ������ Ŭ�������� �̵��� ���ÿ� �������� 10��ŭ Ű��
//========================================================

import java.awt.*;
import java.awt.event.*;

public class CircleApp extends Frame {
	public Circle theCircle = null;

	public static void main(String[ ] args) {
		CircleApp window = new CircleApp();
		window.setVisible(true);
	}

	public CircleApp() {
		setSize(600, 500);
		setTitle("Circle ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			if(e.getButton() == MouseEvent.BUTTON3) {
				if(theCircle != null)
					theCircle.moveEnlarge(p, 10);
			}
			else {
				if(theCircle == null) {
					theCircle = new Circle(p, 40, Color.red);
				}
				else {
					if(theCircle.includes(p))
						theCircle.moveTo(p);
				}
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		if(theCircle != null)
			theCircle.draw(g);
	}
}