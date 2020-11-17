class Solution {
    public String addBinary(String a, String b) {
        String temp;
        if (a.length() < b.length()) {
            temp = a;
            a = b;
            b = temp;
        }  // 长的那个作为a

        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        StringBuffer sb = new StringBuffer(a);
        for (int i = bLength; i >= 0; i--) {
            char cur = (char) (sb.charAt(aLength - bLength + i) - '0' + b.charAt(i));
            sb.setCharAt(aLength - bLength + i, cur);
        }
        for (int i = aLength; i > 0; i--) {
            if (sb.charAt(i) >= '2') {
                sb.setCharAt(i, (char) (sb.charAt(i) - 2));
                sb.setCharAt(i - 1, (char) (sb.charAt(i - 1) + 1));
            }
        }
        if (sb.charAt(0) >= '2') {
            sb.setCharAt(0, (char) (sb.charAt(0) - 2));
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}