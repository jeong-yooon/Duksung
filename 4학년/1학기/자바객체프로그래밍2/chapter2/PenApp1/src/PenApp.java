//========================================================================
//	Simple Pen Application in Java
//	Ŭ������ �ܼ��� ���� �Էµ� ���ڿ� ���
//========================================================================

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class PenApp extends Frame {
	public int oldx = 0;
	public int oldy = 0;
	public int newx = 0;
	public int newy = 0;
	public String message = null;

	public static void main(String[ ] args) {
		PenApp window = new PenApp();
		window.setVisible(true);
	}
	
	public PenApp() {
		setSize(600, 500);
		setTitle("Pen ����");
		MouseKeeper mouse = new MouseKeeper();
		addMouseListener(mouse);
		
		Scanner s = new Scanner(System.in);
		System.out.print("����� �޽����� �Է��ϼ���: ");
		message = s.next();
	}

	private class MouseKeeper extends MouseAdapter {

		public void mousePressed(MouseEvent e) { 
			newx = e.getX();
			newy = e.getY();
			repaint();
		}
	}

	public void paint(Graphics g) {
		g.drawLine(oldx, oldy, newx, newy);
		g.drawString(message, newx, newy);
		oldx = newx;
		oldy = newy;
	}
}