class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0, twentys = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) fives++;
            else if (bills[i] == 10) {
                fives--;
                tens++;
            } else {
                if (tens > 0) {
                    fives--;
                    tens--;
                } else {
                    fives -= 3;
                }
                twentys++;
            }
            if (fives < 0 || tens < 0 || twentys < 0) return false;
        }
        return true;
    }
}