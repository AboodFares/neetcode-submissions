class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int count = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {   // new island found
                    count++;
                    dfs(grid, r, c, visited);                // mark the whole island
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] visited) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS
                || grid[r][c] == '0' || visited[r][c]) return;   // stop

        visited[r][c] = true;                                    // mark BEFORE calls

        dfs(grid, r + 1, c, visited);   // down
        dfs(grid, r - 1, c, visited);   // up
        dfs(grid, r, c + 1, visited);   // right
        dfs(grid, r, c - 1, visited);   // left
        // no undo: each cell is visited once
    }
}
/*
every possible path --->>> backtracking


 main method --->> use nested loop to go over each node
                   if zero or visited then skip
                   if 1 not visited then run dfs


dfs method(helper)

edge cases
    1- if index = 0(did that in main method)
    2- check ROWS and COLS, avoiding out of boundry
    3- if visited (a boolean array true or false) (did that in main method)

Formula
    before recursion
        1- visited[r][c] = true;
    after recursion
        1- remove

*/