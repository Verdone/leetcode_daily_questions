// 3043. Find the Length of the Longest Common Prefix
// Difficulty: Medium
// Topics: Array, Hash Table, Trie

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        HashSet<String> h = new HashSet<>();
        for(int i = 0; i < n; i++){
            int l = arr1[i];
            String s = Integer.toString(l);
            for(int j = 0; j < s.length(); j++){
                h.add(s.substring(0, j + 1));
            }
        }
        int sz = 0;
        for(int i = 0; i < m; i++){
            int l = arr2[i];
            String s = Integer.toString(l);
            for(int j = 0; j < s.length(); j++){
                String u = s.substring(0, j + 1);
                if(h.contains(u)){
                    if(sz < u.length()){
                        sz = u.length();
                    }
                }
            }
        }
        return sz;
    }
}