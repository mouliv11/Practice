import java.util.HashMap;
import java.util.Map;

public class LongSubStr {

        //abcabcbb
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap(); // current index of character

            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i); //i=1, i=2, i=3, i=5, i=7
                } //j=6
                ans = Math.max(ans, j - i + 1); //ans=3, ans=3, ans=3, ans=3
                map.put(s.charAt(j), j + 1); //a=4, b=8, c=6
            }
            return ans;
        }

}
