// 2641. Cousins in Binary Tree II
// Difficulty: Medium
// Topics: Binary Tree

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
    
    private List<Integer> depthSum;

    public TreeNode replaceValueInTree(TreeNode root) {
        depthSum = new ArrayList<>();
        
        dfs1(root, 0);
        
        dfs2(root, 0, 0);
        
        return root;
    }

    private void dfs1(TreeNode root, int d) {
        if (root == null) return;
        
        if (d >= depthSum.size()) {
            depthSum.add(root.val);
        }
        
        else {
            depthSum.set(d, depthSum.get(d) + root.val);
        }
        
        dfs1(root.left, d + 1);
        dfs1(root.right, d + 1);
    }

    private void dfs2(TreeNode root, int val, int d) {
        if (root == null) return;

        root.val = val;

        int c = d + 1 < depthSum.size() ? depthSum.get(d + 1) : 0;
        
        c -= (root.left != null ? root.left.val : 0);
        c -= (root.right != null ? root.right.val : 0);

        if (root.left != null) dfs2(root.left, c, d + 1);
        if (root.right != null) dfs2(root.right, c, d + 1);
    }
}