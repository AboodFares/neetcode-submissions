class Solution {

    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        dfs(digits, 0, "");
        return res;
        

        
    }

    public void dfs(String digits, int i, String cur) {

         if (i == digits.length()) {
            res.add(cur);
            return;}
        

            String letters = map[digits.charAt(i) - '0'];

        for (int j = 0; j < letters.length(); j++) {
            dfs(digits, i + 1, cur + letters.charAt(j));   // pass a new string
        }

    }
}
/*
take the first number
dfs keep adding each of the first letters of digists until sub == digits.length

dfs
keep going 
add to sub
when sub == digits.length
return
remove
*/