// 1590. Make Sum Divisible by P
// Difficulty: Medium
// Topics: Array, Hash Table, Prefix Sum

public class Solution {
    public int minSubarray(int[] nums, int p) {
        long t = 0;
        for (int num : nums) {
            t += num;
        }

        int r = (int)(t % p);
        if (r == 0) return 0;

        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, -1);

        int n = nums.length;
        int pSum = 0;
        int min = n;

        for (int i = 0; i < n; i++) {
            pSum = (pSum + nums[i]) % p;
            if (pSum < 0) {
                pSum += p;
            }

            int target = (pSum - r + p) % p;
            if (prefixSums.containsKey(target)) {
                min = Math.min(min, i - prefixSums.get(target));
            }

            prefixSums.put(pSum, i);
        }

        return min == n ? -1 : min;
    }
}