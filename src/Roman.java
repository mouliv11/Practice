public class Roman {

    private final String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL",
    "X", "IX", "V", "IV", "I"};

    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40,
            10, 9, 5, 4, 1};

    public String getRomanNumerals(int value) {
        if (value >= 3999 || value < 1) throw new IllegalArgumentException();
        StringBuilder romanString  = new StringBuilder();
        int i=0;
        while(value > 0) {
            if (value - values[i] >= 0) {
                romanString.append(numerals[i]);
                value = value - values[i];
            } else {
                i++;
            }
        }
        System.out.println(romanString);
        return romanString.toString();
    }

    public static void main(String args[]) {
        Roman roman = new Roman();
        roman.getRomanNumerals(49);
    }
}
