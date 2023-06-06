package choijungyoon;
import java.util.Scanner;

public class Week2 {

	public static void main(String[] args) {
		
		//예제6
			int count = 0;
			int sum = 0;
			Scanner sc = new Scanner(System.in);

			while(true) {
				System.out.print("과목"+ (count+1) +" : ");
				int score = sc.nextInt();
				
				if(score<0 || score>100) {
					System.out.println("점수 입력을 종료합니다.");
					break;
				}
				else {
					count++;
					sum += score;
				}
				System.out.println("===================");
				System.out.println("평균 점수 : "+ (float)sum/count);
			}
				
		// TODO Auto-generated method stub
		/*
		//예제1
		final int NUM = 5;
		int[] ticket = new int[NUM];
		int[] winningNumber = new int[NUM];
		
		Scanner sc = new Scanner(System.in);
		// 로또번호 선택
		System.out.println("로또번호(1~45)를 입력하세요.");
		for(int i = 0; i<NUM; i++) {
			System.out.print((i+1)+"번째: ");
			ticket[i] = sc.nextInt();
		}
		//sc.close();
		// 당첨번호 추첨
		for(int i = 0; i<NUM; i++) {
			Random rnd = new Random();
			winningNumber[i] = rnd.nextInt(45)+1; //0~44의 값이 나오므로 +1
		}
		
		// 당첨 확인
		if (Arrays.equals(ticket, winningNumber)) {
			System.out.println("당첨!");
		}
		else{
			System.out.println("꽝!");
		}
		System.out.println("ticket-------------\n"+Arrays.toString(ticket)	);
		System.out.println("winningNumber------\n"+Arrays.toString(winningNumber)	);
		
		//예제2
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 입력:");
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
		String result = str+" 는(은) 팰린드롬";
		if (isPalidrome) System.out.println(result+" 입니다.");
		else			 System.out println(result+"이 아닙니다.");
		
		//예제3
		Scanner sc = new Scanner(System.in);
		System.out.print("출생년도 마지막 자리를 입력하세요.: ");
		int k = sc.nextInt();
		
		switch(k%5) {
		case 1 : System.out.println("월요일"); break;
		case 2 : System.out.println("화요일"); break;
		case 3 : System.out.println("수요일"); break;
		case 4 : System.out.println("목요일"); break;
		case 5 : System.out.println("금요일"); break;
		}
		sc.close();
		
		//예제4
		String[] magicConch= {
				"그럼.",
				"다시 한 번 물어봐.",
				"안 돼.",
				"언젠가는.",
				"그것도 안 돼.",
				"가만히 있어.",
				"둘 다 안 돼."
		};
		String quesstion = "";
		System.out.println("*대화를 마치려면 '종료'를 입력하세요.");
		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("당신: ");
			question = sc.nextLine();
			
			if(question.equals("종료")==true) {
				sc.close();
				break;
			}
			
			Random rnd = new Random();
			System.out.println("마법의 소라고둥: "+magicConch[rnd.nextInt(7)]);
		}while(true);
		*/
	}
}
