#### [剑指 Offer 51. 数组中的逆序对](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/)

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

```
输入: [7,5,6,4]
输出: 5
```

这题一看就长成了我不会做的样子

[数组中的逆序对 - 数组中的逆序对 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/)

这题y神居然没有题解,直接看官方题解把.

讲的挺好的,里面的视频.

## 分治-归并排序

主要用到了归并排序的思想.基本是和归并是衣杨的,只是在将分组进行排序的时候,多了一些操作.具体可以看下面的代码注释

```java
public class Solution {
    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    private int reversePairs(int[] nums, int start, int end, int[] temp) {
        if (start == end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int startPairs = reversePairs(nums, start, mid, temp);
        int endPairs = reversePairs(nums, mid + 1, end, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return startPairs + endPairs;
        }

        int crossPairs = mergeAndCount(nums, start, mid, end, temp);
        return startPairs + endPairs + crossPairs;
    }


    //     nums[start ..mid]有序，nums[mid +1..end]有序
    private int mergeAndCount(int[] nums, int start, int mid, int end, int[] temp) {
        for (int i = start; i <= end; i++) {
            temp[i] = nums[i];
        }

        int i = start; //归并的两个起始下标
        int j = mid + 1;

        int count = 0;
        for (int k = start; k <= end; k++) {

            if (i == mid + 1) {  //前一半已经遍历完毕
                nums[k] = temp[j];
                j++;
            } else if (j == end + 1) { //后一半已经遍历完毕
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {//如果都没有遍历完毕，则比较其中小于的那个,前面小都无所谓
                nums[k] = temp[i];
                i++;
            } else {  //后面小的话，就有关系了，这其中涉及到逆序对(j对应的元素,比i到mid的都小,这里面都是逆序对)
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
```

