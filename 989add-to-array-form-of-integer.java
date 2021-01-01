class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        if (A == null || A.length == 0) return Arrays.asList(K);
        for (int i = A.length - 1; i >= 0; i--) {
            if (K == 0) break;
            A[i] += K % 10;
            K /= 10;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] >= 10 && i != 0) {
                A[i] -= 10;
                A[i - 1]++;
            }
        }
        List<Integer> res = new LinkedList<>();
        if (A[0] >= 10) {
            res.add(1);
            A[0] -= 10;
        }
        int index = res.size() - 1;
        while (K != 0 && index >= -1) {
            if (index == -1) {
                res.add(0, K % 10);
            } else {
                res.set(index, res.get(index) + K % 10);
                if (res.get(index) >= 10) {res.set(index, res.get(index) - 10);
                K += 10;}
            }
            index--;
            K /= 10;
        }
        while (K != 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        for (int i = 0; i < A.length; i++) {
            res.add(A[i]);
        }
        return res;
    }
}

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        for(int i = A.length-1 ; i >= 0 || K > 0 ; i--){
            if(i >= 0)
                K += A[i]; 
            res.addFirst(K % 10);
            K = K/10; 
        }
        return res;
    }
}