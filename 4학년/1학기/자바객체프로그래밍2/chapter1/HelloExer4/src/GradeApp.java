//=============================================================
//	Simple Grade Application in Java
//  ������ �迭�� ũ�⸦ �Է¹ް� ũ�⸸ŭ�� ������ �Է¹޾� ����� ����
//	�� ������ ��� �̻��̸� pass, ���ϸ� fail�� ���
//=============================================================

import java.util.Scanner;

public class GradeApp {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("�л� ���� �Է��ϼ���: ");
		int size = s.nextInt();
		
		int score[] = new int[size];
		
		System.out.print("�л� ������ �Է��ϼ���: ");
		int sum = 0;
		for(int i = 0; i < size; i++) {
			score[i] = s.nextInt();
			sum = sum + score[i];
		}
		s.close();
		double average = sum / size;
		System.out.println("���: " + average);
		for(int i = 0; i < size; i++) {
			if(score[i] >= average)
				System.out.println(score[i] + " pass!");
			else
				System.out.println(score[i] + " fail!");
		}
	}
}
