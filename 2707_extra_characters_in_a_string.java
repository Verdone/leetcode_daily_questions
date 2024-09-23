// 2707. Extra Characters in a String
// Difficulty: Medium
// Topics: Array, DP, Hash Table, Trie

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        
        for (String word : dictionary) set.add(word); 
        
        int[] dp = new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        return split(s, 0, dp, set);
    }
    
    private int split(String s, int index, int[] dp, Set<String> dictionary) {
        if (index >= s.length()) return 0;
        
        if (dictionary.contains(s.substring(index, s.length()))) return 0;
        
        if (dp[index] != Integer.MAX_VALUE) return dp[index];
        
        int min = s.length() - index;

        for (int i = index + 1; i <= s.length(); i++) {
            int count = dictionary.contains(s.substring(index, i)) ? 0 : i - index;
            count += split(s, i, dp, dictionary);
            min = Math.min(min, count);
        }
        
        dp[index] = min;
        return min;
    }
}