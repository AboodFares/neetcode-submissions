class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] need = new int[26];
        int[] have = new int[26];
        int k = s1.length();

        for (int i = 0; i < k; i++) {
            need[s1.charAt(i) - 'a']++;
            have[s2.charAt(i) - 'a']++;
        }
         if (Arrays.equals(need, have)) return true;

        for (int i = k; i < s2.length(); i++) {
            have[s2.charAt(i) - 'a']++;            // add new letter on the right
            have[s2.charAt(i - k) - 'a']--;        // remove letter that left on the left
            if (Arrays.equals(need, have)) return true;
        }
        return false;
    }
}
/*
OPTIMAL
use the array of int 26, store the number of the char there, increment one in that array for that char

then go over hte s2 and check, 


BRUTE FORCE
how can i know if contains permutation

take each char in s1, then point it to the same char in String, then check if they are contingous

put s1 in hashmap, then left and right pointer , keep extending the right by keep cchecking if its already in a hashmap, when left - right = s1.length then yes
but there is a problem, what if there is a duplicates, maybe we delete from the hashmap

instead of using hashmap, we can go over the s1 and then check if it contains, then delete and then extend until s1 length is zero or better left - right == s1.length (the og)
if we wanna keeep searching in the string thats alot of time

*/