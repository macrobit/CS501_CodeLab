/* 
Given an arbitrary ransom note string and another string containing letters
from all the magazines, write a function that will return true if the ransom
note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note: You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false 
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true 
*/

// Use counter array
public boolean canConstruct (String ransomeNote, String magazine) {
	//Corner Case
	if(ransomeNote == null || magazine == null || ransomeNote.length() > magazine.length()) {
		return false;
	}
	//
	int[] counter = new int[26];
	for (int i = 0; i < magazine.length(); i++) {
		counter[magazine.charAt(i) - 'a']++;
	}
	for (int i = 0; i < ransomNote.length(); i++) {
		if(--counter[ransomeNote.charAt(i) - 'a'] < 0) {
			return false;
		}
	}

	return true;
}

// Use HashMap
public boolean conConstruct (String ransomeNote, String magazine) {
	//Corner Case
	if (ransomNote == null || magazine == null) {
		return false;
	}

	char[] chaMag = magazine.toCharArray();
	char[] chaRan = ransomeNote.toCharArray();

	Map<Character, Integer> map = new HashMap<>();
	for (char ch : chaMag) {
		map.put(ch, map.getOrDefault(ch, 0) + 1);
	}

	for (char ch : chaRan) {
		int count = map.getOrDefault(ch, 0) - 1;
		if (count < 0) {
			return false;
		}
		map.put(ch, count);
	}
	return true;
}


