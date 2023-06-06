package homework4;

import java.lang.Thread;

public class Thread5 extends Thread{
	int n = 0;
	int i;
	public void run() {

		for(i=8001; i<10001; i++) {	//8001-10000합
			n = n + i;
			}
	}
	int getSum() {	//리턴값 반환
		return n;
	}
}
