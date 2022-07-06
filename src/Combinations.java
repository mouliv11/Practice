import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> combo = new ArrayList();
//        if (n==k) {
//            combo.add(n);
//            results.add(combo);
//            return results;
//        }
        combine(1, n, k, combo, results);
        return results;
    }

    private static void combine(int i, int n, int k, List combo, List results) {
        if (k == 0) {
            results.add(new ArrayList<>(combo));
            return;
        }
        for (int j=i; j<=n; j++) {
            combo.add(j);
            combine(j+1, n, k-1, combo, results);
            combo.remove(combo.size()-1);
        }
    }

    public static void main(String args[]) {
        combine(1, 1);
    }
}
