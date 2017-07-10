/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

// Obviously BFS 广度优先算法

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		// corner case
		if (root == null) {
			res.add(new ArrayList<Integer>());
			return res;
		}

		//helper(res, new ArrayList<Integer>(), root);
		helper(res, root, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, TreeNode curr, int level) { // BFS use level not path!
		// Base
		if (curr == null) {
			return;
		}

		if (res.size() <= level) { // one element correspond to one level
			List<Integer> newLevel = new ArrayList<>(); 
			res.add(newLevel);
		}

		List<Integer> element = res.get(level);

		if (level % 2 == 0) {
			element.add(curr.val);
		} else {
			element.add(0, curr.val);
		}

		helper(res, curr.left, level+1);
		helper(res, curr.right, level+1);

	}

}