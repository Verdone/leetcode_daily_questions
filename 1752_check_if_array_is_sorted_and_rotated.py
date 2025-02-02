# 1752. Check if Array Is Sorted and Rotated
# Difficulty: Easy
# Topic: Array

class Solution:
    def check(self, nums: List[int]) -> bool:
        count = 0
        n = len(nums)
        
        for i in range(n):
            if nums[i] > nums[(i + 1) % n]:
                count += 1
            if count > 1:
                return False
        
        return True