class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 || s == null) return true;
        int si = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(si) == t.charAt(i)) si++;
            if (si == s.length()) return true;
        }
        return false;
    }
}