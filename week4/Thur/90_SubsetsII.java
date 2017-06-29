/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public List<List<Integers>> subsetsWithDup(int[] nums) {
	List<List<Integers>> res = new ArrayList<List<Integers>>();
	if(nums == null || nums.length == 0) {
		res.add(new ArrayList<Integers>());
		return res;
	}

	Arrays.sort(nums); // so that duplicates can be clustered
	helper(res, new ArrayList<Integers>(), nums, 0);
	return res;
}

private void helper(List<List<Integers>> res, List<Integers> path, int nums, int pos) {
	// base
	res.add(new ArrayList<Integers>(path));

	for (int i = pos; i < nums.length; i++) {
//		if(i != 0 && nums[i] == nums[i-1]) {
		if (i != pos && nums[i] == nums[i-1]) {
			continue;
		}

		path.add(nums[i]);
		helper(res, path, nums, i + 1);
		path.remove(path.size() - 1);
	}

	return;

}
