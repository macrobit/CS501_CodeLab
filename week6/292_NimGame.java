// You are playing the following Nim Game whith your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3
// sontes. The one who removes that last stone will be the winner. You will take the first turn to remove the stones.

// Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of
// stones in the heap.

// For example, if there are 4 stones in the heap, then you will never win the game.

// Becaue you will choose a optimal strategy, which means if there is only one condition that can make you win, you will win.

// Method 1: Mathmatic Decution
// Base: As we know, when the number is 4, no matter how many stones the first player pick up, there is always at least one stone left, so the first user
// 	must lose.
// Step 1: For a number n, 4 < n < 2 * 4 (5, 6, 7), because the first player can always find a way to left 4 stones to player 2, so 5, 6, 7 are all win number.
// Step 2: For number 2 * 4 = 8, no matter how many stones (1, 2, 3) the first player would choose the left stone number must be a win number in Step 1, 
// 		so number 8 is a death number.
// Step 3: For number 9, 10, 11 < 3 * 4, using the same deduction method we can get there is always a way to leave the 2nd player a death number 8.

// Assumption: when n is an integer, 4n is a death number, and 4n + 1, 4n + 2, 4n + 3 are all win numbers.
// Proof: we can prove 4(n+1) is also a death number, and 4(n+1) + 1, 4(n+1) + 2, 4(n+1) + 3 are also win numbers.

public boolean canWinNim(int n) {
	return n % 4 != 0;
}



// Method 2: DP Bottom-up
public boolean canWinNim(int n) {
	//corner case
	if (n < 4 && n > 0) {
		return true;
	}
	if (n <= 0) {
		return false;
	}
	boolean[] dp = new boolean[4];
	//base
	dp[0] = false; // no stones left means you have lost the game
	dp[1] = true; 
	dp[2] = true;
	dp[3] = true;
	//dp decuction
	for(int i = 4; i <= n; i++) { // When there is one lose situation in the next level, you will grap it and win!
		dp[i % 4] = !(dp[(i-1) % 4] && dp[(i-2) % 4] && dp[(i-3) % 4]);
	}
	return dp[n % 4];
}

//Method 3: DFS Recurssion Top-down
public boolean canWinNim(int n) {
	return helper(n, new HashMap<>()); //use a HashMap to save the information about whether a number of stones can make player win
}
public boolean helper(int n, Map<Integer, boolean> map) {
	//corner cases
	if(n <= 0) {
		return false;
	}
	// if(n <= 3 && n >= 1) {
	// 	return true;
	// }
	// Hit memoization table
	if(map.contiansKey(n)) {
		return map.get(n);
	}
	// create a base variable to do multiple logic and operations
	boolean canNextWin = true;
	for(int i = 1; i <= 3; i++) {
		canNextWin &= helper(n-i, map);
	}
	map.put(n,!canNextWin);
	return !canNextWin;
}

