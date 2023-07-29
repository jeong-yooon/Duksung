//=============================================================
//	Simple Hello Application in Java
//	정수들을 main의 인자로 전달받아 합을 구함
//=============================================================

public class ArgsApp {

	public static void main(String[] args) {
		int sum = 0;
		
		for(int i = 0; i < args.length; i++)
			sum = sum + Integer.parseInt(args[i]);
		
		System.out.println("합: " + sum);
	}
}