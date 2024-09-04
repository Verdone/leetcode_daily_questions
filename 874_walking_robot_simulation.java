// 874. Walking Robot Simulation
// Difficulty: Medium
// Topics: Array, Hash Table, Simulation

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        // Note that the robot can start on an obstacle and freely move away from it
        
        Set<String> obsSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obsSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int x = 0, y = 0, dir = 0;
        int maxD = 0;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int cmd : commands) {
            if (cmd == -2) {
                dir = (dir + 3) % 4;
            } else if (cmd == -1) {
                dir = (dir + 1) % 4;
            } else {
                int dx = dirs[dir][0];
                int dy = dirs[dir][1];

                for (int i = 0; i < cmd; i++) {
                    int newX = x + dx;
                    int newY = y + dy;
                    if (!obsSet.contains(newX + "," + newY)) {
                        x = newX;
                        y = newY;
                        maxD = Math.max(maxD, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }

        return maxD; // we are looking for the maximum distance among all moves
    }
}
