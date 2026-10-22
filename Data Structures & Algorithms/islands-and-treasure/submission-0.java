class Solution {
    public void islandsAndTreasure(int[][] grid) {

        
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        int ROWS = grid.length;
        int COLS = grid[0].length;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0]; int c = curr[1];
                
                for(int[] d: dir) {
                    int sr = r+d[0]; int cr = c+d[1];
                    if (sr < 0 || cr < 0 || sr >= ROWS ||
                     cr >= COLS ||grid[sr][cr] == -1) continue;
                    if (grid[sr][cr] != Integer.MAX_VALUE) continue;
                    grid[sr][cr] = grid[r][c] + 1;
                    q.add(new int[]{sr, cr});


                }
                
            }


            

        }

    }


}
/*

-1 -> block
0 -> treasure
INF -> land

BFS

we use for loop to track all the tresure land directions

then use BFS
edge cases
    return if -1, 


*/
