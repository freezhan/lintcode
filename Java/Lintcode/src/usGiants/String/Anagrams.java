package usGiants.String;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {
	public static void main(String[] args) {
		System.out.println(CompareStrings("tea", "and"));
		String[] strs = { "tea", "and", "ate", "eat", "den" };
		List<String> result = anagrams(strs);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
		System.out.println();

	}

	public static List<String> anagrams(String[] strs) {
		if (strs == null) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		if (strs.length == 0) {
			return result;
		}
		boolean[] flags = new boolean[strs.length];
		for (int i = 0; i < strs.length - 1; i++) {
			if (flags[i] == false) {
				search(i, strs, flags);
			}
		}
		for (int i = 0; i < strs.length; i++) {
			if (flags[i]) {
				result.add(strs[i]);
			}
		}
		return result;
	}

	private static void search(int index, String[] strs, boolean[] flags) {
		for (int i = index + 1; i < strs.length; i++) {
			if (CompareStrings(strs[index], strs[i])) {
				flags[index] = true;
				flags[i] = true;
			}
		}

	}

	private static boolean CompareStrings(String source, String target) {
		if (source.length() != target.length()) {
			return false;
		}
		int[] arrays = new int[26];
		for (int i = 0; i < source.length(); i++) {
			arrays[source.charAt(i) - 'a'] += 1;
			arrays[target.charAt(i) - 'a'] -= 1;
		}
		for (int i = 0; i < 26; i++) {
			if (arrays[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
