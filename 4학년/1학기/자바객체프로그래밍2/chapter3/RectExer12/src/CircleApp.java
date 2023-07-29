//========================================================
//	Simple Circle Application in Java
//	클릭점을 원점으로 하고 반지름이 40인 원들 생성해 그림
//	이후 클릭점이 원의 내부점이면 20개까지 원들 생성 및 유지
//	오른쪽 마우스 버튼 클릭에는 클릭된 원까지 모두 빨간색으로 변경
//	외부에서 클릭하면 모두 다시 파란색으로 변함
//========================================================

import java.awt.*;
import java.awt.event.*;

public class CircleApp extends Frame {
	final public int MAXCIRCLES = 20;
	public Circle circles[];
	public int circleCount = 0;

	public static void main(String[ ] args) {
		CircleApp window = new CircleApp();
		window.setVisible(true);
	}

	public CircleApp() {
		setSize(600, 500);
		setTitle("Circle 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		circles = new Circle[MAXCIRCLES];
	}
	
	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			Point p = e.getPoint();

			if(e.getButton() == MouseEvent.BUTTON3) {
				  int theCircle = -1;
				  // 모든 사각형을 검은색으로
				  for(int k = 0; k < circleCount; k++) {
					  circles[k].setColor(Color.blue);
				  }
				  // 클릭된 사각형 번호 구하기
				  for(int j = 0; j < circleCount; j++) {
					  if(circles[j].includes(p)) {
						  theCircle = j;
						  break;
					  }
				  }
				  // 클릭된 사각형까지 빨간색으로
				  if(theCircle >= 0) {
					  for(int i = 0; i <= theCircle; i++) {
						  circles[i].setColor(Color.red);
					  }
				  }
			}
			else {
				if(circleCount < MAXCIRCLES) {
					if(circleCount == 0) {
						circles[0] = new Circle(p, 40);
						circleCount = 1;
					}
					else
						if(circles[circleCount-1].includes(p)) {
							circles[circleCount] = new Circle(p, 40);
							circleCount++;
						}
				}
			}
			repaint();
		}
	}

	public void paint(Graphics g) {
		for(int i = 0; i < circleCount; i++)
			circles[i].draw(g);
	}
}