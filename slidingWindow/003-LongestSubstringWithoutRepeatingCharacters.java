package slidingWindow;

import java.util.HashMap;
import java.util.Map;

class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }

            map.put(c, end);

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}