# 1726. Tuple with Same Product
# Difficulty: Medium
# Topics: Array, Hash Table, Counting

class Solution:
    def tupleSameProduct(self, nums: List[int]) -> int:

        ans = 0
        ct = collections.Counter()

        for i in range(len(nums)):
            for j in range(i):
                prod = nums[i] * nums[j]
                ans += ct[prod] * 8
                ct[prod] += 1

        return ans