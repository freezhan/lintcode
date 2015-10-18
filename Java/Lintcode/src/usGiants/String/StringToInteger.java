package usGiants.String;

public class StringToInteger {
	public static void main(String[] args) {

		System.out.println(atoi("10"));
		System.out.println(atoi("-1"));
		System.out.println(atoi("123123123123123"));
		System.out.println(atoi("1.0"));
		System.out.println(atoi("               k"));// 0
		System.out.println(atoi("    -5211314"));
		System.out.println(atoi("    52lintcode   "));// 52
		System.out.println(atoi(" "));// 0
		System.out.println(atoi("   +-1111 "));// 0
		System.out.println(atoi("+1")); // 1
		System.out.println(atoi("15+4")); // 15
		System.out.println(atoi("        112469032d53"));// 112469032

	}

	public static int atoi(String str) {
		str = str.trim();
		int pointIndex = str.indexOf('.');
		if (pointIndex >= 0) {
			str = str.substring(0, pointIndex);
		}
		if (str.startsWith("+-") || str.startsWith("-+")) {
			return 0;
		}
		boolean isNegative = false;
		if (str.startsWith("-")) {
			isNegative = true;
			str = str.substring(1, str.length());
		}
		if (str.startsWith("+")) {
			str = str.substring(1, str.length());
		}

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				sb.append(c);
			} else {
				break;
			}
		}
		str = sb.toString();
		if ("".equals(str)) {
			return 0;
		}

		if (str.length() > 10) {
			if (isNegative) {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		Double d = new Double(str);
		if (isNegative && d >= (new Double(Integer.MAX_VALUE) + 1)) {
			return Integer.MIN_VALUE;
		}
		if (isNegative == false && d >= new Double(Integer.MAX_VALUE)) {
			return Integer.MAX_VALUE;
		}

		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			result = result * 10 + (c - '0');
		}
		if (isNegative) {
			result = -result;
		}
		return result;
	}

}
