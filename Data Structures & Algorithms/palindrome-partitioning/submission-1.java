class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>(), 0);
        return res;
        
    }

    public void dfs(String s, List<String> sub, int start) {
        if (start == s.length()) {      // nothing left to cut------IMP--------
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String piece = s.substring(start, i+1); //piece from start to i
            if (!ispalindrome(piece)) continue;
            sub.add(piece);
            dfs(s, sub, i + 1);
            sub.remove(sub.size() - 1);
        }

    }

    public boolean ispalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (right > left) {
            if (s.charAt(right) != s.charAt(left)) return false;
                left++;
                right--;
        }
        return true;
    }
}

/*
how loop and recurstion works together here
so each i goes to the second branche, and the dfs just goes deeper in that branche i =0


how to know if its a backtracking
Look for these 3 signs:

“Return ALL possible ...” → you need every answer, not just a count or the best one
Each answer is a group built from choices → a list of pieces, numbers, or letters
Small input → n ≤ ~20, because backtracking is slow, so they keep n small

Read what they want back:

“Return all ...” / a list of combinations, subsets, paths → Backtracking
“How many ways ...” → DP
“Minimum / maximum ...” → DP (or greedy)
“Is it possible ...?” (true/false) → DP (or greedy)

Double-check with n:

n ≤ ~20 → backtracking is okay
n in the thousands → it must be DP or something faster




                    a           a               b
                /   |   \      skip             /    |   \
            a,a    a,a  a,b                 b,a     skip    b,b
            |      sk       |               |                   |


*/
