package chapter04;

public class WrapperTestClass02 {
	public static void main(String[] args) {
		String s1 = "123456";
		int i = Integer.parseInt(s1);
		
		//cf. 반대로
		String s2 = String.valueOf(i);
		//cf2. 반대로
		String s3 = i + "";
		
		System.out.println(s1 + " : " + s2 + " : " +s3);
		
		// 16진수
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		// 2진수
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		// 16진수
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
		
	}

}
