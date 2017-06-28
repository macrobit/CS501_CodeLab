/*
* Given a collection of distinct numbers, return all possible permutations.

* For example,
* [1,2,3] have the following permutations:
* [
*  [1,2,3],
*  [1,3,2],
*  [2,1,3],
*  [2,3,1],
*  [3,1,2],
*  [3,2,1]
* ]
*/



public List<List<Integer>> permute (int[] nums) {
	List<List<Integer>> list = new ArrayList<>();
	// Arrays.sort(nums); // not necessary
	backtrack(list, new ArrayList<>(), nums);
	return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
	if (tempList.size() == nums.length) { // 凑够了数
		list.add(new ArrayList<>(tempList)); 
	} else {
		for(int i = 0; i < nums.length; i++) {
			if(tempList.contains(nums[i])) continue; // element already exists, skip
			tempList.add(nums[i]);
			backtrack(list, tempList, nums); // No return value, but list was changed already.
			tempList.remove(tempList.size() - 1);
		}
	}
}

public List<List<Integer>> permute2 (int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	// corner case
	if (nums == null || nums.length == 0) {
		return res;
	}

	helper (res, new ArrayList<Integer>, nums, new Boolean[nums.length]);
	return res;

}

private void helper (List<List<Integer>> res, List<Integer> path, int[] nums, Boolean[] isVisited) {
	// Base
	if (path.size() == nums.length) {
		res.add(new ArrayList<>(path));
		return;
	}

	// Body
	for (int i = 0; i < nums.length; i++) {  
		if (isVisited[i]) { // skip the visited number
			continue;
		}

		path.add(nums[i]); 	// add the not-yet-visited number
		isVisited[i] = true; // set it visited
		helper(res, path, nums, isVisited);	// path changed, isVisited changed!
		path.remove(path.size() - 1); // remove the last number
		isVisited[i] = false; // clear history record 每访问过一个数后必要恢复成没有访问过的状态，这不影响后续的循环操作，因为已经不走回头路！
	}

	return;
}

/*
	首先通过DFS算法深挖到递归树的最底层叶子节点，当长度凑够后将新的排列加入结果list后返回，进而终结递归。	返回上一层递归后要做的工作就是将最后加入数列的
	数字删除，并将其遗忘。接下来尝试同一层的其它可能，每当尝试其它可能数字的时候会深入到进一步的递归操作中。就这样尝试每一层的可能数字，并且在尝试完之后
	返回上一级。直到返回根节点。

	Complexity:
		Time: O(n!)
		Space: O(n * n!)					
*/









