class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
if (grid[0][0] == 1) return -1;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int length = 1;
        
        

        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] dir = {{0,1}, {0,-1}, {1, 0}, {-1, 0},{1,1}, {1,-1}, {-1,1}, {-1,-1}};
        
        
        

        visited[0][0] = true;
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()) {

            int size = queue.size();
            
            for (int i = 0; i < size; i ++) {

            int[] cell = queue.poll();
            int r = cell[0]; int c = cell[1];
            if (r == ROWS - 1 && c == COLS - 1) return length;  

                for (int[] n : dir) {
                    int nr = n[0] + r; int nc = n[1] + c;
                    if (nr < 0 || nc < 0 || nr == ROWS || nc == COLS
                        || visited[nr][nc] || grid[nr][nc] == 1) continue;
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    
                }
            } length++;  // is sum dir with current r and c

        }
        return -1;

/* first for loop would let us move from index to another
 while loop --->>> return the length 
    for loop --->>> to go over each index

        for loop --->>> to check all the directions
*/


        
    }
}
/* BFS go over each index in the grid

1- check the base cases 
    if r = ROWS - 1 and c = COLS - 1. then return length
    if r < 0 || r > 0 || visited || grid[][] == 1. continue

2- how can i loop and expand the bfs
    [0,1], [0,-1], [1, 0], [-1, 0]
    for(int i = 0; )

3-  when do we pop and add to the queue
    

Traverse → "We traverse the graph from node A."
Visit → "We visit each neighbor."
Explore → "BFS explores the grid level by level."
Move to / step to → "From this cell we move to its neighbors."
Expand (BFS) → "We expand the current node and add its neighbors to the queue."
Reach → "We reach the target in 4 steps."
*/ 