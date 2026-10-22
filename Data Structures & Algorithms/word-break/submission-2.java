class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) { // from that ind to the last true dp
            for (String w: wordDict) { // compares every word in list
              int end = i + w.length();  
              if (end > n) continue; 

            String split = s.substring(i,end);
            if (split.equals(w) && dp[end]) {
                dp[i] = true;
                break;
            }


            }// substring(from ind, to ind), substring[i,last true]
        }
        return dp[0];
        
    }
}
/*
apple pen apple
apple, pen, ape

neetcode,    neet,code      use dp[]

dp[8] = true;
dp[7] = false; i = 7; cut from there we have e, is it int worddict? no, false
dp[6] = false; i = 6; cut, de, in W, no, false
dp[5] = false; i = 5; cut, ode, in W, no, false
dp[4] = true (code); cur, code, in W, yes, true
dp[3] = dp[2] = dp[1] = false
dp[0] = true; neet; cut from this ind to the last true ind

if ind 0 = true then true


how to solve any dp?

    What does dp[i] mean?
    What are my choices at i?
    Where does each choice land? → that's the dp you check
    Combine: +, min, max, or OR
    Base case: nothing left
    Loop direction: fill what you depend on first

    + → count the ways
    min → cheapest / fewest
    max → most / longest
    OR → is it possible at all (true/false)
*/