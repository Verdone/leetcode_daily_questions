# 2807. Insert Greatest Common Divisors in Linked List
# Difficulty: Medium
# Topics: Linked List, Math, Number Theory

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        curr = head
        while curr and curr.next:
            gcd_val = math.gcd(curr.val, curr.next.val)
            gcd_node = ListNode(gcd_val)
            gcd_node.next = curr.next
            curr.next = gcd_node
            curr = gcd_node.next
        return head