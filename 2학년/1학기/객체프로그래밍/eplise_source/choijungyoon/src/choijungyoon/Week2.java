package choijungyoon;
import java.util.Scanner;

public class Week2 {

	public static void main(String[] args) {
		
		//����6
			int count = 0;
			int sum = 0;
			Scanner sc = new Scanner(System.in);

			while(true) {
				System.out.print("����"+ (count+1) +" : ");
				int score = sc.nextInt();
				
				if(score<0 || score>100) {
					System.out.println("���� �Է��� �����մϴ�.");
					break;
				}
				else {
					count++;
					sum += score;
				}
				System.out.println("===================");
				System.out.println("��� ���� : "+ (float)sum/count);
			}
				
		// TODO Auto-generated method stub
		/*
		//����1
		final int NUM = 5;
		int[] ticket = new int[NUM];
		int[] winningNumber = new int[NUM];
		
		Scanner sc = new Scanner(System.in);
		// �ζǹ�ȣ ����
		System.out.println("�ζǹ�ȣ(1~45)�� �Է��ϼ���.");
		for(int i = 0; i<NUM; i++) {
			System.out.print((i+1)+"��°: ");
			ticket[i] = sc.nextInt();
		}
		//sc.close();
		// ��÷��ȣ ��÷
		for(int i = 0; i<NUM; i++) {
			Random rnd = new Random();
			winningNumber[i] = rnd.nextInt(45)+1; //0~44�� ���� �����Ƿ� +1
		}
		
		// ��÷ Ȯ��
		if (Arrays.equals(ticket, winningNumber)) {
			System.out.println("��÷!");
		}
		else{
			System.out.println("��!");
		}
		System.out.println("ticket-------------\n"+Arrays.toString(ticket)	);
		System.out.println("winningNumber------\n"+Arrays.toString(winningNumber)	);
		
		//����2
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���ڿ� �Է�:");
		String str = sc.nextLine();
		str = str.replaceAll(" ", "");
		
		int left = 0;
		int right = str.length()-1;
		
		boolean isPalindrome = true;
		
		while(isPalindrome) {
			
			if(left>=right) break;
			
			char L = str.charAt(left);
			char R = str.charAt(right);
			
			if(L==R) {
				left++;
				right--;
				continue;
			}
			else isPalindrome = false;
		}
		String result = str+" ��(��) �Ӹ����";
		if (isPalidrome) System.out.println(result+" �Դϴ�.");
		else			 System.out println(result+"�� �ƴմϴ�.");
		
		//����3
		Scanner sc = new Scanner(System.in);
		System.out.print("����⵵ ������ �ڸ��� �Է��ϼ���.: ");
		int k = sc.nextInt();
		
		switch(k%5) {
		case 1 : System.out.println("������"); break;
		case 2 : System.out.println("ȭ����"); break;
		case 3 : System.out.println("������"); break;
		case 4 : System.out.println("�����"); break;
		case 5 : System.out.println("�ݿ���"); break;
		}
		sc.close();
		
		//����4
		String[] magicConch= {
				"�׷�.",
				"�ٽ� �� �� �����.",
				"�� ��.",
				"��������.",
				"�װ͵� �� ��.",
				"������ �־�.",
				"�� �� �� ��."
		};
		String quesstion = "";
		System.out.println("*��ȭ�� ��ġ���� '����'�� �Է��ϼ���.");
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("���: ");
			question = sc.nextLine();
			
			if(question.equals("����")==true) {
				sc.close();
				break;
			}
			
			Random rnd = new Random();
			System.out.println("������ �Ҷ���: "+magicConch[rnd.nextInt(7)]);
		}while(true);
		*/
	}
}
