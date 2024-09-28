// 2022. Convert 1D Array Into 2D Array
// Difficulty: Easy
// Topics: Array, Matrix, Simulation

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0]; 
        }
        
        int[][] r = new int[m][];

        for (int i = 0; i < m; i++) {
            r[i] = Arrays.copyOfRange(original, i * n, i * n + n);
        }

        return r;
    }
}