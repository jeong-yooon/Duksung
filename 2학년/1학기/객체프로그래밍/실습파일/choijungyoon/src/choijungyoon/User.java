package choijungyoon;

import java.util.Scanner;
public class User {

	Scanner sc = new Scanner(System.in);
	public String name;
	public int age;
	
	public User() {
		
	}
	public User(String s) {
		name=s;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	/*
	Scanner sc = new Scanner(System.in);
	System.out.print("������ �Է��ϼ���: ");
	String str = sc.nextLine();
	System.out.print(str);
	sc.close();
	String str = sc.nextLine();
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				User jungyoon;
				jungyoon=new User("����");//���� �ν��Ͻ�
				Calculator jungyoonCal;
				jungyoonCal=new Calculator("����");
				Scanner sc = new Scanner(System.in);
				System.out.print("������ �Է��ϼ���: ");
				int x = sc.nextInt();
				String str = sc.nextLine();
				int y = sc.nextInt();
				sc.close();
				switch(str) {
				case"+":
					int jungyoonSum = jungyoonCal.getSum(x, y);
					System.out.print(jungyoonSum);
					break;
				case"-":
					int jungyoonDiff = jungyoonCal.getDiff(x, y);
					System.out.print(jungyoonDiff);
					break;
				case"*":
					int jungyoonMulti = jungyoonCal.getMulti(x, y);
					System.out.print(jungyoonMulti);
					break;
				case"/":
					int jungyoonDiv = jungyoonCal.getDiv(x, y);
					System.out.print(jungyoonDiv);
					break;
				case"%":
					int jungyoonMod = jungyoonCal.getMod(x, y);
					System.out.print(jungyoonMod);
					break;
					
				}
	}

}
