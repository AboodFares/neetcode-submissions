class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> QP = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for (int[] p: points) {
            int dist = p[0] * p[0] + p[1] * p[1];
            QP.add(new int[]{dist, p[0], p[1]});
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] top = QP.poll();
            res[i] = new int[]{top[1], top[2]};
        }
        return res;

        // points = [[0,2],[2,2]] -> 0,2/ 0,0
        

    }
}
/*
return the closest point to 0,0
for each point calculate the distance between the origin and the point
then add it to the min heap
then remove the min kth tims and retunr them

imp
No rule needed. Java already knows how to compare these:

Integer, Long, Double → smallest number first
String → alphabetical order (“apple” before “banana”)
Character → alphabetical order (‘a’ before ‘b’)

Rule required. Java can’t guess how to compare these:

int[] → for example, (a, b) -> a[0] - b[0]
List<Integer> → you decide what to compare
your own class, like Node or Point → for example, (a, b) -> a.dist - b.dist

The ones you’ll actually use in interviews:

PriorityQueue<Integer>: most heap problems
PriorityQueue<int[]>: when you need to store a value with extra info, like [distance, x, y] or [distance, node]
*/