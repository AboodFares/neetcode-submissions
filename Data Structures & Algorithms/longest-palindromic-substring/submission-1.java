class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
        int bestStart = 0, bestLen = 0;
        

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < 2; k++) {
                int right = i + k;
                int left = i;
                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                
                int len = right - left -1;
                if (len > bestLen) {
                    bestLen = len;
                    bestStart = left + 1;
                }
            }
            
        }
         return s.substring(bestStart, bestStart + bestLen);
        
    }
}
// palindromes substring: if we write it in revers order its the same
/*
start searchin index by index
make two pointers left and right of the curr index i
expand them if they are a match
stop when its out of bound or not match
O(n.n), O(1)
use subtract(i,n) to return the output
*/