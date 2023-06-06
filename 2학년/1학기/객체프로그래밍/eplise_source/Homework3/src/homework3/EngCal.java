package homework3;
	
	import java.io.*;
	import java.util.Scanner;

	public class EngCal extends SimpleCal{	//SimpleCal 클래스 상속
		
		private static double oprnd1, oprnd2;
		private static String operator;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);

			TriFunction obj = new EngCalTest();	//인터페이스 호출
			System.out.println("1.사칙연산 / 2.삼각함수 ");
			int num = scan.nextInt();
			
		    if(num == 1) {  //사칙연산
		    	System.out.println("연산식을 입력하세요 : ");
		    
		    	oprnd1 = scan.nextInt();	//피연산자1
				operator = scan.next();		//연산자
				oprnd2 = scan.nextInt();	//피연산자2
		    }
		    if(num == 2) {	//삼각함수
		    	System.out.println("연산식을 입력하세요 : ");
		    	
		    	operator = scan.next();		//삼각함수종류
		    	oprnd2 = scan.nextInt();	//피연산자
		    }
				
				//if(oprnd1 == 0) oprnd1 = 1;
		    	
				scan.close();
		      
		    switch (operator) {
		      
		    case "+" :
		          System.out.println(oprnd1 + " + " + oprnd2 + " = " + SimpleCal.add(oprnd1, oprnd2));
		          break;
		    case "-" :
		          System.out.println(oprnd1 + " - " + oprnd2 + " = " + SimpleCal.sub(oprnd1, oprnd2));
		          break;
		    case "*" :
		          System.out.println(oprnd1 + " * " + oprnd2 + " = " + SimpleCal.mul(oprnd1, oprnd2));
		          break;
		    case "/" :
		          System.out.println(oprnd1 + " / " + oprnd2 + " = " + SimpleCal.div(oprnd1, oprnd2));
		          break;
		    case "sin" :
		          System.out.println("sin " + oprnd2 + " = " + obj.sin(oprnd2));	//sin 메소드
		          break;
		    case "cos" :
		          System.out.println("cos " + oprnd2 + " = " + obj.cos(oprnd2));	//cos 메소드
		          break;
		    case "tan" :
		          System.out.println("tan " + oprnd2 + " = " + obj.tan(oprnd2));	//tan 메소드
		          break;
		    }
		}
		
	}