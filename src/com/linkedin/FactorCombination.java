package com.linkedin;

import java.util.ArrayList;
import java.util.List;

// https://stackoverflow.com/questions/45662736/how-to-find-the-time-complexity-of-dfsbacktracking-algorithms
public class FactorCombination {

    private static int count = 0;
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        process(2, result, new ArrayList<Integer>(), n);
        return result;
    }

    private void process(int start, List<List<Integer>> result, ArrayList<Integer> currList, int n) {
        if (n == 1) {
            if (currList.size() > 1) {
                result.add(new ArrayList<>(currList));
            }
        }
        for (int i = start; i<=n; i++) {
            if (n % i == 0) {
                currList.add(i);
                process(i, result, currList, n/i);
                currList.remove(currList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombination f = new FactorCombination();
        List<List<Integer>> result = f.getFactors(8);
        System.out.println(count);
    }
}
