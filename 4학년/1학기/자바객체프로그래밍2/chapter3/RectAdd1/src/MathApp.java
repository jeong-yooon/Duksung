//=========================================================
// Math class Example
//=========================================================

public class MathApp {
	
	public static void main(String[] args) {
		System.out.println(Math.PI);
		
		double v = -3.456879;
		System.out.println(Math.abs(v));
		
		System.out.println(Math.sqrt(16.0));
		
		System.out.println(Math.pow(3.0, 2.0));
		
		double angle = 89.7;
		double radianAngle = angle * Math.PI / 180.0;
		System.out.println(Math.sin(radianAngle));
		System.out.println(Math.cos(radianAngle));
	}
}