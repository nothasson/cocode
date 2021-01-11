https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

```tex
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
```

四种解法:

1. 使用哈希表,最简单的做法.

```java
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return num;
        }
        return -1;
    }
```

但是空间复杂度为O(N)

2. 排序之后判断是否有相邻元素中是否有重复的值.

```java
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                return nums[i];
        }
        return -1;
    }
```

但是时间复杂度为 O(NlogN)

3. 将哈希表的操作放到原数组中,对于每一个nums[i],让nums[nums[i] % N]增加一个数组的长度,最后再判断哪些元素的值是大于等于2倍数组长度的

```java
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[nums[i] % nums.length] += nums.length;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= 2 * nums.length) return i;
        return -1;
    }
```

虽然遍历了两趟,但是时间复杂度O(N),空间复杂度为O(1)

4. 原地置换.如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，所以思路是重头扫描数组，遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。在交换过程中，如果有重复的数字发生，那么终止返回ture

   ```java
   class Solution {
       public int findRepeatNumber(int[] nums) {
           int temp;
           for(int i=0;i<nums.length;i++){
               while (nums[i]!=i){
                   if(nums[i]==nums[nums[i]]){
                       return nums[i];
                   }
                   temp=nums[i];
                   nums[i]=nums[temp];
                   nums[temp]=temp;
               }
           }
           return -1;
       }
   }
   ```

   