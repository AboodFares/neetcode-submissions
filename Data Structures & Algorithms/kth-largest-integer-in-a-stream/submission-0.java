class KthLargest {
    PriorityQueue<Integer> minH = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n: nums) add(n);
    }
    
    public int add(int val) {
        minH.add(val);
        if (minH.size() > k) minH.poll(); 
        return minH.peek();
    }
}
/*



*/