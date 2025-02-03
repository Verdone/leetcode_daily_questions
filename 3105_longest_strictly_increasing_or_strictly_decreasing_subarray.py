# 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
# Difficulty: Easy
# Topic: Array

class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        l1, l2 = 0, 0
        maxLen = 1
        for r in range(1, len(nums)):
            if nums[r] <= nums[r - 1]:
                l1 = r
            if nums[r] >= nums[r - 1]:
                l2 = r
            maxLen = max(maxLen, r - l1 + 1, r - l2 + 1)
        return maxLen
        