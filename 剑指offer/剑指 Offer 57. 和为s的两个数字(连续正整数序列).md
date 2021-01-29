# [剑指 Offer 57. 和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

```
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]
```

就是一个有序的twosum，用双指针就可以解决了。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i < j) {
            if (nums[i] + nums[j] == target)
                return new int[]{nums[i], nums[j]};
            else if (nums[i] + nums[j] < target) i++;
            else j--;
        }
        return null;
    }
}
```

# [剑指 Offer 57 - II. 和为s的连续正数序列](https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)

输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

```
输入：target = 9
输出：[[2,3,4],[4,5]]
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
```

## 遍历

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> resLists = new LinkedList<>();
        for (int i = 1; i <= target / 2; i++) {
            int temp = i;
            int sum = 0;
            List<Integer> tempList = new LinkedList<>();
            while (sum < target) {
                tempList.add(temp);
                sum += temp++;
            }
            if (sum == target) {
                resLists.add(tempList);
            }
        }
        int[][] res = new int[resLists.size()][];
        for (int i = 0; i < res.length; i++) {
            int j = 0;
            res[i] = new int[resLists.get(i).size()];
            for (Integer num : resLists.get(i)) {
                res[i][j++] = num;
            }
        }
        return res;
    }
}
```

![image-20210129133043888](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210129133043888.png)

很菜啊。。

## 滑动窗口

一共有三种情况：

- 如果sum<target 则说明指针 r 还可以向右拓展使得 sum 增大，此时指针 r 向右移动，即 r+=1
- 如果 sum>target 则说明以 l为起点不存在一个 r 使得 sum=target ，此时要枚举下一个起点，指针 l 向右移动，即l+=1
- 如果sum==target 则说明我们找到了以 l 为起点得合法解 $[l,r]$ ，我们需要将 $[l,r]$的序列放进答案数组，且我们知道以 l 为起点的合法解最多只有一个，所以需要枚举下一个起点，指针 l 向右移动，即 l+=1




```java
    public int[][] findContinuousSequence(int target) {
        List<int[]> resLists = new LinkedList<>();
        int l = 1, r = 2;
        while (l < r) {
            int sum = (l + r) * (r - l + 1) / 2;  //等差数列求和公式
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = l; i <= r; i++)
                    temp[i - l] = i;
                resLists.add(temp);
                l++;
            } else if (sum < target) {
                r++;
            } else l++;
        }
        return resLists.toArray(new int[resLists.size()][]);
    }
```

