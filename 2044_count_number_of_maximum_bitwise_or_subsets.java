// 2044. Count Number of Maximum Bitwise-OR Subsets
// Difficulty: Medium
// Topics: Array, Backtracking

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        subsets(nums, 0, 0);
        return ct;
    }
    
    int ct = 0;
    int max = 0;
    
    private void subsets(int[] arr, int vidx, int OR){
        
        if(vidx == arr.length){
            
            if(OR == max){
                ct ++;
            }else if(OR > max){
                ct = 1;
                max = OR;
            }
            
            return;
        }
        
        subsets(arr, vidx+1, OR | arr[vidx]);
        
        subsets(arr, vidx+1, OR);
    }
}