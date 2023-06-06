package choijungyoon;

public class GCD {
	
	static int gcd(int x, int y) {
		
		while(true) {
			
			if (y == 0) return x;
			int r = x % y;
			x = y;
			y = r;
		}
	}
}
