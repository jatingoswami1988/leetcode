package main.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermuationOfStringUsingBacktracking {

	public static void main(String[] args) {
		System.out.println("Method 1");
		method1();
		System.out.println("Method 2");
		method2();
		System.out.println("Method 3");
		method3();
	}

	private static void method3() {
		String str = "ABC";
		int n = str.length();
		permute(str, 0, n - 1);
	}

	private static void method2() {

		String s = "ABC";
		permute1(s, "");

	}

	private static void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	private static void permute1(String ques, String answerSoFar) {

		if (ques.length() == 0) {
			System.out.println(answerSoFar);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			char c = ques.charAt(i);
			String quesLeftPart = ques.substring(0, i);
			String quesRightPart = ques.substring(i + 1);
			String restOfTheQues = quesLeftPart + quesRightPart;
			permute1(restOfTheQues, answerSoFar + c);
		}

	}

	private static void method1() {
		List<String> numbers = new ArrayList<>();
		numbers.add("A");
		numbers.add("B");
		numbers.add("C");
		List<List<String>> result = new ArrayList<>();
		permuationOfStringUsingBacktracking(numbers, result, new ArrayList<>());
		System.out.print(result);

	}

	private static void permuationOfStringUsingBacktracking(List<String> string, List<List<String>> result,
			List<String> tempList) {
		if (tempList.size() == string.size()) {
			result.add(new ArrayList<String>(tempList));
		}

		for (String num : string) {
			if (tempList.contains(num))
				continue;
			tempList.add(num);
			permuationOfStringUsingBacktracking(string, result, tempList);
			tempList.remove(tempList.size() - 1);
		}

	}

}
