https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

```
输入：[3,4,5,1,2]
输出：1
输入：[2,2,2,0,1]
输出：0
```

看到有序就应该首先想到二分，虽然现在他的格式发生了一定的变化。

```java
class Solution {
    public int minArray(int[] numbers) {
//        if (numbers == null || numbers.length == 0) return 0;
        int i = 0, j = numbers.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = (i + j) / 2;
            if (numbers[i] < numbers[mid] && numbers[j] < numbers[mid]) {  
                //如果中间值大于两边，说明中间值属于旋转的一部分
                // 如果 3，4，5，1，2 。5为中间值，在原数组中他是属于后半部分的，而最小值在他右边
                i = mid + 1;
            } else if (numbers[i] > numbers[mid] && numbers[j] > numbers[mid]) {
                //如果中间值小于两边，说明中间值不属于旋转的一部分
                // 如果 5，1，2，3，4 。2为中间值，他不属于旋转的部分，考虑到递增序列，所以最小值在他左边。
                j = mid;
            } else {
                //如果中间某次已经是一个有序序列了，可以直接遍历所得最小值。
                int min = numbers[i];
                for (int k = i; k <= j; k++) {
                    if (numbers[k] < min) min = numbers[k];
                }
                return min;
            }
        }
        return numbers[i];
    }
}
```

![image-20210112132030657](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210112132030657.png)

这题的答案也可以用于

1. https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
2. https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/

且都击败100%的用户