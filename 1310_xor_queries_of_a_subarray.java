// 1310. XOR Queries of a Subarray
// Difficulty: Medium
// Category: Array, Bit manipulation, prefix sum

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int n = arr.length;
        int[] x = new int[n];
        x[0] = arr[0];
        for (int i = 1; i < n; i++) {
            x[i] = x[i-1] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];
            if (L == 0) {
                res[i] = x[R];
            } else {
                res[i] = x[L-1] ^ x[R];
            }
        }

        return res;
    }
}
