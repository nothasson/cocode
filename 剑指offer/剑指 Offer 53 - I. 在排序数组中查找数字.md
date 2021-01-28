####   [剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

统计一个数字在排序数组中出现的次数。

```
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
```

这个题目看到排序,首先应该想到是二分排序,如果说直接遍历的话,估计面试官会不太高兴.

应该是二分查找,然后往左和往右进行搜索.

```java
class Solution {
    public int search(int[] nums, int target) {
        int count = 0;
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                count++;
                break;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;

        }
        boolean found = true;
        int index = 1;
        while (found) {
            found = false;
            if ((mid + index) <= nums.length - 1 && nums[mid + index] == target) {
                found = true;
                count++;
            }
            if ((mid - index) >= 0 && nums[mid - index] == target) {
                found = true;
                count++;
            }
            index++;
        }
        return count;
    }
}
```

![image-20210128142423617](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210128142423617.png)

效率还行.

#### [剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

```
输入: [0,1,3]
输出: 2
输入: [0,1,2,3,4,5,6,7,9]
输出: 8
```

这题好像写过,因为是排序数组,可以先想到二分法,不过直接遍历的话,比较明显.

### 遍历

```java
class Solution {
    public int missingNumber(int[] nums) {
        if (nums[0]==1) return 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=i) return i;
        }
        return nums.length;
    }
}
```



### 二分

```java
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}

```

