// 725. Split Linked List in Parts
// Difficulty: Medium
// Category: Linked list

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
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        int size = len / k;
        int extra = len % k;
        
        curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                result[i] = null;
            } else {
                result[i] = curr;
                int partSize = size + (extra > 0 ? 1 : 0);
                extra--;
                
                for (int j = 1; j < partSize; j++) {
                    if (curr != null) {
                        curr = curr.next;
                    }
                }
                
                if (curr != null) {
                    ListNode nextPart = curr.next;
                    curr.next = null;
                    curr = nextPart;
                }
            }
        }
        
        return result;
    }
}
