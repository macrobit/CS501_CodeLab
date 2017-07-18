// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

public List<String> generateParenthesis(int n) {
	List<String> res = new ArrayList<>();
	helper(res, new String(), n, 0);
	return res;
}
// counter is the number of "(" which hasn't been paired?
private void helper(List<String> res, String str, int n, int counter) { // What is this counter?
// End case: all "(" have been paired, and there are n pairs.
	if(counter == 0 && str.length() == 2 * n) {
		res.add(new String(str));
		return;
	}
// corner case: all invalid situations
	if(counter < 0 || counter > n || str.length() > 2 * n) {
		return;
	}
// There is at least one "(" which has not been paired by a ")"
	if(counter > 0 && counter < n) {
		helper(res, str + "(", n, counter + 1);
		helper(res, str + ")", n, counter - 1);
	} else if(counter == 0) { // All "(" have been paired or just began
		helper(res, str + "(", n, counter + 1);
	} else { // counter == n
		helper(res, str + ")", n, counter - 1);
	}
	return;
}


