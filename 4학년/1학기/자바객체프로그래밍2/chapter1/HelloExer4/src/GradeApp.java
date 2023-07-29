//=============================================================
//	Simple Grade Application in Java
//  정수형 배열의 크기를 입력받고 크기만큼의 점수를 입력받아 평균을 구함
//	각 점수가 평균 이상이면 pass, 이하면 fail을 출력
//=============================================================

import java.util.Scanner;

public class GradeApp {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("학생 수를 입력하세요: ");
		int size = s.nextInt();
		
		int score[] = new int[size];
		
		System.out.print("학생 점수를 입력하세요: ");
		int sum = 0;
		for(int i = 0; i < size; i++) {
			score[i] = s.nextInt();
			sum = sum + score[i];
		}
		s.close();
		double average = sum / size;
		System.out.println("평균: " + average);
		for(int i = 0; i < size; i++) {
			if(score[i] >= average)
				System.out.println(score[i] + " pass!");
			else
				System.out.println(score[i] + " fail!");
		}
	}
}
