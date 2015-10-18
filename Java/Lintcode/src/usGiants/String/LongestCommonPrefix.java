package usGiants.String;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = { "ABCD", "ABEF", "ACEF" };
		System.out.println(longestCommonPrefix(strs));

		String[] strs2 = { "ABCDEFG", "ABCEFG", "ABCEFA" };
		System.out.println(longestCommonPrefix(strs2));

		String[] strs3 = { "ABCDEFG" };
		System.out.println(longestCommonPrefix(strs3));

	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String str = strs[i];
			int len = Math.min(prefix.length(), str.length());
			int index = 0;
			for (index = 0; index < len; index++) {
				if (str.charAt(index) != prefix.charAt(index)) {
					break;
				}
			}
			if (str.indexOf(index) != prefix.indexOf(index)) {
				index -= 1;
			}
			prefix = prefix.substring(0, index);
		}
		return prefix;
	}
}
