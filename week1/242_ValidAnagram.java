
	// 			          Leetcode 242 Valid Anagram

	// Given two strings s and t, write a function to determine if t is an anagram of s.

	// For example,

	// s = "anagram", t = "nagaram", return true.

	// s = "rat", t = "car", return false.

	// Note:

	// You may assume the String contains only lowercase alphabets. (This can be a good point to show your good analytic ability)

	// Follow up:

	// What if the inputs contain unicode characters? How would you adapt your solution to such case?
	// What if the length of these two strings are very big?


public boolean isAnagram(String s, String t) {
	// Corner Case 1: two strings are the same
	if(s.equals(t)) {
		return true;
	}

	// Corner Case 2: two strings cannot be anagram, because the have different length.
	if(s.length() != t.length()) {
		return false;
	}

	// If ASCII encoding is used, because one ASCII char is expressed with 7 bits binary digit, 
	// there are only 128 characters. If Unicode is used, there will be 2^16 different characters.
	int[] map = new int[128];
	for(int i = 0; i < s.length(); i++) {
		map[s.charAt(i) - 'a']++;
		map[t.charAt(i) - 'a']--;
	}

	for(int cur : map) {
		if (cur != 0) {
			return false;
		} else {
			return;
		}
	}

	return true;
}

