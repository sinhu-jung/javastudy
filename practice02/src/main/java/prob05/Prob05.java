package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			while(true) {
				int a = 0;
				int min = 1;
				int max = 100;
				int correctNumber = random.nextInt( 100 ) + 1;
				System.out.println( "수를 결정 하였습니다. 맞추어 보세요" );
				
				for(int i = 1;; i++) {
					System.out.println(min + "-" + max);
					System.out.print(i + ">>");
					a = scanner.nextInt();
					
					if(a < correctNumber) {
						System.out.println("더 높게");
						min = a;
					}
					else if(a > correctNumber) {
						System.out.println("더 낮게");
						max = a;
					}
					else {
						System.out.print("맞았습니다.");
						//새 게임 여부 확인하기
						System.out.print( "다시 하겠습니까(y/n)>>" );
						String answer = scanner.next();
						if( "y".equals( answer ) == true ) {
							break;
						}
						else {
							System.exit(0);
						}
					}
				}
				
			}

		}
	}

}