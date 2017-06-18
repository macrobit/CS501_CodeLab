/*
Given an integer array and a specific target, find whether there are three numbers in the array,
the sum of which is the target.
*/

// O(n^2) two end pointers, sorting
public boolean ThreeSum(int[] nums, int target) {
	int left, right, sum;

	//Corner Case:
	if (nums == null || nums.length < 3) {
		return false;
	}

	Arrays.sort(nums);

	for (int i = 0; i < nums.length - 2; i++) {
		left = i + 1;
		right = nums.length - 1;
		sum = nums[i] + nums[left] + nums[right]; 
		while (left < right) {
			if ( sum == target) {
				return true;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
	}

	return false;

}