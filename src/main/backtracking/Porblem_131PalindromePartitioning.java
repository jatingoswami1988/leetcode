package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Porblem_131PalindromePartitioning {

	public static void main(String[] args) {

		String s = "nitin";
		partition(s);
	}

	private static void partition(String s) {
		List<List<String>> result = new ArrayList<>();
		palindromePartitioning(s, result, new ArrayList<>());
		System.out.println(result);
	}

	private static void palindromePartitioning(String str, List<List<String>> result, List<String> temp) {

		if (str.length() == 0) {
			result.add(new ArrayList<>(temp));
			return;
		} else {

			for (int i = 0; i < str.length(); i++) {
				String prefix = str.substring(0, i + 1);
				String restOfTheString = str.substring(i + 1);
				if (pallindrome(prefix)) {
					temp.add(prefix);
					palindromePartitioning(restOfTheString, result, new ArrayList<>(temp));
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	private static boolean pallindrome(String prefix) {
		for (int i = 0; i < prefix.length() / 2; i++) {
			if (prefix.charAt(i) != prefix.charAt(prefix.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
}
