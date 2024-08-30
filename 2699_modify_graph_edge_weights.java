// 2699. Modify Graph Edge Weights
// Difficulty: Hard

class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int A = edges[i][0], B = edges[i][1];
            adj.get(A).add(new Pair(B, i));
            adj.get(B).add(new Pair(A, i));
        }

        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            dist[i][0] = dist[i][1] = Integer.MAX_VALUE;
        }

        dist[source][0] = dist[source][1] = 0;

        dijkstras(adj, edges, dist, source, 0, 0);

        int difference = target - dist[destination][0];
        if (difference < 0) return new int[][]{};

        dijkstras(adj, edges, dist, source, difference, 1);

        if (dist[destination][1] < target) return new int[][]{};

        for (int[] edge : edges) {
            if (edge[2] == -1) edge[2] = 1;
        }

        return edges;
    }

    static void dijkstras(List<List<Pair>> adj, int[][] edges, int[][] dist, int source, int difference, int run) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        queue.add(new Pair(source, 0));
        dist[source][run] = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentNode = current.dest;
            int currentDistance = current.weight;

            if (currentDistance > dist[currentNode][run]) continue;

            for (Pair neighbor : adj.get(currentNode)) {
                int nextNode = neighbor.dest;
                int edgeIndex = neighbor.weight;
                int weight = edges[edgeIndex][2];

                if (weight == -1) weight = 1;

                if (run == 1 && edges[edgeIndex][2] == -1) {
                    int newWeight = difference + dist[nextNode][0] - dist[currentNode][1];
                    if (newWeight > weight) {
                        edges[edgeIndex][2] = weight = newWeight;
                    }
                }

                if (dist[nextNode][run] > dist[currentNode][run] + weight) {
                    dist[nextNode][run] = dist[currentNode][run] + weight;
                    queue.add(new Pair(nextNode, dist[nextNode][run]));
                }
            }
        }
    }

    static class Pair {
        int dest;
        int weight;
        Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}