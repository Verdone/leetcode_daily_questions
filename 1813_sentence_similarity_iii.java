// 1813. Sentence Similarity III
// Difficulty: Medium
// Topics: Array, Two Pointers, Lists

class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        List<String> l1 = Arrays.asList(s1.split(" "));
        List<String> l2 = Arrays.asList(s2.split(" "));
        int i = 0, j = 0, n1 = l1.size(), n2 = l2.size();
        while (i < n1 && i < n2 && l1.get(i).equals(l2.get(i))) ++i;
        while (j < n1 - i && j < n2 - i && l1.get(n1 - 1 - j).equals(l2.get(n2 - 1 - j))) ++j;
        return i + j == n1 || i + j == n2;
    }
}