package homework4;

import java.lang.Thread;

public class Thread2 extends Thread{
	int n = 0;
	int i;
	public void run() {

		for(i=2001; i<4001; i++) {	//2001-4000��
			n = n + i;
			}
	}
	int getSum() {	//���ϰ� ��ȯ
		return n;
	}
}
