package choijungyoon;

public class Pie {

	static float piecal(float count) {
		
		float sum = 0;
		float m = 4;
		float n = 1; 
		
		while(count > 0) {
			sum += m/n;
			m *= -1.0;
			n += 2.0; 
			count--;
		}
		return sum;
	}
}
