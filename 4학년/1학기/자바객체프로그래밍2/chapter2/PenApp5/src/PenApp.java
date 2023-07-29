//=========================================================================
//	Simple Pen Application in Java
//	���콺�� ���� ��ư Ŭ������ �մ� ���� ���������� 5������ �׷�����
//	�� ������ �������� ũ�� �������� ������
//	Point ����ü�� �����ؼ� ���
//========================================================================

import java.awt.*;
import java.awt.event.*;

class Pt {
	int x;
	int y;
}

public class PenApp extends Frame {
	final public int MAX_LINES = 5;
	public int lineCount = 0;
	public Pt [] points;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}
	
	public PenApp() {
		setSize(600, 500);
		setTitle("Pen ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		
		points = new Pt[MAX_LINES];
		for(int i = 0; i < MAX_LINES; i++)
			points[i] = new Pt();
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) { 		
			if(lineCount < MAX_LINES) {
				points[lineCount].x = e.getX();
				points[lineCount].y = e.getY();
				lineCount++;
				repaint();
			}
		}
	}
	
	public void paint(Graphics g) {
		  for(int i = 0; i < lineCount; i++)
			  if(i == 0)
				g.drawLine(0, 0, points[0].x, points[0].y);
			  else
				g.drawLine(points[i-1].x, points[i-1].y,
							points[i].x, points[i].y);
	}
}