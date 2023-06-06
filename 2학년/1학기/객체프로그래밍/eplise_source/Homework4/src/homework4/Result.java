package homework4;

import java.lang.Thread;

public class Result {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 th1 = new Thread1();
		Thread2 th2 = new Thread2();
		Thread3 th3 = new Thread3();
		Thread4 th4 = new Thread4();
		Thread5 th5 = new Thread5();
		th1.run();	//쓰레드1 실행
		th2.run();	//쓰레드2 실행
		th3.run();	//쓰레드3 실행
		th4.run();	//쓰레드4 실행
		th5.run();	//쓰레드5 실행
		try{//쓰레드의 우선순위를 정해준다.
			//만약 현재 쓰레드 구현이 완벽하게 되지 않는다면
			th1.join();
			th2.join();
			th3.join();
			th4.join();
			th5.join();

		}catch(Exception e){
			//오류구문을 출력한다.
			System.out.println(e);

		}
		
		System.out.println(th1.getSum()+th2.getSum()
		+th3.getSum()+th4.getSum()+th5.getSum());	//각 쓰레드의 합의 리턴값을 출력해준다.

	}

}
