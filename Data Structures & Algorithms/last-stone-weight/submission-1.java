class Solution {
    public int lastStoneWeight(int[] stones) {

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int s:stones){
              pq.add(s);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (y != x) {
                pq.add(y-x);
            }
        }
        if (pq.isEmpty()) return 0;
        return pq.peek();

          

        
        
    }
}
/*



*/