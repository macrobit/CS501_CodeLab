
/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

/*
	This question is very simple, because only plus one digit integer to the non-negative integer.
	You just need to judge two points:
	1. whether there is any carry?
	2. whether the more significant digit is 9?

*/
public class Solution {
    public int[] plusOne(int[] digits) {

    	// use a varibale carry to hold the carry.
        //int carry = 1;

        for(int i = digits.length - 1; i >= 0; i--) {
            // carry += digits[i];
            // digits[i] = carry % 10;
            // carry = carry / 10;

            if(digits[i] < 9) {
            	digits[i]++;
            	return digits;
            }

            digits[i] = 0; // when the digit is 9, create a carry bit 1.
        }
        
        // If carry == 1, there is only one possibility: the first digit is 1, all the left digits are zero!
        //if(carry != 0) {
            int[] newNum = new int[digits.length + 1];
            newNum[0] = 1;
            
            return newNum;
        // } else {
        //     return digits;
        // }
        
    }
}