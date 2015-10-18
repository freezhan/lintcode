package usGiants.String;
public class StrStr {
	public static void main(String[] args) {
		System.out.println(strStr("source", "target"));// -1
		System.out.println(strStr("abcdabcdefg", "bcd"));// 1
		System.out.println(strStr("", ""));// 0
		System.out.println(strStr("lintcode", "lintcode"));
	}

	public static int strStr(String source, String target) {
		if (source == null || target == null) {
			return -1;
		}
		if (source.length() < target.length()) {
			return -1;
		}
		if ("".equals(source) && "".equals(target)) {
			return 0;
		}
		if (source.equals(target)) {
			return 0;
		}
		for (int i = 0; i < source.length() - target.length(); i++) {
			if (source.subSequence(i, i + target.length()).equals(target)) {
				return i;
			}
		}
		return -1;
	}

}
