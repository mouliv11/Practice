import java.util.ArrayList;
import java.util.HashMap;

class WordDistance {

    HashMap<String, ArrayList<Integer>> locations;

    public WordDistance(String[] words) {
        this.locations = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            ArrayList<Integer> loc = this.locations.getOrDefault(words[i], new ArrayList<Integer>());
            loc.add(i);
            locations.put(words[i], loc);
        }
    }

    public int shortest(String word1, String word2) {

        ArrayList<Integer> loc1 = locations.get(word1);
        ArrayList<Integer> loc2 = locations.get(word2);

        int l1=0, l2=0, minDiff = Integer.MAX_VALUE;
        while (l1 < loc1.size() && l2 < loc2.size()) {
            minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) < loc2.get(l2)) {
                l1++;
            } else {
                l2++;
            }
        }
        return minDiff;
    }
}