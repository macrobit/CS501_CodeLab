// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array nums = [1,1,1,2,2,3],

// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

public int removeDuplicates(int[] nums) {
	if(nums == null){
		return 0;
	}
	if(nums.length <= 2){
		return nums.length;
	}

	int pre = 0;

	for(int i = 0; i < nums.length; i++){
		if(pre < 2 || nums[i] > nums[pre - 2]){
			nums[pre] = nums[i];
			pre++;
		}
	}
	return pre;
}