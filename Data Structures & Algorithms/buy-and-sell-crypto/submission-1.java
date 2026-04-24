class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, maxp = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxp = Math.max(maxp, profit);
            } else l = r;
            r++;
        }
        return maxp;
    }
}
