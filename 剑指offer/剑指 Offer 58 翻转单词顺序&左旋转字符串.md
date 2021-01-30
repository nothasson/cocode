# [剑指 Offer 58 - I. 翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

```
输入: "the sky is blue"
输出: "blue is sky the"
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```

## 遍历

从前往后遍历，每次遍历先去除空格，然后保存中间的字符，逆转之后保存到结果中。

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp;
        int index = s.length() - 1;
        while (index >= 0) {
            while (index >= 0 && s.charAt(index) == ' ') index--;
            temp = new StringBuilder();
            while (index >= 0 && s.charAt(index) != ' ') {
                temp.append(s.charAt(index));
                index--;
            }
            if (temp.length() > 0) {
                temp.reverse();
                res.append(temp + " ");
            }
        }
        if (res.length() >= 1)
            res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
```

![image-20210130194951477](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210130194951477.png)

效果不是很好。。应该是逆转花太多时间了，~~稍微改进一下。~~改进之后发现更差了。。

## 双指针

不应该再开一个StringBuilder了，直接用subString，维护一个单词开始和结束的位置。

```java
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp;
        int j = s.length() - 1;
        int i = j + 1;
        while (j >= 0) {
            j = i - 1;
            while (j >= 0 && s.charAt(j) == ' ') j--;
            i = j;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            i++;
            if (i >= 0 && j >= 0)
                res.append(s.substring(i, j + 1) + " ");
        }
        if (res.length() >= 1)
            res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
```

![image-20210130200250190](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210130200250190.png)

效果稍微好一点

看了下题解，方法和我的差不多。。

# [剑指 Offer 58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

```
输入: s = "abcdefg", k = 2
输出: "cdefgab"
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
```

## 转为字符数组---旋转数组

最简单的方法应该就是转为一个字符数组，再用三次reverse方法就ok了。和leetcode的某一题是一样的。

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars, 0, s.length() - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
```

![image-20210130201155753](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210130201155753.png)

效果一般

## 字符串切片

获取字符串 s[n:] 切片和 s[:n] 切片，使用 "+" 运算符拼接并返回即可。

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
```

## 分两段遍历

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++)
            res.append(s.charAt(i));
        return res.toString();
    }
}
```

