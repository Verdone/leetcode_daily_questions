// 539. Minimum Time Difference
// Difficulty: Medium
// Topics: Array, Math, String, Sorting

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        int result = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            String str = timePoints.get(i);
            String hrStr = str.substring(0,2);
            String minStr = str.substring(3);

            int hourInt = Integer.parseInt(hrStr);
            int minInt = Integer.parseInt(minStr);

            minutes[i] = (hourInt * 60) + minInt;
        }

        Arrays.sort(minutes);
        for(int i=1;i<n;i++) result = Math.min(result,minutes[i] - minutes[i-1]);

        return Math.min(result,(24*60 - minutes[n-1])+minutes[0]);
    }
}