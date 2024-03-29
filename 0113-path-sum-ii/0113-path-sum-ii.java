/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList();
        DFS(root, targetSum, 0, list, new ArrayList());
        return list;
    }
    
    public void DFS(TreeNode root, int targetSum, int sum, List<List<Integer>> list, List<Integer> temp)
    {
        if(root == null)
        return;
        
        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum)
        {
            list.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
            return;
        }
        
        DFS(root.left, targetSum, sum, list, temp);
        DFS(root.right, targetSum, sum, list, temp);
        temp.remove(temp.size()-1);
        
        }
}