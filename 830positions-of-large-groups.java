class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new LinkedList<>();
        int start = 0, end = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) end++;
            else {
                if (end - start >= 2) {
                    LinkedList<Integer> l = new LinkedList<>();
                    l.add(start);
                    l.add(end);
                    res.add(l);
                }
                end = i;
                start = i;
            }
        }
        if (end - start >= 2) {
            LinkedList<Integer> l = new LinkedList<>();
            l.add(start);
            l.add(end);
            res.add(l);
        }
        return res;
    }
}