# 3151. Special Array I
# Difficulty: Easy
# Topic: Array

class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        for i in range(1, len(nums)):
            if nums[i-1]%2==nums[i]%2:
                return False
        
        return True