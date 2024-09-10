// 2326. Spiral Matrix IV
// Category: Array, Linked List, Matrix, Simulation
// Difficulty: Medium

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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for(int[] i : ans)
            Arrays.fill(i,-1);

        int l = 0 , r = n-1;
        int top = 0 , bot = m-1;

        ListNode th = head;

        while(l <= r  && top <= bot && th!=null)
        {
            for(int i = l ; i<=r && th!=null ;i++)
            {
                ans[top][i] = th.val;
                th = th.next;
            }
            top++;

            for(int i = top ; i<= bot && th!=null ;i++)
            {
                ans[i][r] = th.val;
                th = th.next;
            }
            r--;

            for(int i = r ; i>=l && th!=null ;i--)
            {
                ans[bot][i] = th.val;
                th = th.next;
            }
            bot --;

            for(int i = bot ; i>=top  && th!=null ;i--)
            {
                ans[i][l] = th.val;
                th = th.next;
            }
            l++;

        }
        return ans;
    }
}