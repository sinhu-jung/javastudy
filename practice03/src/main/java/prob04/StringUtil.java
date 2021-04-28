package prob04;

public class StringUtil {
	private static String concat;
	
	public static String concatenate (String[] strArr) {
		concat = "";
		for(int i = 0; i < strArr.length; i++) {
			concat += strArr[i];
		}
		return concat;
	}
}
