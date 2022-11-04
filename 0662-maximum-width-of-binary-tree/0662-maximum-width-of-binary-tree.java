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
    public int widthOfBinaryTree(TreeNode root) {
        return DFS(root, 0, 1, new ArrayList(), new ArrayList());
    }
    
    public int DFS(TreeNode root, int level, int pos, ArrayList<Integer> start, ArrayList<Integer> end)
    {
        if(root == null) return 0;
        if(start.size() == level)
        {
            start.add(pos);
            end.add(pos);
        }
        else
        {
            end.set(level, pos);
        }
        
        
        int cur = end.get(level) - start.get(level) + 1;
        int left = DFS(root.left, level + 1, 2 * pos, start,end);
        int right = DFS(root.right, level + 1, 2 * pos + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}