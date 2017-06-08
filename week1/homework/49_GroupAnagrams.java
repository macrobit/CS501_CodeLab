/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/

public class Solution {

	public List<List<String>> groupAnagrams(String[] strs) {

		// Corner Case
		if(strs == null || strs.length == 0) {
			return new ArrayList<List<String>>();
		}

		//List<List<String>> res = new List<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		int cur = 0;

		for(int i = 0; i < strs.length; i++) {
			for(String s : map.keySet()) {
				if(isAnagram(strs[i], s)){
					// Compare strs[i] with each key in the map
					List v = map.getOrDefault(s, new ArrayList<String>());
					v.add(strs[i]);
					map.put(s, v);
				}
			}
		}

		return new ArrayList<List<String>>(map.values());
	}

	private static boolean isAnagram(String s, String t) {

		// Corner Case: s equals t
		if(s.equals(t)) {
			return true;
		}

		// Corner Case: s and t have different length
		if(s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Integer> map = new HashMap<>();

		for(int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
		}

		for(int cur : map.values()) {
			if (cur != 0) {
				return false;
			}
		}

		return true;
	}
}

