/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/

public void moveZeros(int[] nums) {
	// Corner Case
	if(nums == null || nums.length == 0) {
		return;
	}

	int pre = 0; // pre is used to point to Zero.

	// When move pre ahead, when not?
	for(int i = 0; i < nums.length; i++) {

		// At the begining, if nums[i] == nums[pre] == 0, pre stay, i move forward
		// if nums[i] == nums[pre] != 0, swap itself will change nothing, and then
		// they should move forward together.
		if(nums[i] != 0) {
			if(pre != i){
				swap(nums, pre, i);	
			}			
			pre++;
		}
	}

	return;
}

public void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}