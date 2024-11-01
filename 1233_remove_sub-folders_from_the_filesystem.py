# 1233. Remove Sub-Folders from the Filesystem
# Difficulty: Medium
# Topics: Array, String, DFS, Trie

class Solution:
    def removeSubfolders(self, folder: List[str]) -> List[str]:
        folder.sort()
        a = [folder[0]]
        
        for i in range(1, len(folder)):
            last = a[-1] + '/'
            if not folder[i].startswith(last):
                a.append(folder[i])
        
        return a