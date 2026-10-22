class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;

         for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) return true;   // try every cell as a start
            }
        }
        return false;
        
    }

    public boolean dfs(char[][] board, String word, int r, int c, int k) {
        int ROWS = board.length;
        int COLS = board[0].length;
        if (k == word.length()) return true;
        if (r == ROWS || c == COLS || r < 0 || c < 0) return false;
          
        if (board[r][c] != word.charAt(k)) return false;

        char temp = board[r][c];
        board[r][c] = '#';

        

        boolean found = (dfs(board, word, r + 1, c, k + 1) ||
            dfs(board, word, r - 1, c, k + 1) ||
            dfs(board, word, r, c + 1, k + 1) ||
            dfs(board, word, r, c - 1, k + 1));

            board[r][c] = temp;
            return found;
    }

}
/*

if word is in borad return tre, otherwise retunr false
    -to be in board all the letters must be connected horizentally or vertically, letter by letter

make a loop to search for every word.charAt(0), then store its directions, if no return false


four recursions for the four directions
add to it, when encounter one
remove from it and go back to try the next direction

base case
    - when board[][i] == word.charAt(0) add to the list
    else 

    make a boolean array to mark every visited node
*/
