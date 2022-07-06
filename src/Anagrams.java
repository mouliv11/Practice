import java.util.ArrayList;
import java.util.List;

public class Anagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        char[] char_count = new char[26];
        for (char c : p.toCharArray()) {
            char_count[c - 'a']++;//1,1,1,0...
        }

        int left = 0;
        int right = 0;
        int toVisit = p.length();
        while (right < s.length()) {
            if (char_count[s.charAt(right) - 'a'] >= 1) {
                toVisit--;
            }
            char_count[s.charAt(right) - 'a']--;
            right++;
            if (toVisit == 0)
                output.add(left);
            if (right - left == p.length()) {
                if (char_count[s.charAt(left) - 'a'] >= 0) {
                    toVisit++;
                }
                char_count[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return output;
    }
}