package homework3;
	
	import java.io.*;
	import java.util.Scanner;

	public class EngCal extends SimpleCal{	//SimpleCal Ŭ���� ���
		
		private static double oprnd1, oprnd2;
		private static String operator;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);

			TriFunction obj = new EngCalTest();	//�������̽� ȣ��
			System.out.println("1.��Ģ���� / 2.�ﰢ�Լ� ");
			int num = scan.nextInt();
			
		    if(num == 1) {  //��Ģ����
		    	System.out.println("������� �Է��ϼ��� : ");
		    
		    	oprnd1 = scan.nextInt();	//�ǿ�����1
				operator = scan.next();		//������
				oprnd2 = scan.nextInt();	//�ǿ�����2
		    }
		    if(num == 2) {	//�ﰢ�Լ�
		    	System.out.println("������� �Է��ϼ��� : ");
		    	
		    	operator = scan.next();		//�ﰢ�Լ�����
		    	oprnd2 = scan.nextInt();	//�ǿ�����
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
		          System.out.println("sin " + oprnd2 + " = " + obj.sin(oprnd2));	//sin �޼ҵ�
		          break;
		    case "cos" :
		          System.out.println("cos " + oprnd2 + " = " + obj.cos(oprnd2));	//cos �޼ҵ�
		          break;
		    case "tan" :
		          System.out.println("tan " + oprnd2 + " = " + obj.tan(oprnd2));	//tan �޼ҵ�
		          break;
		    }
		}
		
	}