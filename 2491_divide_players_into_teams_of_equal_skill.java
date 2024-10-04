// 2491. Divide Players Into Teams of Equal Skill
// Difficulty: Medium
// Topics: Array, Hash Table, Two Pointers, Sorting

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long t = 0, c = 0;
        for (int x : skill) t += x;
        t /= (skill.length / 2);
        int i = 0, j = skill.length - 1;
        while (i < j) {
            if (skill[i] + skill[j] != t) return -1;
            c += (long) skill[i] * skill[j];
            i++;
            j--;
        }
        return c;
    }
}