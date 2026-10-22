class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minH = new PriorityQueue<>();

        for (int card : hand) map.put(card, map.getOrDefault(card, 0) + 1);
        for (int n : map.keySet()) minH.add(n);

        while (!minH.isEmpty()) {
            int first = minH.peek(); // smallest card → a group must start here

            for (int i = first; i < first + groupSize; i++) {
                if (!map.containsKey(i)) return false;// missing card →can't make thegroup

                map.put(i, map.get(i) - 1);  // use one of this card

                if (map.get(i) == 0) {  // ran out of this card
                    if (i != minH.peek()) return false;  // it must be the smallest left
                    minH.poll();
                    map.remove(i);
                }
            }
        }
        return true;
    }
}
/*

when do we return false

create a hashmap, where you store all the values and how many times it appeared

then create a min heap with the keys

put the cards together with size group size, and each value you put you subtract the value in the hashmap, when its empty you remove it from the heap

we use heap to get the min and start with it

*/