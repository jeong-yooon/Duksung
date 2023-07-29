//========================================================================
//	Simple Pen Application in Java
//	���콺�� �ι� Ŭ������ ���� ������
//	���� 5������ �׷����� �� ������ �������� ũ�� �������� ������
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
	public Pt [] startPoints;
	public Pt [] endPoints;
	public boolean firstClick = true;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}
	
	public PenApp() {
		setSize(600, 500);
		setTitle("Pen ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		
		startPoints = new Pt[MAX_LINES];
		endPoints = new Pt[MAX_LINES];
		for(int i = 0; i < MAX_LINES; i++) {
			startPoints[i] = new Pt();
			endPoints[i] = new Pt();
		}
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) { 		
			if(lineCount < MAX_LINES) {
				if(firstClick) {
					startPoints[lineCount].x = e.getX();
					startPoints[lineCount].y = e.getY();
					firstClick = false;
				}
				else {
					endPoints[lineCount].x = e.getX();
					endPoints[lineCount].y = e.getY();
					lineCount++;
					firstClick = true;
					repaint();
				}
			}
		}
	}

	public void paint(Graphics g) {
		for(int i = 0; i < lineCount; i++)
				g.drawLine(startPoints[i].x, startPoints[i].y,
							endPoints[i].x, endPoints[i].y);
	}
}