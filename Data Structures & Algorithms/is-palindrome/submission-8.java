class Solution {
    public boolean isPalindrome(String s) {
        String word ="";
        for(int i=0; i<s.length(); i++){
            if (Character.isLetterOrDigit(s.charAt(i)))
            word += Character.toLowerCase(s.charAt(i));
        }
        
        int left = 0;
        int right = word.length() -1;
        
        while(left < right){
            if( word.charAt(left) != word.charAt(right) )
            return false;
            right--;
            left++;
        }
           
        return true;
        
    }
}
//create a string with now spaces
//now use the two pointers strategy how?
//we need a loop with first and last compare them