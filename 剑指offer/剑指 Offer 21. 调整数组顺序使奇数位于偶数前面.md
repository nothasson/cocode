#### [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 

```
输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。
```

## 首尾双指针

一道双指针的题，用一个i从0开始遍历，一个j从nums.length-1开始遍历，如果nums[i]为偶数，且nums[j]为奇数，则把他们交换，这样不断迭代下去。

```java
class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length <= 2) return nums;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 != 0)
                i++;
            while (i < j && nums[j] % 2 != 1)
                j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
```

## 快慢双指针

fast 的作用是向前搜索奇数位置，slow的作用是指向下一个奇数应当存放的位置
fast 向前移动，当它搜索到奇数时，将它和 nums[slow] 交换，此时 slow向前移动一个位置 .
重复上述操作，直到 fast指向数组末尾 .

```java
class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length <= 2) return nums;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] % 2 == 1) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
```



