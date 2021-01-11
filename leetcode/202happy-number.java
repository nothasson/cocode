class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int result = 0;
        while (true) {
            while (n != 0) {
                result += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(result))
                break;
            if (result == 1) return true;
            set.add(result);
            n = result;
            result = 0;
        }
        return false;
    }
}