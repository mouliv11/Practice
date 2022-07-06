public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1; //abca
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
