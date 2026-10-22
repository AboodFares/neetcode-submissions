class Solution {
    public int maxArea(int[] heights) {

        if (heights.length == 1 || heights.length == 0) return 0;

        int size = heights.length;

        int left = 0;
        int right = size - 1;
        int max = 0;

        while (left < right) {// 1, 1

            int formula = (right-left) * Math.min(heights[left], heights[right]);
            
            if (heights[left] > heights[right]) {
                right--;
            } else  
                left++;
            
            
            max = Math.max(max, formula);
        }
        return max;
        
    }
}
/*

heights and width 
return the height(min) of the two bars * width 

    two pointers
    calculate then add it to a max (ofc after taking the min height)
    move the smaller height
    and then take teh max of that var after comparing(this step and var)

    return var

    would give us O(n), space O(1)



[1,7]





*/