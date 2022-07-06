public class SpiralGenerator {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int size = n * n;
        int count = 1;
        if (n==1) {
            result[0][0] = 1;
        }
        while (result.length < size && count<=n*n) {
            for (int j=left; j<=right && result.length < size; j++) {
                result[top][j] = count;
                count++;
            }
            top++;
            for (int i=top; i<=bottom && result.length < size; i++) {
                result[i][right] = count;
                count++;
            }
            right--;
            for (int j=right; j>=left && result.length < size; j--) {
                result[bottom][j] = count;
                count++;
            }
            bottom--;
            for (int i=bottom; i>=top && result.length < size; i--) {
                result[i][left] = count;
                count++;
            }
            left++;
        }
        return result;
    }

    public static void main(String args[]) {
        SpiralGenerator s = new SpiralGenerator();
        s.generateMatrix(6);
    }
}
