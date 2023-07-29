//==============================================================
//	Simple Rectangle Application in Java
//==============================================================

import java.util.Scanner;

public class RectApp {

	public static void main(String[ ] args) {
		Rect theRectangle = null;
		int x, y;
		Scanner s = new Scanner(System.in);
		System.out.print("enter a point: ");
		x = s.nextInt();
		y = s.nextInt();
		theRectangle = new Rect(x, y, x+70, y+50);
		theRectangle.print();
		while (true) {
			System.out.print("enter a point: ");
			x = s.nextInt();
			y = s.nextInt();
			if(theRectangle.includes(x, y))
				theRectangle.moveTo(x, y);
			theRectangle.print();
		}
	}
}