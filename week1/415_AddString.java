import java.lang.StringBuilder;

public class Solution {
    String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return "";
        }

        if(num1.length() == 0) {
            if(num2.length() == 0) {
                return "";
            } else {
                return num2;
            }
        }
 
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        
        for(int i = num1.length()-1, j = num2.length()-1;i >= 0 || j >= 0 || carry == 1; i--, j-- ) {
            carry += i < 0 ? 0 : num1.charAt(i) - '0';
            carry += j < 0 ? 0 : num2.charAt(j) - '0';
            
            res.append(carry % 10);
            carry /= 10;
        }
        
        return res.reverse().toString();
    }
};