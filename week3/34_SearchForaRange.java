/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

// Method 1: two passes
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
		int mid = start + (end - start)/2 + 1; // must plus 1. Why? If you want to find right bound, you want a mid as right as possible
		if (nums[mid] > target) {
			end = mid - 1; // Only when nums[mid] > target, the end would be smaller
		} else {
			start = mid;
		}
	}

	res[1] = end;
	return res;

}

// Method 2: one pass (recursion)
public int[] searchRange(int[] nums, int target) {
	// corner case:
	if (nums == null || nums.length == 0) {
		return new int[] {-1, -1};
	}
	// Initialization
	int[] res = {nums.length, -1};
	// A helper method is usually for recursion
	helper(nums, target, 0, nums.length-1, res);
	return res[0] <= res[1] ? res : new int[] {-1, -1};
}

public void helper(int[] nums, int target, int start, int end, int[] res) {
	// corner case
	if (start > end) {
		return;
	}
	int mid = start + (end - start)/2;
	if(nums[mid] < target){
		helper(nums, target, mid+1, end, res);
	} else if(nums[mid] > target) {
		helper(nums, target, start, mid-1, res);
	} else {
		if(mid < res[0]) {
			res[0] = mid;
			helper(nums, target, start, mid-1, res); //??
		}
		if(mid > res[1]) {
			res[1] = mid;
			helper(nums, target, mid+1, end, res);  //??
		}
	}

}













}