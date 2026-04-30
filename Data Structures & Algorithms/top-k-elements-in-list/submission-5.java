class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // create buckets
        List<Integer>[] freq = new List[nums.length + 1];
        // initialize the buckets
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        // fill the buckets
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        // find the element with k most frequency
        // int[] result = new int[k];
        // int index = 0;
        // for (int i = freq.length - 1; i > 0 && index < k; i--) {
        //     for (int n : freq[i]) {
        //         result[index++] = n;
        //         if (index == k) return result;
        //     }
        // }
        // return result;
        int[] result = new int[k];
        int index = 0;
        for (int i = freq.length-1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                result[index++] = n;
                if (index == k) return result;
            }
        }
        return result;
    }
}
