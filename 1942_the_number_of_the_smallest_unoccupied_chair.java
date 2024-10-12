// 1942. The Number of the Smallest Unoccupied Chair
// Difficulty: Medium
// Category: Array, Heap (Priority Queue)

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        Integer[] order = new Integer[n];
        
        for (int i = 0; i < n; i++) order[i] = i;

        Arrays.sort(order, (a, b) -> Integer.compare(times[a][0], times[b][0]));

        PriorityQueue<Integer> empty = new PriorityQueue<>();
        PriorityQueue<int[]> taken = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) empty.offer(i);

        for (int i : order) {
            int arrival = times[i][0], leave = times[i][1];

            while (!taken.isEmpty() && taken.peek()[0] <= arrival) {
                empty.offer(taken.poll()[1]);
            }

            int seat = empty.poll();

            if (i == targetFriend) return seat;

            taken.offer(new int[]{leave, seat});
        }

        return -1;
    }
}