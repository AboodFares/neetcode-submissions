class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length -1;

        while (left < right){
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else
            if (numbers[left] + numbers[right] > target) {
                right--;
            } 
            

        }
        return new int[]{};

            
        

        
    }
}
/*

[1,2] 3

opposite ends

if equal, return the two integers we added
if smaller, move the right element
if larger move the first element

*/