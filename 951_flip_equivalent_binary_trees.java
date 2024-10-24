// 951. Flip Equivalent Binary Trees
// Difficulty: Medium
// Topics: Binary Tree, Recursion

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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check(root1, root2);
    }

    private boolean check(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        
        if (n1 == null || n2 == null || n1.val != n2.val) return false;

        return (check(n1.left, n2.left) || check(n1.left, n2.right)) &&
               (check(n1.right, n2.right) || check(n1.right, n2.left));
    }
}
