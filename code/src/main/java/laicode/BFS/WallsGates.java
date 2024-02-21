package laicode.BFS;

import java.util.*;

public class WallsGates {
    // Define directions for exploring adjacent cells
    private static final int INF = 2147483647;
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int[][] wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return rooms;
        }


        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize the queue with all gates
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Step 2: BFS from the gates
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check bounds and if it's an empty room
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == INF) {
                    rooms[newRow][newCol] = rooms[row][col] + 1; // Update distance
                    queue.offer(new int[]{newRow, newCol}); // Add to queue for further exploration
                }
            }
        }
        return rooms;
    }



    public static void main(String[] args){
        int[][] rooms = {
                {INF,-1,0,INF},
                {INF,INF,INF,-1},
            {INF,-1, INF, -1},
            {0,-1,INF,INF}
        };
        int[][] res = wallsAndGates(rooms);
        for(int i = 0;i<4;i++){
            for(int j = 0;j<4;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }


    }
}
