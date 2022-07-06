import java.util.*;
import java.util.Map;

public class MatchingSubseq {
    public int numMatchingSubseq(String s, String[] words) {
        //s = "abcde", words = ["a","bb","acd","ace"]
        int count = 0;
        Map<Character, Queue<String>> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            map.putIfAbsent(s.charAt(i), (Queue<String>) new LinkedList());
        }

        for (int j=0; j<words.length; j++) {
            if (map.containsKey(words[j].charAt(0))) {
                map.get(words[j].charAt(0)).add(words[j]);
            }
        }

        for (int i=0; i<s.length(); i++) {
            Queue<String> q = map.get(s.charAt(i));
            int size = q.size();
            for (int k=0; k<size; k++) {
                String word = q.poll();
                String newStr = word.substring(1);
                if (newStr.isEmpty()) {
                    count++;
                } else {
                    if (map.containsKey(newStr.charAt(0))) {
                        map.get(newStr.charAt(0)).add(newStr);
                    }
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        MatchingSubseq matchingSubseq = new MatchingSubseq();
        String s = "abcde";
        String[] words = new String[]{"a","bb","acd","ace"};
        System.out.println(matchingSubseq.numMatchingSubseq(s, words));
    }
}
