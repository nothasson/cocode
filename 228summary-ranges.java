class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        int start, end;
        for (int i = 0; i < nums.length; i++) {
            start = nums[i];
            end = nums[i];
            while (i+1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
                end++;
            }
            if (start == end) res.add(String.valueOf(start));
            else res.add(start + "->" + end);
        }
        return res;
    }
}