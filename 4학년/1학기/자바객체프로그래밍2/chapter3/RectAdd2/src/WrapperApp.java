//=====================================================
// Wrapper class Example
//=====================================================

public class WrapperApp {

	public static void main(String[] args) {
		int i = 100;
		Integer j = Integer.valueOf(i);
		Integer k = Integer.valueOf("200");
		System.out.println(j.doubleValue());
		System.out.println(Integer.parseInt("-123"));
		
		Double d = Double.valueOf(5.6);
		Double e = Double.valueOf("9.5");
		System.out.println(d.toString());
		System.out.println(e.intValue());
		
		Boolean a = Boolean.valueOf(true);
		Boolean b = Boolean.valueOf("false");
		System.out.println(a.toString());
		
		char c = 'q';
		Character cc = Character.valueOf('5');
		System.out.println(Character.toUpperCase(c));
		if(Character.isDigit(cc))
			System.out.println(Character.getNumericValue(cc));
		
		// auto boxing, unboxing
		k = i;
		System.out.println("Integer °´Ã¼: " + k);
		i = k + 20;
		System.out.println("int: " + i);
	}
}