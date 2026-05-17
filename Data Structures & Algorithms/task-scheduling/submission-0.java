class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) count[c - 'A']++;

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count) if (c > 0) heap.add(c);

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;
        while (!heap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++;
            if (heap.isEmpty()) {
                time = cooldownQueue.peek()[1];
            } else {
                int cnt = heap.poll() - 1;
                if (cnt > 0) {
                    cooldownQueue.add(new int[]{cnt, time + n});
                }
            }

            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                heap.add(cooldownQueue.poll()[0]);
            }
        }
        
        return time;
    }
}
