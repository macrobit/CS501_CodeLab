public class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        helper(root, 0, sum, cache);
        return count;
    }
    
    public void helper(TreeNode root, int curSum, int target, Map<Integer, Integer> cache) {
        if (root == null) {
            return;
        }
        
        curSum += root.val;
        
        if (cache.containsKey(curSum - target)) {
            count += cache.get(curSum - target);
        }
        
        if (!cache.containsKey(curSum)) {
            cache.put(curSum, 1);
        } else {
            cache.put(curSum, cache.get(curSum) + 1);
        }
        
        helper(root.left, curSum, target, cache);
        helper(root.right, curSum, target, cache);
        cache.put(curSum, cache.get(curSum) - 1);
    }
}