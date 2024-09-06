// 3217. Delete Nodes From Linked List Present in Array
// Difficulty: Medium
// Category: Array, Hash table, Linked list

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
public class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        
        while (head != null) {
            if (!set.contains(head.val)) {
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }
            head = head.next;
        }
        
        return temp.next;
    }
}