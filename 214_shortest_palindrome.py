# 214. Shortest Palindrome
# Difficulty: Hard
# Topics: KMP Algorithm, Arrays, String, String Matching

class Solution:
    def shortestPalindrome(self, s: str) -> str:
        count = self.kmp(s[::-1], s)
        return s[count:][::-1] + s
    def kmp(self, txt: str, patt: str) -> int:
        temp = patt + '#' + txt
        pi = [0] * len(temp)
        i = 1
        k = 0
        while i < len(temp):
            if temp[i] == temp[k]:
                k += 1
                pi[i] = k
                i += 1
            else:
                if k > 0:
                    k = pi[k - 1]
                else:
                    pi[i] = 0
                    i += 1
        return pi[-1]