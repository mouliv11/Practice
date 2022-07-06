import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2 {

    public static void main(String args[]) {
        System.out.println(isOneEdit("pale", "ple"));
        System.out.println(isOneEdit("pales", "pale"));
        System.out.println(isOneEdit("pale", "bale"));
        System.out.println(isOneEdit("pale", "bae"));
    }

    private static boolean isOneEdit(String a, String b) {
        Set set = new HashSet<>();
        char[] firstArr = a.toCharArray();
        for (char c : firstArr) {
            set.add(c);
        }
        char[] secArr = b.toCharArray();
        for (char c : secArr) {
            set.remove(c);
        }
        if (set.size() > 1)
            return false;
        else
            return true;
    }
}
