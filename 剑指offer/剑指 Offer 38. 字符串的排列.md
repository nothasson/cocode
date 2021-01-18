#### [剑指 Offer 38. 字符串的排列](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/)

输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

```
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]
```

例子中的字符串是有重复字符的。

和https://leetcode-cn.com/problems/permutations-ii/一模一样

主要的思路就是回溯算法，有两种思路。

一种是交换型，一种是搜索型

## 交换回溯



```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
//        Arrays.sort(nums);
        if (nums == null || nums.length == 0) return res;
        backtracking(nums, 0, res);
        return res;
    }

    private void backtracking(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {  //已经交换到最后一个了
            List<Integer> temp = new LinkedList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {  //从i开始，依次和后面的进行交换，但是回溯的时候记得交换回来。
            if (set.contains(nums[j])) //判断是否重复了
                continue;
            set.add(nums[j]);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            backtracking(nums, i + 1, res);
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
```

## 回溯搜索

```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public String[] permutation(String s) {
        List<String> res = new LinkedList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], res, new StringBuilder());
        return res.toArray(new String[res.size()]);
    }

    private void backtracking(char[] s, boolean[] isVisited, List<String> res, StringBuilder sb) {
        if (sb.length() == s.length) {
            res.add(new String(sb));
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (isVisited[i]) continue; //这个节点访问过了
            if (i != 0 && s[i] == s[i - 1] && !isVisited[i - 1]) continue;//该节点与前一个相等，且前一个没有被访问过
            isVisited[i] = true;
            sb.append(s[i]);
            backtracking(s, isVisited, res, sb);
            sb.deleteCharAt(sb.length() - 1);
            isVisited[i] = false;
        }
    }
}
```

