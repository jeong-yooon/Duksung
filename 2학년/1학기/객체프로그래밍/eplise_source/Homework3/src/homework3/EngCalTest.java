package homework3;

import java.lang.Math;

public class EngCalTest implements TriFunction{	//�������̽� ��� �� ���걸��
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
