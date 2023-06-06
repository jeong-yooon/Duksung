package homework1;

import java.io.*;
import java.util.Scanner;

public class CalUser {
	
	private static double oprnd1, oprnd2;
	private static char operator;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);	//스캐너 생성자

		SimpleCal c = new SimpleCal();	//계산기 생성자
	      
	    System.out.println("연산식을 입력하세요 : ");
	    oprnd1 = scan.nextInt();	//피연산자1
	    operator = scan.next().charAt(0);	//연산자
	    oprnd2 = scan.nextInt();	//피연산자2
	    System.out.println();
	    
	    scan.close();
	      
	    switch (operator) {
	      
	    case '+' :
	          System.out.println(oprnd1 + " + " + oprnd2 + " = " + SimpleCal.add(oprnd1, oprnd2));
	          break;
	    case '-' :
	          System.out.printf(oprnd1 + " - " + oprnd2 + " = " + SimpleCal.sub(oprnd1, oprnd2));
	          break;
	    case '*' :
	          System.out.printf(oprnd1 + " * " + oprnd2 + " = " + SimpleCal.mul(oprnd1, oprnd2));
	          break;
	    case '/' :
	          System.out.printf(oprnd1 + " / " + oprnd2 + " = " + SimpleCal.div(oprnd1, oprnd2));
	          break;
	    }
	}
}

