package exception;

/**
 * 
 * 
 * @author BIT_R41
 *
 * try~catch~finally 구문 만들기 연습
 *
 */

public class ExceptionTest {

	public static void main(String[] args) {

		int a = 10;
		int b = 10 - a;
		
		System.out.println("some codes...1");
		try {
			System.out.println("some codes...2");
			int result = (1 + 2 + 3) / b;
			System.out.println("some codes...3");
		}catch(ArithmeticException e) {
			/* 예외 처리 */
			// 1. 사과(프로그램 사용자에게)
			System.out.println("미안합니다...");
			// 2. 로깅(기록 남겨놓기(파일 또는 db에))
			System.out.println("error:" + e);
			// 3. 정상 종료
			return;
		}finally {
			//finally는 예외발생으로 정상 종료 되도 실행이됨
			/*자원 정리*/
			System.out.println("some codes...final(자원정리)");
		}
		
		// try catch finally를 사용했을때는 아래 쪽에 코드 남겨두지 말기
		
	}

}
