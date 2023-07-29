//=============================================================
//	GetMin Application in Java
//  �� �Է�, �Էµ� ���� �� �ּҰ� ���
//=============================================================

import java.util.Scanner;

public class GetminApp {
	
	public static void main(String[] args) {
		final int ARRAY_SIZE = 5;
		Scanner s = new Scanner(System.in);

		int n, m;
		System.out.print("�� ���� ������ �Է��ϼ��� : ");
		n = s.nextInt();
		m = s.nextInt();
		System.out.println("�ּҰ��� " + getMin(n, m) + " �Դϴ�.");

		double o, p;
		System.out.print("�� ���� �Ǽ��� �Է��ϼ��� : ");
		o = s.nextDouble();
		p = s.nextDouble();
		System.out.println("�ּҰ��� " + getMin(o, p) + " �Դϴ�.");

		String t1=null, t2=null;
		System.out.print("�� ���� ���ڿ��� �Է��ϼ��� : ");
		t1 = s.next();
		t2 = s.next();
		System.out.println("�ּҰ��� " + getMin(t1, t2) + " �Դϴ�.");

		int arr[] = {1, 1, 1, 1, 1};
		System.out.print("���� �迭�� 5�� ���� : ");
		for(int i = 0; i < ARRAY_SIZE; i++)
			arr[i] = s.nextInt();
		System.out.println("�ּҰ��� " + getMin(arr) + "�Դϴ�.");
		
		s.close();
	}
	
	static int getMin(int a, int b) {
		return a < b ? a : b;
	}

	static double getMin(double x, double y) {
		return x < y ? x : y;
	}

	static String getMin(String s1, String s2) {
		return s1.compareTo(s2) < 0 ? s1 : s2;
	}
	
	static int getMin(int[] a) {
		int min = a[0];
		for(int i = 0; i < a.length; i++)
			if(a[i] < min)
				min = a[i];
		return min;
	}
}