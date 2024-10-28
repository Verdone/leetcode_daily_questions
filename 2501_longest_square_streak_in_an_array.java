// 2501. Longest Square Streak in an Array
// Difficulty: Medium
// Topics: Array, Set, Sorting

public class Solution {
    public int longestSquareStreak(int[] nums) {
        int max = -1;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        List<Integer> sArr = new ArrayList<>(s);
        Collections.sort(sArr);
        
        for (int i = 0; i < sArr.size(); i++) {
            int curr = sArr.get(i);
            int ct = 0;
            
            while (s.contains(curr)) {
                s.remove(curr);
                curr = curr * curr;
                ct++;
            }
            
            max = Math.max(max, ct);
        }
        
        return max > 1 ? max : -1;
    }
}