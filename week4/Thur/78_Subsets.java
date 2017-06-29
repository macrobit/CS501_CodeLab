/*
Given a set of DISTINCT integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Notice: 
1. the assumption is all integers are distinct, there is no duplicates!

*/

public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	// corner case
	if (nums == null || nums.length == 0) {
		res.add(new ArrayList<Integer>());
		return res;
	}

	//Arrays.sort(nums);
	helper(res, new ArrayList<Integer>(), nums, 0);
	return res;
}

private void helper(List<List<Integer>> res, List<Integer> path, int[] nums, int pos) {
	// add new subset into result list
	res.add(new ArrayList<Integer>(path)); 

	for(int i = pos; i < nums.length; i++) { // for循环语句用来广度遍历，并且i的初始值是动态的，只进不退
		 path.add(nums[i]);
		 helper(res, path, nums, i + 1); // 广度遍历改变的i值间接影响到深度遍历的初始值。
		 path.remove(path.size() - 1);
	}
	return;
}

/* 
	广度遍历改变的i值间接影响到深度遍历的意思是：当广度访问到nums[i]的时候，它后面可以跟的下一个值只能从nums[i+1]后面的值里面的值
   	去取。nums[i]前面的值永远不可能在path中出现在它的后面。

   	对于组合来说，顺序根本不重要！
*/

