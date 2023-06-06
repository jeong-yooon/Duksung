package choijungyoon;
import java.util.Scanner;
public class Week3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//예제 2
		Student lee = new Student("Lee", "IT미디어공학과", 21, 2019);
		System.out.println(Student.numberOfStudent);
		
		Student kim = new Student("Kim", "IT미디어공학과", 21, 2019);
		System.out.println(Student.numberOfStudent);
		
		Student park = new Student("Park", "IT미디어공학과", 21, 2019);
		System.out.println(Student.numberOfStudent);
		
		//예제1
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
		System.out.println("인스턴스 myTv 생성: "+ myTv.status());
		
		myTv.powerSwitch();
		System.out.println("myTv.powerSwitch(): "+ myTv.status());
		
		myTv.channelUp();
		System.out.println("myTv.channelUp(): "+ myTv.status());
		
	}

}
//예제2
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
		// Scanner를 통해 입력받아 인스턴스 변수에 저장하기
		
		sc.close();
	}
	void profile() {
		System.out.println("["+name+"]");
		System.out.println("전공: "+ major);
		System.out.println("나이: "+ age);
		System.out.println("학번: "+ addmission);
	}
}
//예제1
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
			return "전원이 꺼져 있습니다.";
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