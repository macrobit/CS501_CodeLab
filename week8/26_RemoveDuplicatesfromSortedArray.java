// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array nums = [1,1,2],

// Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

public int removeDuplicates(int[] nums) {
	//corner case
	if (nums == null || nums.length == 0) {
		return 0;
	}

	int p1 = 0;
	int p2 = 0;
	int len = 1;

	while (p1 < nums.length) {
		if (nums[p1] != nums[p2]) {
			p2++;
			nums[p2] = nums[p1];
			len++;
		}
		p1++;
	}
	return len;
}

// Method 2:
public int removeDuplicates(int[] nums) {
	//corner case
	if(nums == null || nums.length == 0){
		return 0;
	}
	if(nums.length == 1){
		return 1;
	}
	int beg = 0;

	for(int i = 0; i < nums.length; i++){
		if(beg < 1 || nums[i] > nums[beg - 1]){
			nums[beg] = nums[i];
			beg++;
		}
	}
	
	return beg;
}









