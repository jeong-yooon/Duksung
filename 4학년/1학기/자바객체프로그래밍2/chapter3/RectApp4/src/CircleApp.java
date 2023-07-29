//========================================================
//	Simple Circle Application in Java
//	클릭점을 원점으로 하고 반지름이 40인 빨간 원을 생성해 그림
//	이후 클릭점이 원의 내부점이면 원점을 이동
//	오른쪽 버튼 클릭에는 클릭점으로 이동과 동시에 반지름을 10만큼 키움
//========================================================

import java.awt.*;
import java.awt.event.*;

public class CircleApp extends Frame {
	public Circle theCircle = null;

	public static void main(String[ ] args) {
		CircleApp window = new CircleApp();
		window.setVisible(true);
	}

	public CircleApp() {
		setSize(600, 500);
		setTitle("Circle 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();
			if(e.getButton() == MouseEvent.BUTTON3) {
				if(theCircle != null)
					theCircle.moveEnlarge(p, 10);
			}
			else {
				if(theCircle == null) {
					theCircle = new Circle(p, 40, Color.red);
				}
				else {
					if(theCircle.includes(p))
						theCircle.moveTo(p);
				}
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		if(theCircle != null)
			theCircle.draw(g);
	}
}