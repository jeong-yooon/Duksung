package choijungyoon;
import java.util.Scanner;
public class Week3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���� 2
		Student lee = new Student("Lee", "IT�̵����а�", 21, 2019);
		System.out.println(Student.numberOfStudent);
		
		Student kim = new Student("Kim", "IT�̵����а�", 21, 2019);
		System.out.println(Student.numberOfStudent);
		
		Student park = new Student("Park", "IT�̵����а�", 21, 2019);
		System.out.println(Student.numberOfStudent);
		
		//����1
		Television tv1 = new Television();
		tv1.powerOn = true;
		tv1.channel = 13;
		tv1.volume = 5;
		
		Television tv2 = new Television(false, 23, 18);
		
		Television tv3 = new Television();
		
		System.out.println("[tv1]" + tv1.status());
		System.out.println("[tv2]" + tv2.status());
		System.out.println("[tv3]" + tv3.status());
		
		Television myTv = new Television(false, 23, 18);
		System.out.println("�ν��Ͻ� myTv ����: "+ myTv.status());
		
		myTv.powerSwitch();
		System.out.println("myTv.powerSwitch(): "+ myTv.status());
		
		myTv.channelUp();
		System.out.println("myTv.channelUp(): "+ myTv.status());
		
	}

}
//����2
class Student{
	String name;
	String major;
	int age;
	int addmission;
	
	static int numberOfStudent;
	
	Student(String name, String major, int age, int addmission){
		this.name = name;
		this.major = major;
		this.age = age;
		this.addmission = addmission;
		
		numberOfStudent++;
	}
	
	Student(){
		Scanner sc = new Scanner(System.in);
		// Scanner�� ���� �Է¹޾� �ν��Ͻ� ������ �����ϱ�
		
		sc.close();
	}
	void profile() {
		System.out.println("["+name+"]");
		System.out.println("����: "+ major);
		System.out.println("����: "+ age);
		System.out.println("�й�: "+ addmission);
	}
}
//����1
class Television{
	boolean powerOn;
	int channel;
	int volume;
	
	Television(){
	System.out.println("constructor Television()");
		powerOn = true;
		channel = 1;
		volume = 20;
	}
	
	Television(boolean powerOn, int channel, int volume){
		System.out.println("constructor Television(boolean, int, int)");
		this.powerOn = powerOn;
		this.channel = channel;
		this.volume = volume;
	}
	String status() {
		if(powerOn) {
			return "Channel: "+channel+"volume: "+volume;
		}
		else {
			return "������ ���� �ֽ��ϴ�.";
		}
	}
	void setChannel (int channel) {
		this.channel = channel;
	}
	void setVolume(int volume) {
		this.volume = volume;
	}
	void channelUp() {channel += 1;}
	void channelDown() {channel -=1;}
	
	void volumeUp() {volume += 1;}
	void volumeDown() {volume -= 1;}
	
	void powerSwitch() {powerOn = !powerOn;}
}