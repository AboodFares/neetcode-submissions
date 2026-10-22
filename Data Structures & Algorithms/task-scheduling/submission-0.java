class Solution {
    public int leastInterval(char[] tasks, int n) {

        // count how many times each task shows up
        HashMap<Character, Integer> map = new HashMap<>();
        for (char k : tasks)
            map.put(k, map.getOrDefault(k, 0) + 1);

        // qp = ready tasks, gives back the most frequent first
        PriorityQueue<Integer> qp = new PriorityQueue<>((a, b) -> b - a);
        for (int k : map.values()) qp.add(k);

        // q = cooling tasks → [count left, time it's ready again]
        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;

        // keep going while something is ready OR cooling
        while (!q.isEmpty() || !qp.isEmpty()) {

            time++;   // one tick passes

            // pop the most frequent from qp, run it once (subtract one)
            if (!qp.isEmpty()) {
                int c = qp.poll() - 1;
                // still has copies → add it to q, wait n before doing it again
                if (c > 0) q.offer(new int[]{c, time + n});
            }
            // if qp is empty here → idle tick, nothing runs

            // front of q finished cooling → back to qp
            if (!q.isEmpty() && q.peek()[1] == time) {
                qp.offer(q.poll()[0]);
            }
        }

        return time;
    }
}