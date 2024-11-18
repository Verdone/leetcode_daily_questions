# 862. Shortest Subarray with Sum at Least K
# Difficulty: Hard
# Topics: Array, Binary Search, Queue, Sliding Window

class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        shortest = float('inf')
        q = deque([])
        t = currLen = 0
        
        for i, n in enumerate(nums):
            if n < 0:
                
                if t + n <= 0:
                    q = deque([])
                    t = currLen = 0
                    continue
                else:
                    removed, removeLen = q.pop()
                    curr = n + removed
                    stackLength = 1 + removeLen
                    
                    while q and curr < 0:
                        removed, removeLen = q.pop()
                        curr += removed
                        stackLength += removeLen
                    
                    t += n
                    q.append((curr, stackLength))
                    currLen += 1
            else:
                q.append((n, 1))
                t += n
                currLen += 1
            
            while q and t >= k:
                shortest = min(shortest, currLen)
                removed, removeLen = q.popleft()
                t -= removed
                currLen -= removeLen
        
        return shortest if shortest <= len(nums) else -1