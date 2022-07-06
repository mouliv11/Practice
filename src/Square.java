//public class Square {
//    int max = 0;
//    private int squareSubmatrix(boolean[][] arr) {
//        int[][] cache = new int[arr.length][arr[0].length];
//        for (int i=0; i<arr.length; i++) {
//            for (int j=0; j<arr[0].length; j++) {
//                if (arr[i][j])
//                    max = Math.max(max, squareSubmatrix(arr, i, j, cache));
//            }
//        }
//        return max;
//    }
//
//    private int squareSubmatrix(boolean[][] arr, int i, int j, int[][] cache) {
//        if (i == arr.length || j == arr[0].length)
//            return 0;
//        if (!arr[i][j])
//            return 0;
//        if (cache[i][j] > 0)
//            return cache[i][j];
//        cache[i][j] = 1 + Math.min(Math.min(squareSubmatrix(arr, i+1, j, cache),
//                squareSubmatrix(arr, i, j+1, cache)),
//                squareSubmatrix(arr, i+1, j+1, cache));
//        return cache[i][j];
//    }
//
//}

public class Square {

    private int squareSubmatrix(boolean[][] arr) {
        int max = 0;
        int[][] cache = new int[arr.length][arr[0].length];
        for (int i=0; i<cache.length; i++) {
            for(int j=0; j<cache[0].length; j++) {
                if (i == 0 || j == 0)
                    cache[i][j] = arr[i][j] ? 1 : 0;
                else if (arr[i][j]) {
                    cache[i][j] = Math.min(Math.min(cache[i-1][j], cache[i][j-1]), cache[i-1][j-1]) + 1;
                }
                if (cache[i][j] > max)
                    max = cache[i][j];
            }
        }
        return max;
    }
}