// Rect class

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rect {
	// �ʵ�
	public int upperLeftX;
	public int upperLeftY;
	public int lowerRightX;
	public int lowerRightY;
	public Color color;

	// ������
	public Rect(int ulx, int uly, int lrx, int lry) {
		upperLeftX = ulx;
		upperLeftY = uly;
		lowerRightX = lrx;
		lowerRightY = lry;
		color = Color.blue;			// or new Color(r,g,b);
	}
	
	// �޼ҵ�
	public void moveTo(int ulx, int uly) {
		int width = lowerRightX - upperLeftX;
		int height = lowerRightY - upperLeftY;
		upperLeftX = ulx;
		upperLeftY = uly;
		lowerRightX = ulx + width;
		lowerRightY = uly + height;
	}
	
	public void moveEnlarge(int ulx, int uly, int delta) {
		this.moveTo(ulx, uly);
		lowerRightX = lowerRightX + delta;
		lowerRightY = lowerRightY + delta;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		int width = lowerRightX - upperLeftX;
		int height = lowerRightY - upperLeftY;
		g.drawRect(upperLeftX, upperLeftY, width, height);
	}
	
	public boolean includes(int x, int y) {
		if((upperLeftX<x) && (lowerRightX>x))
			if((upperLeftY<y) && (lowerRightY>y))
				return true;
		return false;
	}
}