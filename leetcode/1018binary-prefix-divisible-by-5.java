class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<Boolean>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (sum * 2 + A[i]) % 5;
            if (sum % 5 == 0)
                result.add(true);
            else result.add(false);
        }
        return result;
    }
}