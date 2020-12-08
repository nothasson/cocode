//学到了可以用一个预处理，把结果存起来，这样以后每次只需要O(1)时间
class Ugly {
    public int[] nums = new int[1690];
    Ugly() {
        HashSet<Long> seen = new HashSet();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add((long) 1);
        heap.add((long) 1);
        long curUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        for (int i = 0; i < 1690; i++) {
            curUgly = heap.poll();
            nums[i] = (int) curUgly;
            for (int j : primes) {
                newUgly = curUgly * j;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }

    }
}
class Solution {
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }
}

//解法二，动态规划
class Ugly {
  public int[] nums = new int[1690];
  Ugly() {
    nums[0] = 1;
    int ugly, i2 = 0, i3 = 0, i5 = 0;

    for(int i = 1; i < 1690; ++i) {
      ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
      nums[i] = ugly;

      if (ugly == nums[i2] * 2) ++i2;
      if (ugly == nums[i3] * 3) ++i3;
      if (ugly == nums[i5] * 5) ++i5;
    }
  }
}

class Solution {
  public static Ugly u = new Ugly();
  public int nthUglyNumber(int n) {
    return u.nums[n - 1];
  }
}