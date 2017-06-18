/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

/*
Assumptions:
	1. Sorted or not sorted?
	2. More than one solution?
	3. What should I return?
	4. Can one element be used twice? one element add itself.
    5. Duplicate elements.
*/

//  Dum Method (2 pass): use HashMap, ArrayList, sorting and two pointers
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        
        //Corner Case: at least 2 elements
        if(nums == null || nums.length < 2) {
            return output;
        }
        
        //Use HashMap to save the mapping of index and value
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        // Create a map from Value to Index!
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], new ArrayList<Integer>()));
            map.get(nums[i]).add(i);
        }
        
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        
        while(left < right) {
            int sum = nums[left] + nums[right];
            // Found
            if (sum == target) {
                if (nums[left] != nums[right]) { // Two elements are different.
                    output[0] = map.get(nums[left]).get(0);
                    output[1] = map.get(nums[right]).get(0);
                } else { // Two elements are same.
                    output[0] = map.get(nums[left]).get(0);
                    output[1] = map.get(nums[right]).get(1);
                }
                return output;
            } else if (sum > target) {
                right--; 
            } else {
                left++;
            }
        }
        
        return output;
    }

  // Smart Method (1 pass): only use HashMap<Integer, Integer> without sorting
    public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < numbers.length; i++) {
    		if (map.containsKey(target - numbers[i])) {
    			result[1] = i;
    			result[0] = map.get(target - numbers[i]);
    			return result;
    		}
    		map.put(numbers[i], i);
    	}
    	return result;
    }

