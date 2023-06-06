package homework4;

import java.lang.Thread;

public class Thread1 extends Thread{	
	int n = 0;
	int i;
	public void run() {
		for(i=1; i<2001; i++) {	//1-2000합
			n = n + i;
			}
	}
	int getSum() {	//리턴값 반환
		return n;
	}
}