//==========================================================
//	Simple Rectangle Application in Java
//	윈도우에서 두 번의 마우스 클릭으로 청색 사각형들을 생성해 그리는 프로그램을 작성
//	오른쪽 버튼에는 빨간색 사각형을 생성해 그림
//	첫 번째 클릭점은 사각형의 왼쪽위 꼭짓점이 되고
//	두 번째 클릭점은 오른쪽아래 꼭짓점이 됨
//	사각형의 최대 갯수는 10개
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
		setTitle("Rect 응용");
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