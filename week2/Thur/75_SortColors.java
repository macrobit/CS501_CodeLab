/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

public class Solution {
	// two-pass algorithm using counting sort
	public void sortColors(int[] nums) {
		//Corner Case
		if(nums == null || nums.length == 0) {
			return;
		}

		int[] counter = new int[3];

		for(int i = 0; i < nums.length; i++) {
			counter[nums[i]]++;
		}

		for(int i = 0; i < nums.length; i++) {
			if(i < counter[0]) {
				nums[i] = 0;
			}

			if(i >= counter[0] && i < counter[0] + counter[1]) {
				nums[i] = 1;
			}

			if(i >= counter[0] + counter[1] && i < n) {
				nums[i] = 2;
			}
		}

		return;
	}

	// two-pointer algorithm using head and end pointers.
	public void sortColors(int[] nums) {
		//Corner Case
		if(nums == null || nums.length == 0) {
			return;
		}

		int len = nums.length;
		int head = 0;
		int end = len - 1;

		for(int i = 0; i < len; i++) {
			// First check 0.
			if(nums[i] == 0) {
				swap(nums, head, i);
				head++;
			}
			// Then check 2. 
			if(nums[i] == 2) {
				swap(nums, end, i);
				end--;
				i--; // After swapping, the swapped end elem may miss the check!!!
			}
		}

		return;
	}

	// one-pass algorithm using only constant space?
	public void sortColors(int[] nums) {
		//Corner Case
		if(nums == null || nums.length == 0) {
			return;
		}


	}



}