class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            int[] count = new int[26];
            for (int k: s.toCharArray()) {
                count[k - 'a']++;
            }

            String key = Arrays.toString(count);

            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
        
    }
}
/*

for each string, make a loop that stores all the letters in an array of size 26, store them by incrementing one in the array in the index that equivelant to the number

and then in the nested loop you compare the rest of the array with thatarray, you compare them by checking the number in that array 


*/