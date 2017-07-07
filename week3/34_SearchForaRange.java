/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

public int[] searchRange(int[] nums, int target) {
	int[] res = {-1, -1};
	// corner case
	if (nums == null || nums.length == 0) {
		return res;
	}

	int start = 0;
	int end = nums.length - 1;
	// Find the left bound
	while (start < end) {
		int mid = start + (end - start)/2;
		if (nums[mid] < target) {
			start = mid + 1;
		} else {
			end = mid;
		}
	}
	if (nums[start] != target) {
		return res;
	} else {
		res[0] = start;
	}

	// Find the right bound
	end = nums.length - 1;
	while (start < end) {
		int mid = start + (end - start)/2 + 1; // must plus 1.
		if (nums[mid] > target) {
			end = mid - 1;
		} else {
			start = mid;
		}
	}

	res[1] = end;
	return res;

}