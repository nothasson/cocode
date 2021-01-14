#### [剑指 Offer 19. 正则表达式匹配](https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/)

https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/

请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

```
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
```

## 动态规划

![image-20210114144652777](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210114144652777.png)

```
dp[i][j] = dp[i-1][j] // 多个字符匹配的情况	
or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
or dp[i][j] = dp[i][j-2] // 没有匹配的情况
```



```java
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];  //前一个不匹配,拿的就是*的个数取0的情况
                    if (matches(s, p, i, j - 1)) {  //前一个匹配的时候
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
```





## 有穷自动机

编译原理地时候学的有穷自动机。。自己写了一堆，发现做不出来。贴一份别人的代码。

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean isMatch(String s, String p) {
        State nfa = createNfa(p);
        char[] chars = s.toCharArray();

        return backtrack(0, chars, nfa);
    }

    private static class State {
        private Map<Character, List<State>> trans = new HashMap<>();
        private boolean isFinal = false;
    }

    private State createNfa(String p) {
        char[] pattern = p.toCharArray();
        int len = pattern.length;
        State init = new State();
        State cur = init;

        int i = 0;
        while (i < len) {
            char c = pattern[i];
            if (i < len - 1 && pattern[i + 1] == '*') {
                State state = new State();
                state.trans.put(c, new ArrayList<>());
                state.trans.get(c).add(state);
                cur.trans.put('#', new ArrayList<>());
                cur.trans.get('#').add(state);
                cur = state;

                i += 2;
            } else {
                State state = new State();
                if (!cur.trans.containsKey(c)) {
                    cur.trans.put(c, new ArrayList<>());
                }
                cur.trans.get(c).add(state);

                cur = state;

                i += 1;
            }
        }

        cur.isFinal = true;

        return init;
    }

    private boolean backtrack(int i, char[] chars, State state) {
        if (i == chars.length) {
            return isFinalState(state);
        }

        char c = chars[i];
        if (state.trans.containsKey(c)) {
            List<State> states = state.trans.get(c);

            for (State s : states) {
                boolean res = backtrack(i + 1, chars, s);
                if (res) {
                    return true;
                }
            }
        }
        if (state.trans.containsKey('.')) {
            List<State> states = state.trans.get('.');

            for (State s : states) {
                boolean res = backtrack(i + 1, chars, s);
                if (res) {
                    return true;
                }
            }
        }
        if (state.trans.containsKey('#')) {
            return backtrack(i, chars, state.trans.get('#').get(0));
        }

        return false;
    }

    private boolean isFinalState(State state) {
        if (state.isFinal == true) {
            return true;
        } else if (state.trans.containsKey('#')) {
            return isFinalState(state.trans.get('#').get(0));
        } else {
            return false;
        }
    }
}
```



 ## 



