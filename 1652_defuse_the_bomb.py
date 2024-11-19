# 1652. Defuse the Bomb
# Difficulty: Easy
# Topics: Array, Sliding Window

class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        n=len(code)
        ans=[0]*n
        if k==0: return ans
        sgn=-1
        if k>0:
            sgn=1
        else:
            k=-k
        ans[0]=wsum=sum(code[sgn:sgn*(k+1):sgn])
        for l in range(1, n):
            r=(l+k)%n
            wsum+=-code[sgn*l]+code[sgn*r]
            ans[sgn*l]=wsum
        return ans