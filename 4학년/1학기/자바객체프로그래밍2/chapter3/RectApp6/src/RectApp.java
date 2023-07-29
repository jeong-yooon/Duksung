//========================================================
//	Simple Rectangle Application in Java
//	20개까지 멀티 사각형 생성 및 유지
//	오른쪽 버튼 클릭에는 클릭점으로 사각형들을 그룹 이동
//========================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	final public int MAXRECTS = 20;
	public Rect rects[];
	public int rectCount = 0;

	public static void main(String[ ] args) {
		RectApp window = new RectApp();
		window.setVisible(true);
	}

	public RectApp() {
		setSize(600, 500);
		setTitle("Rect 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		rects = new Rect[MAXRECTS];
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

			if(e.getButton() != MouseEvent.BUTTON3) {
			  if(rectCount < MAXRECTS) {
			    if(rectCount == 0) {
				  rects[0] = new Rect(x, y, x+70, y+50);
				  rectCount = 1;
			    }
			    else {
				  if(rects[rectCount-1].includes(x, y)) {
					  rects[rectCount] = new Rect(x, y, x+70, y+50);
					  rectCount++;
				  }
				}
			  }
			}
			else {	// 오른쪽 버튼이면
				int firstRectX = rects[0].upperLeftX;	// 첫 번째 사각형의 왼쪽위 꼭짓점이 기준점
				int firstRectY = rects[0].upperLeftY;
				for(int i = 0; i < rectCount; i++) {
					int deltaX = rects[i].upperLeftX - firstRectX;	// 기준점으로부터 각 사각형의
					int deltaY = rects[i].upperLeftY - firstRectY;	// 왼쪽위 꼭짓점까지의 거리
					rects[i].moveTo(x+deltaX, y+deltaY);			// 각 사각형을 (클릭점+거리)로 이동
				}
			}
			repaint();
		}
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < rectCount; i++)
			rects[i].draw(g);
	}
}