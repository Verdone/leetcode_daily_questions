# 2516. Take K of Each Character From Left and Right
# Difficulty: Medium
# Topics: Sliding Window, String

class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        n = len(s)
        ans = n
        a, b, c = 0, 0, 0
        l, r = 0, 0

        totalA, totalB, totalC = s.count('a'), s.count('b'), s.count('c')

        if totalA < k or totalB < k or totalC < k:
            return -1

        while r < n:
            if s[r] == 'a': a += 1
            if s[r] == 'b': b += 1
            if s[r] == 'c': c += 1
            r += 1

            while a > totalA - k or b > totalB - k or c > totalC - k:
                if s[l] == 'a': a -= 1
                if s[l] == 'b': b -= 1
                if s[l] == 'c': c -= 1
                l += 1

            ans = min(ans, n - (r - l))

        return ans