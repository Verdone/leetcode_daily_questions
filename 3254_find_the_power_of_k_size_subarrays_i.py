# 3254. Find the Power of K-Size Subarrays I
# Difficulty: Medium
# Topics: Array, Sliding Window

class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        res = [-1] * (n - k + 1)
        i, j = 0, 0 


        while j < n:
            if j > 0 and nums[j] - nums[j - 1] != 1: 
                i = j
            if j - i + 1 == k: 
                res[i] = nums[j]
                i += 1
            j += 1
        
        return res
             