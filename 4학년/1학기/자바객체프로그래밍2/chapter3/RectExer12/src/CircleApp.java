//========================================================
//	Simple Circle Application in Java
//	Ŭ������ �������� �ϰ� �������� 40�� ���� ������ �׸�
//	���� Ŭ������ ���� �������̸� 20������ ���� ���� �� ����
//	������ ���콺 ��ư Ŭ������ Ŭ���� ������ ��� ���������� ����
//	�ܺο��� Ŭ���ϸ� ��� �ٽ� �Ķ������� ����
//========================================================

import java.awt.*;
import java.awt.event.*;

public class CircleApp extends Frame {
	final public int MAXCIRCLES = 20;
	public Circle circles[];
	public int circleCount = 0;

	public static void main(String[ ] args) {
		CircleApp window = new CircleApp();
		window.setVisible(true);
	}

	public CircleApp() {
		setSize(600, 500);
		setTitle("Circle ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		circles = new Circle[MAXCIRCLES];
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();

			if(e.getButton() == MouseEvent.BUTTON3) {
				  int theCircle = -1;
				  // ��� �簢���� ����������
				  for(int k = 0; k < circleCount; k++) {
					  circles[k].setColor(Color.blue);
				  }
				  // Ŭ���� �簢�� ��ȣ ���ϱ�
				  for(int j = 0; j < circleCount; j++) {
					  if(circles[j].includes(p)) {
						  theCircle = j;
						  break;
					  }
				  }
				  // Ŭ���� �簢������ ����������
				  if(theCircle >= 0) {
					  for(int i = 0; i <= theCircle; i++) {
						  circles[i].setColor(Color.red);
					  }
				  }
			}
			else {
				if(circleCount < MAXCIRCLES) {
					if(circleCount == 0) {
						circles[0] = new Circle(p, 40);
						circleCount = 1;
					}
					else
						if(circles[circleCount-1].includes(p)) {
							circles[circleCount] = new Circle(p, 40);
							circleCount++;
						}
				}
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		for(int i = 0; i < circleCount; i++)
			circles[i].draw(g);
	}
}