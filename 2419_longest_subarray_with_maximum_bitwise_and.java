// 2419. Longest Subarray With Maximum Bitwise AND
// Difficulty: Medium
// Topics: Array, Bit Maniupulation, Brainteaser

class Solution {
    public int longestSubarray(int[] nums) {

        int maxN = Arrays.stream(nums).max().getAsInt();
        int maxL = 0, currL = 0;

        for (int num : nums) {
            if (num == maxN) {
                currL++;
            } else {
                maxL = Math.max(maxL, currL);
                currL = 0;
            }
        }

        return Math.max(maxL, currL);
    }
}