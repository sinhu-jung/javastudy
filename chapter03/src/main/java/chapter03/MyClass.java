package chapter03;

public class MyClass {
	private static MyClass instance;
	private MyClass() {
	}
	
	// Singleton(프로그램이 시작했을 때 객체가 하나인것) + Factory Method
	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
		}
		
		return instance;
	}
}
