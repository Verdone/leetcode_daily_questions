// 1367. Linked List in Binary Tree
// Difficulty: Medium
// Category: Linked List, Tree, Depth-first search, breadth-first search, binary tree

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        int listLength = getListLength(head);
        int treeHeight = getTreeHeight(root);
        
        if (listLength > treeHeight) {
            return false;
        }
        
        return dfs(root, head);
    }
    
    private int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    private int getTreeHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    private boolean dfs(TreeNode root, ListNode head) {
        if (root == null) return false;
        return checkPath(root, head) || dfs(root.left, head) || dfs(root.right, head);
    }
    
    private boolean checkPath(TreeNode root, ListNode head) {
        if (head == null) return true;
        if (root == null || root.val != head.val) return false;
        return checkPath(root.left, head.next) || checkPath(root.right, head.next);
    }
}
