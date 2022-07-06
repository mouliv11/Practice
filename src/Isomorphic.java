import java.util.Scanner;
import java.util.*;

public class Isomorphic {
    public static boolean isIsomorphic(String str1, String str2) {
        // WRITE YOUR BRILLIANT CODE HERE
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        if (str1.length() != str2.length())
            return false;
        for (int i=0; i<str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            if (map.containsKey(char1)) {
                if (map.get(char1) != char2)
                    return false;
            } else {
                if (used.contains(char2))
                    return false;
                map.put(char1, char2);
                used.add(char2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();
        boolean res = isIsomorphic(str1, str2);
        System.out.println(res);
    }
}
