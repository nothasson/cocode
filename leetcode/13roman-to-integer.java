class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        char now;
        for (int i = 0; i < s.length(); i++) {
            now = s.charAt(i);
            if (i != s.length() - 1 && ((now == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
                    || (now == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
                    || (now == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M'))))
                sum -= getValue(now);
            else sum += getValue(now);
        }
        return sum;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}