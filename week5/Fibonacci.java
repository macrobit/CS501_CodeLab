
// Method 1: recurssion
// Time Complexity: O(2 ^ n)
// Space Complexity: O(2 ^ n)
int getFibonacci(int n) {
	if (n < 1) {
		return 0;
	}
	if (n == 1) {
		return 1;
	}
	if (n == 2) {
		return 2;
	}
	return getFibonacci(n - 1) + getFibonacci(n - 2);
}

// Method 2: Memoization
// Time Complexity: O(n)
// Space Complexity: O(n)
int getFibonacci(int n, HashMap<Integer, Integer> cache) {
	if (n < 1) {
		return 0;
	}
	if (n == 1) {
		return 1;
	}
	if (n == 2) {
		return 2;
	}
	if (cache.contains(n)) {
		return cache.get(n);
	} else {
		int val = getFibonacci(n - 1) + getFibonacci(n - 2);
		cache.put(n, val);
		return val;
	}
}

// Method 3: Real DP
// Time Complexity: O(n)
// Space Complexity: O(1)
int getFibonacci(int n) {
	if (n < 1) {
		return 0;
	}
	if (n == 1) {
		return 1;
	}
	if (n == 2) {
		return 2;
	}
	int a = 1;
	int b = 2;
	int tmp;
	for (int i = 3; i <= n; i++) {
		tmp = a + b;
		a = b;
		b = tmp;
	}
	return tmp;
}