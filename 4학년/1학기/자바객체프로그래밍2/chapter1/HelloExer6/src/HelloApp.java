//=============================================================
//	Simple Hello Application in Java
//	�Ǽ����� main�� ���ڷ� ���޹޾� ��հ��� ����
//=============================================================

public class HelloApp {

	public static void main(String[] args) {
		double sum = 0;
		
		for(int i = 0; i < args.length; i++)
			sum = sum + Double.parseDouble(args[i]);

		System.out.println("��: " + sum);
		System.out.println("���: " + sum/args.length);
	}
}