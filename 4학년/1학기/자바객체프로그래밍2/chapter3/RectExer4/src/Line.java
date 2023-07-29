// Line class

import java.awt.Color;
import java.awt.Graphics;

public class Line {
    // �ʵ�
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    
    // ������
    Line(int sx, int sy, int ex, int ey) {
    	startX = sx;
    	startY = sy;
    	endX = ex;
    	endY = ey;
    }

    // �޼ҵ�
    void moveTo(int sx, int sy) {
    	int deltaX = endX - startX;
    	int deltaY = endY - startY;
    	startX = sx;
    	startY = sy;
    	endX = sx + deltaX;
    	endY = sy + deltaY;
    }

    void draw(Graphics g) {
    	g.setColor(Color.blue);
    	g.drawLine(startX, startY, endX, endY);
    }
}