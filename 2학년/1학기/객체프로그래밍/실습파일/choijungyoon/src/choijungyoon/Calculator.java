package choijungyoon;

public class Calculator {
	public String name;
	public int result;
	
	public Calculator() {
	}
	public Calculator(String s) {
		name=s;
	}
	public String getName() {
		return name;
	}
	public int getSum(int x, int y) {
		result= x+y;
		return result;
	}
	public int getDiff(int x, int y) {
		result= x-y;
		return result;
	}
	public int getMulti(int x, int y) {
		result= x*y;
		return result;
	}
	public int getDiv(int x, int y) {
		result= x/y;
		return result;
	}
	public int getMod(int x, int y) {
		result = x%y;
		return result;
	}
}
