/*
Given an input string, reverse the string word by word. A word is defined as a sequence of
non-space characters. 

Assumption: The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the"

Could you do it in-place without allocating extra space?
*/

	// 	  input:  char[]
	// 	 output:  char[]
	// JAVA string: immutable

public class Solution {
    public String reverseWords(String s) {
        //Corner Case
        if(s == null || s.length() ==0) {
            return "";
        }
       
        char[] str = s.toCharArray();
        int n = str.length;
        
        //First, reverse the whole string
        reverse(str, 0, n-1);
        
        //Second, reverse each word
        int left = 0;
        int right = 0;
        
        while(right < n) {
            // right must be in the right
            if(str[right] != ' ' || right < left) {
                right++;
            }else {
                left = ++right;
                // Skip spaces, left must not be space!
                while(left < n && str[left] == ' ') {
                    left++;
                }
            }
            
            reverse(str, left, right-1); // Revere each word
        }
        
        //Third, clean spaces in place
        int i = 0, j = 0;
        
        while (j < n) {
            while(j < n && str[j] == ' ') {
            // j skips spaces
                j++;
            }
        
            while(j < n && str[j] != ' ') {
            //Copy j to i. i may be a space
                str[i++] = str[j++];
            }
        
            while(j < n && str[j] == ' ') {
                j++;
            }
        
            if(j < n) {
                str[i++] = ' ';
            }
            
        }
        
        return new String(str).substring(0, i);
    }
    
    private void reverse(char[] ch, int start, int end) {
        while(start < end) {
            char tmp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = tmp;
        }
    }
}

// Wrong Answer:
// Input:		"hi!"
// Output: 		"h!i"
// Expected: 	"hi!"