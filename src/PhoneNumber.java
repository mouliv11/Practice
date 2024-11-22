import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Queue;

public class PhoneNumber {

    public static Map<Character, String> map;
    static {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return result;

        Queue<String> q = new java.util.LinkedList<>();
        q.add("");
        while(!q.isEmpty()) {
            String str = q.poll(); //str = "a"
            if (str.length() == digits.length()) {
                result.add(str);
            } else {
                String val = map.get(digits.charAt(str.length())); //23 -> abc | def
                for (int i=0; i<val.length(); i++) {
                    q.add(str + val.charAt(i)); //a,b,c| ad, ae, af
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        PhoneNumber n = new PhoneNumber();
        //int[] nums = new int[]{1,3,5,4,7};
        System.out.println(n.letterCombinations("23"));
    }
}
