package homework4;

import java.lang.Thread;

public class Thread4 extends Thread{
	int n = 0;
	int i;
	public void run() {

		for(i=6001; i<8001; i++) {	//6001-8000��
			n = n + i;
			}
	}
	int getSum() {	//���ϰ� ��ȯ
		return n;
	}
}