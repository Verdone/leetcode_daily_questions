// 2406. Divide Intervals Into Minimum Number of Groups
// Difficulty: Medium
// Array, Two Pointers, Sorting

class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int end_ptr = 0, ct = 0;

        for (int start : starts) {
            if (start > ends[end_ptr]) {
                end_ptr++;
            } else {
                ct++;
            }
        }

        return ct;
    }
}