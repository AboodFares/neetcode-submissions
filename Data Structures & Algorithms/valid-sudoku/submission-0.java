class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char ch = board[r][c];
                if (ch == '.') continue;

                int box = (r / 3) * 3 + (c / 3); // how to know which box


                if ( !seen.add( ch + " is in row " + r) ||
                !seen.add(ch + " is in col " + c)
                || !seen.add(ch + " is in box " + box)) return false;
                
               
                
            }
        }
        return true;
        
    }
}
/*

valid if        you are given 9x9 grid
    - each row, no dup
    - same for each column
    - same for the 3X3 boxes

    return true if passes

brute force solution,
    check row after row
    same for columns,
    same for boxes

    that would give us n squared

optimal


fill hashset with all t
*/