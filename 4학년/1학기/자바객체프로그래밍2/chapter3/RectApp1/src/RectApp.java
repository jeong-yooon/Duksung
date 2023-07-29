//================================================================
//	Simple Rectangle Application in Java
//	getter setter 정의, 사각형의 왼쪽위 꼭짓점을 콘솔에 출력
//	Rect 클래스의 생성자 오버로딩, 마우스 왼쪽 버튼에만 동작
//  첫 사각형은 기본 생성자로 생성
//================================================================

import java.awt.*;
import java.awt.event.*;

public class RectApp extends Frame {
	public Rect theRectangle = null;

	public static void main(String[ ] args) {
		RectApp window = new RectApp();
		window.setVisible(true);
	}

	public RectApp() {
		setSize(600, 500);
		setTitle("Rect 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			
			if(e.getButton() == MouseEvent.BUTTON1) {
				if(theRectangle == null) {
					theRectangle = new Rect();
				}
				else {
					if(theRectangle.includes(x, y))
						theRectangle.moveTo(x, y);
				}
			repaint();
			}
		}
	}

	public void paint(Graphics g) {
		if(theRectangle != null) {
			theRectangle.draw(g);
			System.out.print(theRectangle.getUpperLeftX() + " ");
			System.out.println(theRectangle.getUpperLeftY());
		}
	}
}