class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        Arrays.sort(ss1);
        Arrays.sort(ss2);
        int x = 0, y = 0;
        for (int i = 0; i < ss1.length; i++) {
            if (ss1[i] >= ss2[i]) x++;
            if (ss2[i] >= ss1[i]) y++;
        }
        if (Math.max(x, y) == ss1.length) return true;
        return false;
    }
}