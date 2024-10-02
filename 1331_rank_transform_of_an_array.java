// 1331. Rank Transform of an Array
// Difficulty: Easy
// Topics: Array, Hash Table, Sorting

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];
        
        int[][] iVP = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            iVP[i][0] = arr[i];
            iVP[i][1] = i;
        }
        
        Arrays.sort(iVP, Comparator.comparingInt(a -> a[0]));
        
        int[] r = new int[arr.length];
        int rank = 1;
        r[iVP[0][1]] = rank;
        
        for (int i = 1; i < arr.length; i++) {
            if (iVP[i][0] != iVP[i - 1][0]) {
                rank++;
            }
            r[iVP[i][1]] = rank;
        }
        
        return r;
    }
}