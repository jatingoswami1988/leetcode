package main.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class KeyComparator implements Comparator<Key> {

	@Override
	public int compare(Key o1, Key o2) {
		return o1.index.compareTo(o2.index);
	}

}

class Key {

	Character character;
	Integer index;

	public Key(Character ch, Integer index) {
		this.character = ch;
		this.index = index;
	}

	public Character getC() {
		return character;
	}

	public void setC(Character c) {
		this.character = c;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}

public class Problem_791_CustomSortString {

	public static void main(String[] args) {

		// String order = "cba", s = "abcd";
		String order = "bcafg", s = "abcd";
		Map<Character, Integer> result = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			result.put(order.charAt(i), i);
		}

		PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());

		for (int i = 0; i < s.length(); i++) {
			if (result.get(s.charAt(i)) != null) {
				pq.add(new Key(s.charAt(i), result.get(s.charAt(i))));
			} else {
				pq.add(new Key(s.charAt(i), Integer.MAX_VALUE));
			}
		}

		String finalString = "";

		while (!pq.isEmpty()) {
			Key c = pq.poll();
			finalString = finalString + c.getC();
		}

		System.out.println(finalString);

	}

}
