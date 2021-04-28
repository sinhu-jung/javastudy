package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		System.out.print("숫자를 입력하세요: ");
		int inum = scanner.nextInt();
		int isum = 0;
		
		for(int i = 0; i <= inum; i++) {
			if(inum % 2 == 1 && i % 2 == 1 ) {
				isum += i;
			}
			else {
				if(i % 2 == 0 && inum % 2 ==0) {
					isum += i;
				}
				
			}
		}
		
		System.out.print("결과값 : " + isum);
		scanner.close();
	}
}
