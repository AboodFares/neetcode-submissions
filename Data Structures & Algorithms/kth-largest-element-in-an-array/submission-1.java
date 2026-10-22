class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> qp = new PriorityQueue<>();

        for(int n: nums) {
            qp.add(n);
            if (qp.size() > k) qp.poll();
        }
        return qp.peek();
        
        
    }
}
