package circleHome;
import java.lang.Math;

public class CircleBean {
	private int x;
	private int y;
	private int radius;
	
	public int getXnum() {
		return x;
	}
	public void setXnum(int x) {
		this.x = x;
	}
	public int getYnum() {
		return y;
	}
	public void setYnum(int y) {
		this.y = y;
	}
	public int getRnum() {
		return radius;
	}
	public void setRnum(int radius) {
		this.radius = radius;
	}
	
	public String printCircle() {
		StringBuffer sb = new StringBuffer();
		sb.append("원점 : (" + x + "," + y + ")");
		sb.append(" 면적 :" + (radius*radius*Math.PI));
		return sb.toString();
	}
}