//========================================================
//	Simple Rectangle Application in Java
//	20개까지 멀티 사각형 생성 및 유지
//========================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	final public int MAXRECTS = 20;
	public Rect rects[];					// rects 배열 선언
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
		rects = new Rect[MAXRECTS];			// rects 배열의 메모리 할당
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();

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
			  repaint();
			}
		}
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < rectCount; i++)
			rects[i].draw(g);
	}
}