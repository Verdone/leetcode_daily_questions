// 632. Smallest Range Covering Elements from K Lists
// Difficulty: Hard
// Topics: Array, Sorting

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        List<int[]> oList = new ArrayList<>();

        for (int k = 0; k < nums.size(); ++k) {
            for (int n : nums.get(k)) {
                oList.add(new int[]{n, k});
            }
        }

        Collections.sort(oList, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0, k = 0;

        int[] ans = new int[0];
        Map<Integer, Integer> ct = new HashMap<>();

        for (int j = 0; j < oList.size(); ++j) {
            if (ct.getOrDefault(oList.get(j)[1], 0) == 0) ++k;
            ct.put(oList.get(j)[1], ct.getOrDefault(oList.get(j)[1], 0) + 1);

            if (k == nums.size()) {

                while (ct.get(oList.get(i)[1]) > 1) {
                    ct.put(oList.get(i)[1], ct.get(oList.get(i)[1]) - 1);
                    ++i;
                }

                if (ans.length == 0 || ans[1] - ans[0] > oList.get(j)[0] - oList.get(i)[0]) {
                    ans = new int[]{oList.get(i)[0], oList.get(j)[0]};
                }
            }
        }

        return ans;
    }
}