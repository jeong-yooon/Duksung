//=============================================================
//	Simple Hello Application in Java
//	�ܼ� �����
//=============================================================

import java.util.Scanner;

public class HelloApp {

	public static void main(String[] args) {
		int year = 2015;
		String name;
		Scanner s;
		
		s = new Scanner(System.in);

		System.out.print("�̸��� �Է��ϼ���: ");
		name = s.next();
		System.out.print("���� ������ �Է��ϼ���: ");
		year = s.nextInt();
		
		String hello = "Hello ";
		System.out.println(hello + name);
		System.out.println("Good Luck in " + year);
		s.close();
	}
}