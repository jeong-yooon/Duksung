//=============================================================
//	Simple Hello Application in Java
//	실수들을 main의 인자로 전달받아 평균값을 구함
//=============================================================

public class HelloApp {

	public static void main(String[] args) {
		double sum = 0;
		
		for(int i = 0; i < args.length; i++)
			sum = sum + Double.parseDouble(args[i]);

		System.out.println("합: " + sum);
		System.out.println("평균: " + sum/args.length);
	}
}