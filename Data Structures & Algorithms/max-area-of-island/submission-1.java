class Solution {

      int rows, cols;
    boolean[][] visited;
    int count;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        int max = 0;



        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    count = 0;
                    dfs(grid, r, c);
                    max = Math.max(max, count);

                }
                
                

            }

        }
        return max;

    }

    public void dfs(int[][] cell, int r, int c) {

        if (r < 0 || c < 0 || r == rows || c == cols || visited[r][c] ||
         cell[r][c] == 0) return;

         visited[r][c] = true;
         count++;


        dfs(cell, r + 1, c);
        dfs(cell, r - 1, c);
        dfs(cell, r, c + 1);
        dfs(cell, r, c - 1);

    }
}
/*
search each index one by one
visit each cell


*/