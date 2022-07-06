public class Compression {

    public static String compress(String str) {
        StringBuffer result = new StringBuffer();
        int sum = 1;
        for (int i=0; i<str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                sum++;
            } else {
                result.append(str.charAt(i)).append(sum);
                sum=1;
            }
        }
        result.append(str.charAt(str.length()-1)).append(sum);
        return result.length() > str.length() ? str : result.toString();
    }

    public static void main(String args[]) {
        System.out.println(compress("aaabbb"));
    }
}
