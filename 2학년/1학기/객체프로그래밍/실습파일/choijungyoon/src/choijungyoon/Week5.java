package choijungyoon;

public class Week5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Phone p = new Phone();
		SmartPhone g = new SmartPhone();
		
		p.incomingCall();
		g.incomingCall();
	}

}

class Phone{
	String number;
	
	void incomingCall() {
		System.out.println("µû¸£¸ª");
	}
	
	void outgoingCall() {
		
	}
}

class SmartPhone extends Phone{
	String os;
	
	@Override
	void incomingCall() {
		System.out.println("»ß»ß»ß");
	}
	
	void webBrowsing() {
		
	}
}