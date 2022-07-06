package com.linkedin;

public class ShortestWordDist {

    public int getShortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        int l = -1, r = -1;
        for (int i = 0; i<words.length; i++) {
            if (words[i].equals(word1))
                l = i;
            if (words[i].equals(word2))
                r = i;
            if (l != -1 && r != -1)
                res = Math.min(res, Math.abs(l - r));
        }
        return res;
    }

}
