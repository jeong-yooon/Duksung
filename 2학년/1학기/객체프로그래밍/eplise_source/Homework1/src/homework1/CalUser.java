package homework1;

import java.io.*;
import java.util.Scanner;

public class CalUser {
	
	private static double oprnd1, oprnd2;
	private static char operator;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);	//��ĳ�� ������

		SimpleCal c = new SimpleCal();	//���� ������
	      
	    System.out.println("������� �Է��ϼ��� : ");
	    oprnd1 = scan.nextInt();	//�ǿ�����1
	    operator = scan.next().charAt(0);	//������
	    oprnd2 = scan.nextInt();	//�ǿ�����2
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

