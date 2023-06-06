package choijungyoon;
import java.util.Scanner;
public class Week1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.println("Hello, world!");
		// 예제1
		System.out.println("곰 세마리가 ");
		System.out.println("한 집에 있어 ");
		System.out.println("아빠곰 엄마곰 애기곰");
		System.out.print("곰 세마리가 ");
		System.out.print("한 집에 있어 ");
		System.out.print("아빠곰 엄마곰 애기곰\n");
		//예제2
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("이름: "+name);
		//예제3
		Scanner sc = new Scanner(System.in);
		System.out.println("Scanner.nextLine() 테스트!");
		String scNextLine = sc.nextLine();
		System.out.println("Scanner.next() 테스트!");
		String scNext = sc.next();
		System.out.println("next()\t\t:"+scNext);
		System.out.println("nextLine()\t:"+scNextLine);
		*/
		//예제4
		Scanner sc = new Scanner(System.in);
		System.out.print("섭씨 온도를 입력하세요. : ");
		int c = sc.nextInt();
		double f = ((double)c * 9/5) + 32;
		System.out.println("화씨: "+f+"F");
		//예제5
		final float PI = 3.14f;
		System.out.print("반지름을 입력하세요 : ");
		float radius = sc.nextFloat();
		System.out.println("원의 면적: " + PI*radius*radius );
		sc.close();
	}

}
