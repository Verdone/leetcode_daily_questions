# 1790. Check if One String Swap Can Make Strings Equal
# Difficulty: Easy
# Topics: Hash Table, String, Counting

class Solution(object):
    def areAlmostEqual(self, s1, s2):
        i=-1
        j=-1
        ct=0
        for k in range(0, len(s1)):
            if s1[k]!=s2[k]:
                ct+=1
                if i==-1: i=k
                elif j==-1: j=k
        
        if ct==0: return True
        elif ct==2 and s1[i]==s2[j] and s1[j]==s2[i]: return True

        return False