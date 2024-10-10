// 962. Maximum Width Ramp
// Difficulty: Medium
// Topics: Array, Math

class Solution {
    public int maxWidthRamp(int[] nums) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = i;
            arr[i][1] = nums[i];
        }
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for (int[] pair : arr) {
            int index = pair[0];
            max = Math.max(max, index - min);
            min = Math.min(min, index);
        }
        
        return max;
    }
}