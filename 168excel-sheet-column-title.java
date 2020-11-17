//这个n--搞死人
class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            n--;
            sb.insert(0, ((char) ('A' + n % 26)));
            n = n / 26;
        }
        return sb.toString();
    }
}