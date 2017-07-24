// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

public int evalRPN(String[] tokens) {
	int a,b;
	try {
		Deque<Integer> stk = new Stack<Integer>();
		for (String s : tokens) {
			if (s.equals("+")) {
				stk.add(stk.pop() + stk.pop());
			} else if (s.equals("/")) {
				b = stk.pop();
				a = stk.pop();
				stk.add(a / b);
			} else if (s.equals("*")) {
				stk.add(stk.pop() * stk.pop());
			} else if (s.equals("-")) {
				b = stk.pop();
				a = stk.pop();
				stk.add(a - b);
			} else {
				stk.add(Integer.parseInt(s));
			}
		}
		return stk.pop();
	} catch (ArithmeticException e){
		
	}	
}