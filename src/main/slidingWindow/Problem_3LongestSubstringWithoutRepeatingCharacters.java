package main.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Problem_3LongestSubstringWithoutRepeatingCharacters {

	public static void main(String args[]) {

		String s = "pwwkew";

		// String s = "abcabcbb";

		//int n = s.length();
		int maxLength = 0;
		Map<Character, Integer> charMap = new HashMap<>();
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			if (!charMap.containsKey(s.charAt(i)) || charMap.get(s.charAt(i)) < end) {
				charMap.put(s.charAt(i), i);
				maxLength = Math.max(maxLength, i - end + 1);
			} else {
				end = charMap.get(s.charAt(i)) + 1;
				charMap.put(s.charAt(i), i);
			}
		}
		System.out.println(maxLength);
	}

}

/*
 * public static void main(String[] args) {
 * 
 * // String s = "abcabcbb"; // "abcabcbb" //String s = "pwwkew"; String s =
 * "abba"; int start = 0; int end = 0; int maxLength = 1; Map<Character,
 * Integer> map = new HashMap<>(); for (int i = 0; i < s.length(); i++) {
 * 
 * if (map.containsKey(s.charAt(i))) { start = map.get(s.charAt(i)) + 1; end =
 * i; map.put(s.charAt(i), i); } else { map.put(s.charAt(i), i); end = i; }
 * 
 * maxLength = Math.max(maxLength, (end - start) + 1); }
 * 
 * System.out.println(maxLength);
 * 
 * }
 */

//}
