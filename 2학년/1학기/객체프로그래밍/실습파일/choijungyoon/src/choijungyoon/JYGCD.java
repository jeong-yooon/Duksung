package choijungyoon;

import java.util.Scanner;

public class JYGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int temp = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("두개의 정수를 입력하시오(큰수, 작은수) : ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x < y) {
			temp = x;
			x = y;
			y = temp;
		}
		System.out.println("최대 공약수는 " + GCD.gcd(x, y));
	}

}
