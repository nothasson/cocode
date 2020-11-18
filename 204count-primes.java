class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i = 2; i * i < n; i++) {   //遍历一半就好了
            for (int j = i * i; j < n; j += i) {    //i*2 到i*i之间的实际上已经被标记过了
                isPrime[j] = false;
            }
        }
        for (int i = 2; i < isPrime.length; i++) {  
            if (isPrime[i]) count++;
        }
        return count;
    }
}