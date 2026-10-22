class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 2];                   // dp[n+1] stays 0
        dp[n] = 1;                                   // reached the end = 1 finished way

        for (int i = n - 1; i >= 0; i--) {           // right to left, like Climbing Stairs
            // choice 1: take ONE digit (valid if it's not '0')
            if (s.charAt(i) != '0') {
                dp[i] += dp[i + 1];
            }

            // choice 2: take TWO digits (they must exist and be 10..26)
            if (i + 1 < n) {
                int two = Integer.parseInt(s.substring(i, i + 2));
                if (two >= 10 && two <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
/*

At each i, start with dp[i] = 0, then:

If s[i] isn’t '0' → dp[i] += dp[i + 1] (take 1 digit)
If there are 2 digits left and they’re 10 to 26 → dp[i] += dp[i + 2] (take 2 digits)





number, return the num of ways to decode it, from 1-26


12 1,2 or 12 num of ways two
123
    1,2,3 || 12,3 ||1,23
12034
    dp[6] = 1
    dp[5] = 1
    dp[4] = dp[i+2] not in between i and i+1
    dp[3] 
when its zero && when its 26 and above
when there is a zero it must be taken with the left digit

we can take one or two numbers

1226 -> 1,2,2,6 -> 12,26 ->12,2,6 -> 1,2,26 -> 4

if (10 <= 26)

dp[4] = 1;
dp[3] = dp[4]
dp[2] = dp[4] + dp[3] = 2
dp[1] = dp[3] + dp[2] = 3
dp[0] = dp[2] + dp[1] = 4

if 0 then dp[i] = dp[i-1]
1203
dp[4] = 1
dp[3] = 1
dp[2] = dp[i-1]
dp[1] = 


if ()

there is an - edge where there is zero in s
            - when its greater than 26

            add two dig if between if (10 <= 26)
*/