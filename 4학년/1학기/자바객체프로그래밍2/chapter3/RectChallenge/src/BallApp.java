//=========================================================
//	Ball Application in Java
//=========================================================

import java.awt.*;
import java.awt.event.*;

public class BallApp extends Frame {
	final public static int FrameWidth = 600;
	final public static int FrameHeight = 400;
	// 필드
	private Ball aBall;
	private int counter = 0;

	public static void main(String[ ] args) {
		BallApp window = new BallApp();
		window.setVisible(true);
	}

	// 생성자
	public BallApp() {
		setSize(FrameWidth, FrameHeight);
		setTitle("Ball 응용");
		addMouseListener(new MouseKeeper());
		aBall = new Ball(new Point(200,100), 10);
		aBall.setMotion(3.0, 6.0);
	}
	
	// 마우스 클릭 처리
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			aBall.moveTo(p);
			if(aBall.color == Color.blue)
				aBall.setColor(Color.red);
			else
				aBall.setColor(Color.blue);
			repaint();
		}
	}
	
	// 메소드
	public void paint(Graphics g) {
		aBall.draw(g);
		aBall.move();
		if((aBall.center.x < 0) || (aBall.center.x > FrameWidth))
			aBall.setMotion(-aBall.dx, aBall.dy);
		if((aBall.center.y < 0) || (aBall.center.y > FrameHeight))
			aBall.setMotion(aBall.dx, -aBall.dy);
		counter = counter + 1;
		// 10ms delay
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			return;
		}
		if(counter < 1000)
			repaint();
		else
			System.exit(0);
	}
}