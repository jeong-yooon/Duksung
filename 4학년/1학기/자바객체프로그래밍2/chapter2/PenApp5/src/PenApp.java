//=========================================================================
//	Simple Pen Application in Java
//	마우스의 왼쪽 버튼 클릭점을 잇는 선이 연속적으로 5개까지 그려지며
//	이 선들은 윈도우의 크기 조정에도 유지됨
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
	public Pt [] points;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}
	
	public PenApp() {
		setSize(600, 500);
		setTitle("Pen 응용");
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