import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class Ball {
	// �ʵ�
	protected Point center;
	protected int radius;
	protected Color color;
	protected double dx;
	protected double dy;
	
	// ������
	public Ball(Point p, int r) {
		center = p;
		radius = r;
		color = Color.blue;
		dx = 0.0;
		dy = 0.0;
	}
	
	// �޼ҵ�
	public void setColor(Color newColor) {
		color = newColor;
	}
	
	public void setMotion(double ndx, double ndy) {
		dx = ndx;
		dy = ndy;
	}
	
	public void move() {
		center.x += (int) dx;
		center.y += (int) dy;
	}
	
	public void moveTo(Point p) {
		center = p;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(center.x-radius, center.y-radius, 2*radius, 2*radius);
	}
}