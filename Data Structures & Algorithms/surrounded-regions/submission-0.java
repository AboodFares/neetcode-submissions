class Solution {
    public void solve(char[][] board) {

        int ROWS = board.length;
        int COLS = board[0].length;

        Queue<List<Integer>> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[ROWS][COLS];
        int[][] dir = { {1,0}, {-1,0}, {0,1}, {0,-1}};


        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (i == 0 || j == 0 || i == ROWS - 1 || j == COLS - 1){
                    if (board[i][j] == 'X') continue;
                    q.add(List.of(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<Integer> curr = q.poll();
                int r = curr.get(0);
                int c = curr.get(1);

                for(int[] d: dir) {
                    int sr = r + d[0];
                    int sc = c + d[1];
                    if (sr < 0 || sc < 0 || sr == ROWS || sc == COLS || board[sr][sc] == 'X' || visited[sr][sc]) continue;
                        visited[sr][sc] = true;
                        q.add(List.of(sr,sc));
                    
                }

            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (visited[i][j] || board[i][j] == 'X') continue;
                board[i][j] = 'X';
            }
        }

        
    }
}
/* its surrounded when its one index far from the edge

// so we define a list of boolean visited or not
// start from the edges and skip the x and keep going, visit becomes true for every O index we visit
// then change everything in the grid to x except the current x'es and visit nodes


start from the edges, keep going and travers, if 

what are the edges
    1- when we have O on the edge and no O's connected to it
    2- when we have O connected to O from the middle


first approach
    - find the o's indicies
    - use bfs, check the edge cases, keep going, if non, change it to x

    -use for loop to identify the o's indicies then store them using arraylist
    - now we go over the arraylist using loop
        - while (!q.isEmpty())
        -
*/