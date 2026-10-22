class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int ROWS = heights.length;
        int COLS =  heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];
        List<List<Integer>> result = new ArrayList<>();


        for (int c = 0; c < COLS; c++) {
            DFS(heights, 0, c, pac, heights[0][c]);
            DFS(heights, ROWS - 1, c, atl, heights[ROWS - 1][c]);
        }
        for (int r = 0; r < ROWS; r++) {
            DFS(heights, r, 0, pac, heights[r][0]);
            DFS(heights, r, COLS - 1, atl, heights[r][COLS - 1]);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c])
                    result.add(List.of(r,c));
            }
        }

        return result;
    }

    public void DFS(int[][] H, int r, int c, boolean[][] visit, int prev) {

        int ROWS = H.length;
        int COLS =  H[0].length;

        if (r < 0 || c < 0|| r == ROWS || c == COLS || visit[r][c] ||
        prev > H[r][c]) return;

        visit[r][c] = true;

        DFS(H, r + 1, c, visit, H[r][c]);
        DFS(H, r - 1, c, visit, H[r][c]);
        DFS(H, r, c + 1, visit, H[r][c]);
        DFS(H, r, c - 1, visit, H[r][c]);

    }
}
/* flow horizontly and vertaclly, if curr cell >= nei cell ->

we start from the top and check every cell, use DFS
we start from the bottom and check every cell, use DFS

if cell is bigger than the prev one, add it to the list(good);
if not then ignore
do the same steps for the bottom

then if the directions of the index are in the bottom and the top list then return it
(add it in another array list)

*/