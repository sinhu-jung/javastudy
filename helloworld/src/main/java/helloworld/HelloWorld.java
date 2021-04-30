package helloworld;

public class HelloWorld {

	public static void main(String[] args) {
		String[] stack = new String[3];
		for(int i = 0; i < stack.length; i++) {
			stack[i] = new String("null");
		}
		
		System.out.println(stack[3]);

	}

}
