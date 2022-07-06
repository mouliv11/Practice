package com.linkedin;

import com.sun.deploy.util.StringUtils;

public class RomanNumeral {
    private Numeral[] numerals = {
            new Numeral("M", 1000),
            new Numeral("CM", 900),
            new Numeral("D", 500),
            new Numeral("CD", 400),
            new Numeral("C", 100),
            new Numeral("XC", 90),
            new Numeral("L", 50),
            new Numeral("XL", 40),
            new Numeral("X", 10),
            new Numeral("IX", 9),
            new Numeral("V", 5),
            new Numeral("IV", 4),
            new Numeral("I", 1)
    };

    class Numeral {
        private String symbol;
        private int value;

        public Numeral(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }

    public String intToRoman(int num) {
        String result = "";
        for (Numeral numeral : numerals) {
            int symbolCnt = num/numeral.value;
            if (symbolCnt != 0) {
                String repeatedStr = "";
                for (int i=0; i<symbolCnt; i++) {
                    repeatedStr += numeral.symbol; //java 11
                }
                result = result + repeatedStr;
            }
            num = num % numeral.value;
        }
        return result;
    }

    public static void main(String[] args) {
        RomanNumeral r = new RomanNumeral();
        System.out.println(r.intToRoman(2944));
    }
}
