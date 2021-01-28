#### [剑指 Offer 48. 最长不含重复字符的子字符串](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

这题好像以前做过，但是忘记怎么做了。直接看题解吧。。。

[面试题48. 最长不含重复字符的子字符串（动态规划 / 双指针 + 哈希表，清晰图解） - 最长不含重复字符的子字符串 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/)

## 哈希表+动态规划

设动态规划列表 $dp$ ，$dp[j]$代表以字符 $s[j]$ 为结尾的 “最长不重复子字符串” 的长度。

**哈希表统计：** 遍历字符串 $s$时，使用哈希表（记为 $dic$）统计 **各字符最后一次出现的索引位置** 



![image-20210128111135385](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210128111135385.png)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
```

