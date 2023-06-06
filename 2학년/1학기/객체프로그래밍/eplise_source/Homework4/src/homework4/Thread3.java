package homework4;

import java.lang.Thread;

public class Thread3 extends Thread{
	int n = 0;
	int i;
	public void run() {

		for(i=4001; i<6001; i++) {	//4001-6000합
			n = n + i;
			}
	}
	int getSum() {	//리턴값 반환
		return n;
	}
}
