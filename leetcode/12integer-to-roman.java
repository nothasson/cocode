class Solution {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num&& num >= 0) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
//下面是我的阴间算法
class Solution {
    public String intToRoman(int num) {
        StringBuffer res = new StringBuffer();
        while (num != 0 && num >= 1000) {
            res.append("M");
            num -= 1000;
        }
        while (num != 0 && num >= 900) {
            res.append("CM");
            num -= 900;
        }
        while (num != 0 && num >= 500) {
            res.append("D");
            num -= 500;
        }
        while (num != 0 && num >= 400) {
            res.append("CD");
            num -= 400;
        }
        while (num != 0 && num >= 100) {
            res.append("C");
            num -= 100;
        }
        while (num != 0 && num >= 90) {
            res.append("XC");
            num -= 90;
        }
        while (num != 0 && num >= 50) {
            res.append("L");
            num -= 50;
        }
        while (num != 0 && num >= 40) {
            res.append("XL");
            num -= 40;
        }
        while (num != 0 && num >= 10) {
            res.append("X");
            num -= 10;
        }
        while (num != 0 && num >= 9) {
            res.append("IX");
            num -= 9;
        }
        while (num != 0 && num >= 5) {
            res.append("V");
            num -= 5;
        }
        while (num != 0 && num >= 4) {
            res.append("IV");
            num -= 4;
        }
        while (num != 0 && num >= 1) {
            res.append("I");
            num -= 1;
        }

        return res.toString();
    }
}