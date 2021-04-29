package exception;

import java.io.IOException;

public class MyClass {
	
	public void danger() throws IOException, MyException { //throw 를 사용하면 함수에서 던질 수 있다고 알려줘야됨
		System.out.println("some codes1");
		System.out.println("some codes2");
		
		if( 5 - 5 == 0) {
			throw new MyException();
		}
		
		if(10 - 10 == 0){
			throw new IOException();
		}
	
		System.out.println("some codes3");
		System.out.println("some codes4");
	}

}
