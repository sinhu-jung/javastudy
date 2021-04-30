package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		
		//c:temp
		System.out.println("c:\\temp");
		
		//"hello"
		System.out.println("\"hello\"");
		
		// \t : tab
		// \n : newline
		// \r : carriage return(유닉스는 \r\n 을 사용)
		// \b : beep
		
		System.out.print("hello\tworld" + "\n");
		System.out.println("hello\tworld");
		
		//'
		char c = '\'';
		System.out.println(c);

	}

}
