import java.util.ArrayList;
import java.util.List;

public class Zigzag {
    public static String convert(String s, int numRows) {

        if (numRows == 1)
            return s;

        List<StringBuilder> list = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            list.add(new StringBuilder());
        }

        boolean goingDown = false;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            if (curRow == 0 || curRow == numRows-1)
                goingDown = !goingDown;
            list.get(curRow).append(c);
            curRow = curRow + (goingDown ? 1 : -1);
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i<list.size(); i++) {
            result.append(list.get(i));
        }
        return result.toString();
    }

    public static void main(String args[]) {
        System.out.println(Zigzag.convert("PAYPALISHIRING", 3));
    }
}