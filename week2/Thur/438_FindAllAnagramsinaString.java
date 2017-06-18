/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
*/

public class Solution {
	// Brutal force method.
	public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();
 
        // Corner Case
        if(s == null || slen == 0 || p == null || plen == 0) {
            return new ArrayList<>();
        }
        

        int window = plen;
        List<Integer> output = new ArrayList<Integer>();
        
        for(int i = 0; i <= s.length() - window; i++) {
            String a = s.substring(i, i + window);
            if(isAnagram(a, p)) {
               output.add(i);
            }
        }
        
        return output;
	}

	// Sliding Window method.
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> output = new ArrayList<>();
		int slen = s.length();

		// Corner Case
        if(s == null || slen == 0 || p == null || plen == 0) {
            return output;
        }

        int[] hash = new int[256]; // Character Hash
        for(char c : p.toCharArray()) {
        	hash[c]++;
        }

        int left = 0, right = 0;
        int window = p.length();

       	while (right < slen) {
       		if (hash[s.charAt(right++)] -- >= 1) {
       			window--;
       		}

       		if (window == 0) {
       			output.add(left);
       		}
       	}

	}
}
