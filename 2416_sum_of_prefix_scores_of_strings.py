# 2416. Sum of Prefix Scores of Strings
# Difficulty: Hard
# Topics: Trie, Array, String, Counting 

class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        trie = self.buildTrie(words)
        return self.calculatePrefixScores(trie, words)

    def buildTrie(self, words: List[str]) -> Dict:
        trie = {}
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
                node['$'] = node.get('$', 0) + 1
        return trie

    def calculatePrefixScores(self, trie: Dict, words: List[str]) -> List[int]:
        scores = []
        for word in words:
            node = trie
            total = 0
            for char in word:
                node = node[char]
                total += node['$']
            scores.append(total)
        return scores
