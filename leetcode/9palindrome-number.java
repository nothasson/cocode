class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x !=0))return false;
        int origin =x;
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            result = result * 10 + temp;
            x = x / 10;
        }
        return origin == result;
    }
}