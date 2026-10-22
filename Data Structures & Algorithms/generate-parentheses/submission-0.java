class Solution {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return res;
        
    }

    public void dfs(String current, int open, int close, int n) {

        if (open > n || close > open) return;

        if (open == n && close == n) {
            res.add(current);
            return;
        }
        

        dfs(current + '(', open + 1, close, n);
        dfs(current + ')', open, close + 1, n);


    }

    
}
/*

when skip
    when one of the paranthesis is greater than n
    when closing paranthesis is greater than open paranthesis

otherwise if non of teh edge cases apply, and its the leaf then return it

what we need

    - a list to return, keep adding the leafs that passes to it and then return
    - add, dfs undo
    - one dfs for the open and other for the closing
    - need a string to add and remove and return
    -


n = 1 ()
n = 2 (()), ()()
n = 3 ((())), (())(), ()()(), (()())

*/