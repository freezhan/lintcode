package usGiants.String;
public class CompareStrings {
	public static void main(String[] args) {

		System.out.println(compareStrings("ABCD", "ACD"));
		System.out.println(compareStrings("ABCD", "AABC"));
	}

	public static boolean compareStrings(String A, String B) {
		if (A.length() < B.length()) {
			return false;
		}

		int[] array = new int[255];
		int len = A.length();
		for (int i = 0; i < len; i++) {
			array[A.charAt(i)] += 1;
		}
		len = B.length();
		for (int i = 0; i < len; i++) {
			array[B.charAt(i)] -= 1;
		}
		for (int i = 0; i < 255; i++) {
			if (array[i] < 0) {
				return false;
			}
		}
		return true;
	}

}
