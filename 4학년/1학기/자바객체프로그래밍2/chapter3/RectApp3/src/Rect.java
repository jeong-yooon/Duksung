// Rect class

import java.awt.Color;
import java.awt.Graphics;

public class Rect {
	// 필드
	public int upperLeftX;
	public int upperLeftY;
	public int lowerRightX;
	public int lowerRightY;
	public Color color;

	// 생성자
	public Rect(int ulx, int uly, int lrx, int lry) {
		upperLeftX = ulx;
		upperLeftY = uly;
		lowerRightX = lrx;
		lowerRightY = lry;
		color = Color.blue;		// or new Color(r, g, b);
	}
	
	// 메소드
	public void moveTo(int ulx, int uly) {
		int width = lowerRightX - upperLeftX;
		int height = lowerRightY - upperLeftY;
		upperLeftX = ulx;
		upperLeftY = uly;
		lowerRightX = ulx + width;
		lowerRightY = uly + height;
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
	
	// 면적 구하는 메소드 추가
	public int area() {
		return (lowerRightX-upperLeftX) * (lowerRightY-upperLeftY);
	}
}