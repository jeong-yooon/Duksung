//=============================================================
//	Grade Application in Java
//  5���� ����� ���� ���� �Է�, �� ������ �ְ���, ������, ����, ��� ����
//=============================================================

import java.util.Scanner;

public class GradeApp {
	final static int COUNT = 5;
	static String course;
	
	public static void main(String[] args) {
//		final int COUNT = 5;
		int koreanMax = 0;
		int koreanMin = 100;
		int mathMax = 0;
		int mathMin = 100;
		int koreanSum = 0;
		int mathSum = 0;
		int koreanScore[] = {-1, -1, -1, -1, -1};
		int mathScore[] = {-1, -1, -1, -1, -1};
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < COUNT; i++) {
			System.out.print((i+1) + "��° �л��� ���� ����: ");
			koreanScore[i] = scan.nextInt();
			System.out.print((i+1) + "��° �л��� ���� ����: ");
			mathScore[i] = scan.nextInt();
		}
		scan.close();

		for(int i = 0; i < COUNT; i++) {
			if(koreanScore[i] > koreanMax)
				koreanMax = koreanScore[i];
			if(koreanScore[i] < koreanMin)
				koreanMin = koreanScore[i];
			koreanSum = koreanSum + koreanScore[i];
		}
		
		for(int i = 0; i < COUNT; i++) {
			if(mathScore[i] > mathMax)
				mathMax = mathScore[i];
			if(mathScore[i] < mathMin)
				mathMin = mathScore[i];
			mathSum = mathSum + mathScore[i];
		}
		
		course = "����";
		printScore(course, koreanMax, koreanMin, koreanSum);
		course = "����";
		printScore(course, mathMax, mathMin, mathSum);
	}

	static void printScore(String c, int max, int min, int sum) {
		System.out.println();
		System.out.println(c + " �ְ� ����: " + max);
		System.out.println(c + " ���� ����: " + min);
		System.out.println(c + " ����: " + sum);
		System.out.println(c + " ���: " + sum/COUNT);
	}
}