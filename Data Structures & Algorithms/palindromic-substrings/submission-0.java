class Solution {
    public int countSubstrings(String s) {
        int n  = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            

            for (int k = 0; k < 2; k++) {
                int left = i; 
                int right = i + k;

                while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                    count++;
                }


            }
        } return count;
    }
}
/*

start searchin index by index
left and right indices
every letter is a palindrom
so count every letter plus the letters next to it




*/