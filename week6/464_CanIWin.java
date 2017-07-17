// 													LeetCode 464: Can I Win 
//   												  Author: Howard Fei
//
// This problem is as same as 292_NimGame, if the integers can be reused.
// 
// In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

// What if we change the game so that players cannot re-use integers?

// For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

// Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

// You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

// Example

// Input:
// maxChoosableInteger = 10
// desiredTotal = 11

// Output:
// false

// Explanation:
// No matter which integer the first player choose, the first player will lose.
// The first player can choose an integer from 1 up to 10.
// If the first player choose 1, the second player can only choose integers from 2 up to 10.
// The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
// Same with other integers chosen by the first player, the second player will always win.

public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
	// corner case
	if (desiredTotal <= 0) { 
		return true;
	}
	if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) { // sum is less than total, wrong condition
		return false;
	}

	return helper(desiredTotal, maxChoosableInteger, 0, new HashMap<>());
}

private boolean helper(int total, int n, int state, HashMap<Integer, boolean> cache) {
	if (total <= 0) {
		return false;
	}

	if (cache.containsKey(state)) {
		return cache.get(state);
	}

	for (int i = 0; i < n; i++) { // check every possible integer which hasn't been used before, and find the false one!
		// find a number which hasn't been used before.
		if ((state & (1 << i)) != 0) { // In java, an integer is expressed with 32 bit. Because max <= 20, we can use an integer to 
			continue;				  // to save the state which show which number has been used, and which not.
		}
		// find the false one, which mean one possible situation that let the second player lose
		if (!helper(total - (i + 1), n, state | (1 << i), cache)) { // mark the state to record that number i has been used
			cache.put(state, true); // current level can win
			return true;
		}
	}
	// if in every next level situation the next player can win, the current level user must loose.
	cache.put(state, false);
	return false;
	}
}
