package choijungyoon;

import java.util.Scanner;

public class JYGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int temp = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("�ΰ��� ������ �Է��Ͻÿ�(ū��, ������) : ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x < y) {
			temp = x;
			x = y;
			y = temp;
		}
		System.out.println("�ִ� ������� " + GCD.gcd(x, y));
	}

}
