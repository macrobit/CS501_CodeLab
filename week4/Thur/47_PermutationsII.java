/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

/* 
	This question's point is how to know distinguish horizonal and vertical position!
	Complexity:
	Time ? 
	Space  ?
*/


public List<List<Integer>> permutationII (int[] nums) {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	if(nums == null || nums.length == 0) {
		return res;
	}

	Arrays.sort(nums);
	helper(res, new ArrayList<Integer>(), nums, new Boolean[nums.length]);
	return;
}

private void helper(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited) {
	// base: the length is reached, add a new element and return.
	if (path.size() == nums.length) {   
		res.add(new ArrayList<Integer>(path));
		return;
	}

	for (int i = 0; i < nums.length; i++) {
		// No vertical duplicates; 当nums[i] == nums[i-1]，但是访问标签却显示nums[i-1]当前没有被访问过
		// 这恰恰说明这两个数字现在是在不同的path上, 并且前一条path已经遍历过。如果它们在相同的path之上，那么
		// 基于纵向去重的原理，前一个必然已经被访问过了。
		if (visited[i] || i != 0 && nums[i] == nums[i-1] && !visited[i-1]) { // If "!visited[i-1]" is changed to "visited[i-1]", it will still work.
			continue;
		}

		path.add(nums[i]);
		visited[i] = true;
		helper(res, path, nums, visited);
		path.remove(path.size() - 1);
		visited[i] = false;
	}

	return;
}

