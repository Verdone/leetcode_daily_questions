// 2028. Find Missing Observations
// Difficulty: Medium
// Topics: Array, Math, Simulation

class Solution {
    private int[] makeSum(int sum, int[] arr) {
        int currSum = arr.length;
        
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] < 6 && currSum < sum) {
                arr[i]++;
                currSum++;
            } 
        }
        
        return arr;
    }
    
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        int div = rolls.length + n;
        int sum = 0;
        
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        
        int findSum = (mean * div) - sum;
        if (findSum < n || findSum > (6 * n)) {
            return new int[0];
        }
        
        return makeSum(findSum, arr);
    }
}