package prob5;

public class Prob5 {

	public static void main(String[] args) {
		String s, s2 = "";
		int count = 0;
		for(int i = 1; i <= 99; i++) {
			s = Integer.toString(i);
			for(int j = 0; j < s.length(); j ++) {
				if(s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
					s2 += "짝";
				}
			}
			
			for(int j = 0; j < s.length(); j ++) {
				if((s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') && count == 0) {
					System.out.print(s);
					System.out.println(" " + s2);
					count ++;
				}
			}
			count = 0;
			s2 = "";
			
		}
	}
}
