# 1497. Check If Array Pairs Are Divisible by k
# Difficulty: Medium
# Topics: Array, Hash Table, Counting

class Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        f = [0] * k
        
        for num in arr:
            r = (num % k + k) % k
            f[r] += 1
        
        if f[0] % 2 != 0:  
            return False
        
        for i in range(1, k // 2 + 1):
            if f[i] != f[k - i]:  
                return False
        
        return True