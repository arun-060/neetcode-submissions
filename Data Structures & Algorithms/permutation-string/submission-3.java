class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count_s1 = new int[26];
        int[] count_s2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count_s1[s1.charAt(i) - 'a']++;
            count_s2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (count_s1[i] == count_s2[i]) matches++;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) return true;

            int index = s2.charAt(r) - 'a';
            count_s2[index]++;
            if (count_s1[index] == count_s2[index]) matches++;
            else if (count_s1[index] + 1 == count_s2[index]) matches--;

            index = s2.charAt(l) - 'a';
            count_s2[index]--;
            if (count_s1[index] == count_s2[index]) matches++;
            else if (count_s1[index] - 1 == count_s2[index]) matches--;

            l++;
        }
        return matches == 26;
    }
}
