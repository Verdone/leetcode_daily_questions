# 2364. Count Number of Bad Pairs
# Difficulty: Medium
# Topics: Array, Math

class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        freq = {}
        good = 0

        for i, num in enumerate(nums):
            key = num - i
            good += freq.get(key, 0)
            freq[key] = freq.get(key, 0) + 1

        n = len(nums)
        return (n * (n - 1)) // 2 - good