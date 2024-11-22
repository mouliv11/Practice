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

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        // Instantiate the WordDistance class
        ShortestWordDist wordDistance = new ShortestWordDist();

        // Test queries
        System.out.println("Shortest distance between 'coding' and 'practice': " + wordDistance.getShortestDistance(words, "coding", "practice"));  // Output: 3
        System.out.println("Shortest distance between 'makes' and 'coding': " + wordDistance.getShortestDistance(words, "makes", "coding"));
    }
}
