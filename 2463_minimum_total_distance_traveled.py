# 2463. Minimum Total Distance Traveled
# Difficulty: Hard
# Topics: Array, Dynamic Programming, Sorting

class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        
        robot.sort()
        factory.sort()
        
        m, n = len(robot), len(factory)
        
        dp = [[0]*(n+1) for _ in range(m+1)]
        
        for i in range(m): 
            dp[i][-1] = float('inf')
        
        for j in range(n-1, -1, -1):
            prefix = 0
            monotonicQueue = deque([(m, 0)])
            
            for i in range(m-1, -1, -1):
                
                prefix += abs(robot[i] - factory[j][0])
                
                if monotonicQueue[0][0] > i+factory[j][1]: 
                    monotonicQueue.popleft()
                
                while monotonicQueue and monotonicQueue[-1][1] >= dp[i][j+1] - prefix:
                    monotonicQueue.pop()
                    
                monotonicQueue.append((i, dp[i][j+1] - prefix))
                dp[i][j] = monotonicQueue[0][1] + prefix
                
        return dp[0][0]
