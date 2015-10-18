package usGiants.String;

public class LongestCommonSubstring {
	public static void main(String[] args) {
		System.out.println(longestCommonSubstring("ABCD", "CBCE"));
		System.out.println(longestCommonSubstring("www.lintcode.com code",
				"www.ninechapter.com code"));

	}

	public static int longestCommonSubstring(String A, String B) {
		if ("".equals(A) || "".equals(B)) {
			return 0;
		}
		int[][] dp = new int[A.length() + 1][B.length() + 1];
		int max = 0;
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}

}
