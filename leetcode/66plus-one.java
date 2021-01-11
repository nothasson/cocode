//总感觉自己喜欢刷这些水题，得改一下才行
class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i] -= 10;
                digits[i - 1]++;
            }
        }
        if (digits[0] >= 10) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            digits[0] -= 10;
            result[1] = digits[0];
            for (int i = 2; i < result.length; i++) {
                result[i] = digits[i - 2];
            }
            return result;
        }
        return digits;
    }
}