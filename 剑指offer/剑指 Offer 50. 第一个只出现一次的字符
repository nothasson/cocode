

#### [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

```
s = "abaccdeff"
返回 "b"

s = "" 
返回 " "
```

## 遍历两次

首先是两次遍历的方法

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

## LinkedHashMap

在哈希表的基础上，有序哈希表中的键值对是 **按照插入顺序排序** 的。基于此，可通过遍历有序哈希表，实现搜索首个 “数量为 1的字符”。

```java

class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
           if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
```

但是效率还是没有两次遍历的快,不知道也没有一次遍历的方法,且不借助于有序哈希表的.

![image-20210128113855672](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210128113855672.png)