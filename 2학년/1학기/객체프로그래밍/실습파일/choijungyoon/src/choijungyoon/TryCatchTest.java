package choijungyoon;

public class TryCatchTest {
	public static void main(String[] args) {
		String[] array = {"10", "2a"};
		int value = 0 ;
		for(int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(array[i]);
				}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스 오류"); 
				}
			catch(NumberFormatException e) {
				System.out.println("넘버 변환 오류"); 
				}
			finally { System.out.println("value"); 
			} 
		} 
	}
}