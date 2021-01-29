#### [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

```
s = "abaccdeff"
返回 "b"

s = "" 
返回 " "
```

第一次遍历计数，第二次遍历看哪个为一。。好像没有什么高级的方法了。

```java
class Solution {
    public char firstUniqChar(String s) {
        char[] counts = new char[26];
        for (int i = 0; i < s.length(); i++)
            counts[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (counts[s.charAt(i) - 'a'] == 1)
                return s.charAt(i);
        return ' ';
    }
}
```

