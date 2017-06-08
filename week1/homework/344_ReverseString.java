/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/

public class Solution {
    public String reverseString(String s) {
    	// Corner Case:
    	
    	// Converse a string into a array of chars
        char[] str = s.toCharArray();

        // Use two pointers to swap two characters from two end toward center
        for(int i = 0; i < s.length()/2; i++) {
            char tmp = str[i];
            str[i] = str[s.length() - 1 - i];
            str[s.length() - 1 - i] = tmp;
        }
        
        return new String(str);
    }
}

