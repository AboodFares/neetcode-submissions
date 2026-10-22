class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // decide what it will store before creting one

        PriorityQueue<int[]> minH = new PriorityQueue<>( (a,b) -> a[0] - b[0]);
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        boolean[] visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {  map.put(i, new ArrayList<>()); }
        for (int[] t : times) {   map.get(t[0]).add(new int[]{t[1], t[2]}); }

        minH.add(new int[]{0, k});
        int count = 0;
        int time = 0;

        while (!minH.isEmpty()) {

                int[] curr = minH.poll();
                int dis = curr[0];
                int node = curr[1];

                if (visit[node]) continue; // in dijkstra visit when polling
                visit[node] = true;
                count++;
                time = dis;


                for (int[] road: map.get(node)) { // adds all the nei into the heap
                int sumD = dis + road[1];
                int nei = road[0];
                if (!visit[nei]) {
                    minH.add(new int[]{sumD, nei});
                }
                
                }
            }

            return count == n ? time : -1;

        }

        /*

        take the first heap
            checks that polled minH nei
            add all its neighbors to the minH

        */
    
    }

/*
if the signal starts from a node that has no arrow pointing itno it then good

always choose the road that is shortest from the start not in that specific edge

create, minH, hashset visit
then bfs

*/