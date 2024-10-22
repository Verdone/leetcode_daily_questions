// 2583. Kth Largest Sum in a Binary Tree
// Difficulty: Medium
// Topics: Tree, BFS, Sorting

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
    public long kthLargestLevelSum(TreeNode root, int k) {

        List<Long> levelSums = new ArrayList<>();

        if (root == null) return -1;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int currentLevel = 1;
        while (!q.isEmpty()) {
            
            long levelSum = 0;
            
            int pending = q.size();
            for (int i = 0; i < pending; i++) {
                
                TreeNode node = q.poll();
                
                levelSum += node.val;
                
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }

            levelSums.add(levelSum);

            currentLevel++;
        }

        if (levelSums.size() < k)
            return -1;

        Collections.sort(levelSums, Collections.reverseOrder());

        return levelSums.get(k - 1);
    }
}