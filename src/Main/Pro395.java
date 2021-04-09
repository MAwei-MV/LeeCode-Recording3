package Main;

import java.util.HashMap;

public class Pro395 {
    public static void main(String args[]) {
        Pro395 p = new Pro395();
        String s = "aaabb";
        p.longestSubstring(s, 3);
    }

    public int longestSubstring(String s, int k) {
        char[] cs = s.toCharArray();
        res = helper(cs, 0, cs.length - 1, k);
        return res;
    }

    int res = 0;

    private int helper(char[] c, int start, int end, int k) {
        if (end - start + 1 < k) return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = start; i <= end; i++) {
            hm.put(c[i], hm.getOrDefault(c[i], 0) + 1);
        }
        int flag = start;
        for (int i = start; i <= end; i++) {
            if (hm.get(c[i]) >= k) {
                continue;
            } else {
                res = Math.max(res, helper(c, flag, i - 1, k));
                flag = i + 1;
            }
        }
        if (flag == start && end - flag + 1 >= k) return Math.max(res, end - flag + 1);
        if (end - flag + 1 >= k)
            return Math.max(res, helper(c, flag, end, k));
        return res;
    }
}
