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
		th1.run();	//������1 ����
		th2.run();	//������2 ����
		th3.run();	//������3 ����
		th4.run();	//������4 ����
		th5.run();	//������5 ����
		try{//�������� �켱������ �����ش�.
			//���� ���� ������ ������ �Ϻ��ϰ� ���� �ʴ´ٸ�
			th1.join();
			th2.join();
			th3.join();
			th4.join();
			th5.join();

		}catch(Exception e){
			//���������� ����Ѵ�.
			System.out.println(e);

		}
		
		System.out.println(th1.getSum()+th2.getSum()
		+th3.getSum()+th4.getSum()+th5.getSum());	//�� �������� ���� ���ϰ��� ������ش�.

	}

}
