//=============================================================
//	Simple Calculator Application in Java
//  �ܼ� �����쿡 �� �Ǽ��� �ӷ��ϰ� + - * / �� ���°��� ��� ����� ���
//=============================================================

import java.util.Scanner;

public class CalApp {

	public static void main(String[] args) {
		double x, y;
		int op;
		Scanner s = new Scanner(System.in);
		System.out.print("�� �Ǽ��� �Է��ϼ���: ");
		x = s.nextDouble();
		y = s.nextDouble();
		System.out.println("���ϴ� ������ ��ȣ�� �����ϼ���");
		System.out.print("(1) +, (2) -, (3) *, (4) /: ");
		op = s.nextInt();
		switch(op) {
			case 1: System.out.println("���� ����� " + (x+y) + "�Դϴ�");
					break;
			case 2: System.out.println("���� ����� " + (x-y) + "�Դϴ�");
					break;
			case 3: System.out.println("���� ����� " + (x*y) + "�Դϴ�");
					break;
			case 4: System.out.println("������ ����� " + (x/y) + "�Դϴ�");
					break;
			default:
					System.err.println("�Է� ����!!");
		}
		s.close();
	}
}
