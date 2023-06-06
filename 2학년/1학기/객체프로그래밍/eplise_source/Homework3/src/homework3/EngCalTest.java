package homework3;

import java.lang.Math;

public class EngCalTest implements TriFunction{	//인터페이스 상속 및 연산구현
	@Override
	public double sin(double degree) {
		return Math.sin(degree);
	}
	@Override
	public double cos(double degree) {
		return Math.cos(degree);
	}
	@Override
	public double tan(double degree) {
		return Math.tan(degree);
	}
	
}
