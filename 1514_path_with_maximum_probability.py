# 1514. Path with Maximum Probability
# Difficulty: Medium

class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start_node: int, end_node: int) -> float:
        
        # Construct the graph with a dict as the underlying data structure
        graph = collections.defaultdict(dict)

        for (source, dest), prob in zip(edges, succProb):
            graph[source][dest] = prob
            graph[dest][source] = prob

        heap = [] # Note that python doesn't have max heaps by default so we use min heaps with negative values
        heapq.heapify(heap)
        heapq.heappush(heap, (-1, start_node))  # Start with probability 1 (pushed as -1 for max-heap behavior)

        # Using Dijkstra's (greedy algorithm,) but instead of finding the shortest path we're finding the maximum probability
        visited = set()

        while heap:
            node_prob, node = heapq.heappop(heap)
            node_prob = -node_prob  # Convert back to positive probability
            if node == end_node:
                return node_prob

            visited.add(node)

            for child in graph[node]:
                if child not in visited:
                    heapq.heappush(heap, (-node_prob * graph[node][child], child))

        # If, for any reason, no path was found, return 0 as the maximum probability
        return 0.0