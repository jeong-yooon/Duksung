//==============================================================
// 2���� �迭 Example
//==============================================================

public class ArrayApp {

	public static void main(String[] args) {
		int scoreArray[][] = {{87, 90, 78},		// ù ��° �л��� ����,����,���� ����
				              {90, 88, 80},		// �� ��° �л��� ����,����,���� ����
				              {95, 88, 85},		// �� ��° �л��� ����,����,���� ����
				              {77, 89, 93}};	// �� ��° �л��� ����,����,���� ����

		for(int i = 0; i < scoreArray.length; i++) {
			double total = 0;
			for(int j = 0; j < scoreArray[i].length; j++)
				total = total + scoreArray[i][j];
			System.out.println((i+1) + "��° �л��� ����: " + total);
			System.out.println((i+1) + "��° �л��� ���: " + total/scoreArray[i].length);
		}
	}
}