package homework2;

import java.io.*;
import java.util.Scanner;

public class CalUser {
	
	private static double oprnd1, oprnd2;
	private static char operator;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		AddMulti a = new AddMulti();
		SubDiv b = new SubDiv();
	      
	    System.out.println("연산식을 입력하세요 : ");
	    oprnd1 = scan.nextInt();
	    operator = scan.next().charAt(0);
	    oprnd2 = scan.nextInt();
	    System.out.println();
	    
	    scan.close();
	      
	    switch (operator) {
	      
	    case '+' :
	          System.out.println(oprnd1 + " + " + oprnd2 + " = " + AddMulti.add(oprnd1, oprnd2));
	          break;
	    case '-' :
	          System.out.printf(oprnd1 + " - " + oprnd2 + " = " + SubDiv.sub(oprnd1, oprnd2));
	          break;
	    case '*' :
	          System.out.printf(oprnd1 + " * " + oprnd2 + " = " + AddMulti.mul(oprnd1, oprnd2));
	          break;
	    case '/' :
	          System.out.printf(oprnd1 + " / " + oprnd2 + " = " + SubDiv.div(oprnd1, oprnd2));
	          break;
	    }

	}
}
