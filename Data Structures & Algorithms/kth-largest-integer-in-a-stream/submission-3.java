class KthLargest {

    // create minHeap
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        // initialize the minHeap
        this.minHeap = new PriorityQueue<>();
        // populate the heap and make sure the length is not greater than k
        // if the size exceeded k remove the smallest element that is the root 
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        // add the new element in the heap
        // if the size exceeded k remove the root that is smallest element
        // return the root i.e. the kth smallest element 
        minHeap.offer(val);
        if (minHeap.size() > k){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
