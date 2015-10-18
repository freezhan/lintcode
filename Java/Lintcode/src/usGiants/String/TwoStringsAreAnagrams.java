package usGiants.String;
public class TwoStringsAreAnagrams {
	public static void main(String[] args) {

		System.out.println(anagram("abcd", "dcba"));
	}

	public static boolean anagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] array = new int[255];
		int len = s.length();
		for (int i = 0; i < len; i++) {
			array[s.charAt(i)] += 1;
		}
		for (int i = 0; i < len; i++) {
			array[t.charAt(i)] -= 1;
		}

		for (int i = 0; i < 255; i++) {
			if (array[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
