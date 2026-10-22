class Solution {
    int count = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int max = 0;
        

        boolean[][] visited = new boolean[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                count = 0;
                DFS(grid, i, j, visited);
                max = Math.max(max, count);
            }
        }
        return max;
    }
    public void DFS(int[][] grid, int r, int c, boolean[][] visited) {

        int ROWS = grid.length;
        int COLS = grid[0].length;
        if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == 0 || visited[r][c]) return;
        visited[r][c] = true;
        count++;
        DFS(grid, r + 1, c, visited);  
        DFS(grid, r - 1, c, visited);   
        DFS(grid, r, c + 1, visited);
        DFS(grid, r, c - 1, visited);
        
    }
}
// keep track of count Math.max