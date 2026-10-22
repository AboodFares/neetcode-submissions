class Solution {
    public int orangesRotting(int[][] grid) {

        int ROWS = grid.length;
        int COLS = grid[0].length;
        //queue
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1, 0}};

        int fruit = 0;
        int min = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) fruit++;
                if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        //BFS

        while (!q.isEmpty() && fruit > 0) {
            int rottens = q.size();
            for (int i = 0; i < rottens; i++) {
                int[] currR = q.poll();
                int r = currR[0];// the row and the column of the rotten
                int c = currR[1];
                 for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nc < 0 || nr == ROWS || nc == COLS) continue;
                    if (grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;
                    fruit--;
                    q.add(new int[]{nr, nc});
                }

            }
            min++;


        }return fruit == 0 ? min : -1;
        
    }
}

/*

BFS
            1 2 0 1
            1 1 0 2
            0 0 1 1


1- go over the grid and count all the fruit and the rotten


*/