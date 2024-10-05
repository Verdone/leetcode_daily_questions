// 567. Permutation in String
// Difficulty: Medium
// Topics: Hash Table, Two Pointers, Sliding Window

class Solution {

    int[] c1 = new int[26];
    int[] c2 = new int[26];

    public boolean eqP() {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();

        for (int i = 0; i < 26; i++) {
            c1[i] = 0;
            c2[i] = 0;
        }

        for (int i = 0; i < n1; i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        if (eqP()) {
            return true;
        }

        for (int i = n1; i < n2; i++) {
            c2[s2.charAt(i) - 'a']++;
            c2[s2.charAt(i - n1) - 'a']--;
            if (eqP()) {
                return true;
            }
        }

        return false;
    }
}
