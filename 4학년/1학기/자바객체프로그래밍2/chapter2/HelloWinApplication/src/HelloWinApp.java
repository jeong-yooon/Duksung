import java.awt.*;
import java.awt.event.*;

public class HelloWinApp extends Frame {

	public static void main(String[ ] args) {
		HelloWinApp window = new HelloWinApp();
		window.setVisible(true);
	}
	
	public HelloWinApp() {
		setSize(600, 500);
		setTitle("Hello Window Application");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) { 
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.drawString("Hello", 100, 100);
	}
}