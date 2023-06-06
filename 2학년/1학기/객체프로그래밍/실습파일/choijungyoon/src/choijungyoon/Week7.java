package choijungyoon;

public class Week7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 5;
		int b = 6;
		
		//result using method
		OtherClass otherClass = new OtherClass();
		int result1 = otherClass.add(a,b);
		
		//result using lambda
		//Lambda lambda = (x,y) -> {return x+y};
		//int result2 = lambda.add(a, b);
		
		System.out.println(result1);
		//System.out.println(result2);
	}
}
