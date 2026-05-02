class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (char c : set) {
            int l = 0, r = 0, count = 0;
            while (r < s.length()) {
                if (s.charAt(r) == c) count++;

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }       
                res = Math.max(res, r - l + 1);         
                r++;
            }
        }
        return res;
    }
}
