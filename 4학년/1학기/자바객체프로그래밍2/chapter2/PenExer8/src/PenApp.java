//========================================================================
//	Simple Pen Application in Java
//	마우스의 두번 클릭으로 선이 생성됨
//	선은 5개까지 그려지며 이 선들은 윈도우의 크기 조정에도 유지됨
//	Point 구조체를 정의해서 사용
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
		setTitle("Pen 응용");
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