//=======================================================================
// Graphics class Example
//=======================================================================

import java.awt.*;
import java.awt.event.*;

public class GraphicsApp extends Frame {

	public static void main(String[ ] args) {
		GraphicsApp window = new GraphicsApp();
		window.setVisible(true);
	}
	
	public GraphicsApp() {
		setSize(400, 700);
		setTitle("Graphics 응용");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) { 
			repaint();
		}
	}

	public void paint(Graphics g) {
		// 문자열
		g.setFont(new Font("Arial", Font.ITALIC, 20));
		g.drawString("Graphics", 40, 60);
		// 선
		g.setColor(Color.red);
		g.drawLine(40, 100, 120, 130);
		// 사각형
		g.setColor(Color.blue);
		g.drawRect(40, 150, 70, 50);
		g.fillRect(200, 150, 70, 50);
		// 타원
		g.setColor(Color.green);
		g.drawOval(40, 230, 70, 50);
		g.setColor(Color.pink);
		g.fillOval(200, 230, 70, 70);
		// 둥근 사각형
		g.setColor(Color.black);
		g.drawRoundRect(40, 330, 70, 50, 20, 30);
		g.fillRoundRect(200, 330, 70, 50, 20, 30);
		// 원호
		g.setColor(Color.magenta);
		g.drawArc(40, 430, 70, 70, 90, 270);
		g.setColor(Color.yellow);
		g.fillArc(210, 430, 70, 70, 90, 270);
		g.setColor(Color.black);
		g.drawArc(210, 430, 70, 70, 90, 270);
		// 폐다각형
		g.setColor(Color.red);
		int x[] = {80, 40, 80, 120};
		int y[] = {540, 590, 640, 590};
		g.drawPolygon(x, y, 4);
		for(int i = 0; i < 4; i++)
			x[i] = x[i] + 160;
		g.fillPolygon(x, y, 4);
	}
}