// Circle class

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle {
	// 필드
	private Point center;
	private int radius;
	private Color color;

	// 생성자
	public Circle() {
		center = new Point(100, 100);
		radius = 40;
		color = Color.blue;
	}
	public Circle(Point p) {
		center = p;
		radius = 40;
		color = Color.blue;
	}
	public Circle(Point p, int r) {
		center = p;
		radius = r;
		color = Color.blue;
	}
	public Circle(Point p, int r, Color c) {
		this(p, r);
		color = c;
	}
	
	// 접근 메소드와 변경 메소드
	public Point getCenter() {
		return center;
	}
	public int getRadius() {
		return radius;
	}
	public void setColor(Color newColor) {
		color = newColor;
	}
	public void setRadius(int r) {
		radius = r;
	}
	
	public void moveTo(Point p) {
		center = p;
	}
	
	public void moveEnlarge(Point p, int delta) {
		this.moveTo(p);
		radius = radius + delta;
	}
	
	public boolean includes(Point p) {
		int dist = (int) Math.sqrt(Math.pow((double)(p.x-center.x), 2.0) +
				Math.pow((double)(p.y-center.y), 2.0));
		if(dist <= radius)
			return true;
		return false;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawOval(center.x-radius, center.y-radius, 2*radius, 2*radius);
	}
}