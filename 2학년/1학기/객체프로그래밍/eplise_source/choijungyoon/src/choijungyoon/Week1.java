package choijungyoon;
import java.util.Scanner;
public class Week1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.println("Hello, world!");
		// ����1
		System.out.println("�� �������� ");
		System.out.println("�� ���� �־� ");
		System.out.println("�ƺ��� ������ �ֱ��");
		System.out.print("�� �������� ");
		System.out.print("�� ���� �־� ");
		System.out.print("�ƺ��� ������ �ֱ��\n");
		//����2
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("�̸�: "+name);
		//����3
		Scanner sc = new Scanner(System.in);
		System.out.println("Scanner.nextLine() �׽�Ʈ!");
		String scNextLine = sc.nextLine();
		System.out.println("Scanner.next() �׽�Ʈ!");
		String scNext = sc.next();
		System.out.println("next()\t\t:"+scNext);
		System.out.println("nextLine()\t:"+scNextLine);
		*/
		//����4
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �µ��� �Է��ϼ���. : ");
		int c = sc.nextInt();
		double f = ((double)c * 9/5) + 32;
		System.out.println("ȭ��: "+f+"F");
		//����5
		final float PI = 3.14f;
		System.out.print("�������� �Է��ϼ��� : ");
		float radius = sc.nextFloat();
		System.out.println("���� ����: " + PI*radius*radius );
		sc.close();
	}

}
