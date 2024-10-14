// 2530. Maximal Score After Applying K Operations
// Difficulty: Medium
// Topics: Array, Heap (Priority Queue)

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long res = 0;
        
        for (int num : nums) {
            pq.offer(num);
        }
        
        while (k > 0 && !pq.isEmpty()) {
            int largest = pq.poll();
            res += largest;
            int temp = (largest + 2) / 3;
            if (temp > 0) pq.offer(temp);
            k--;
        }
        
        return res;
    }
}
