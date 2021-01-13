![image-20201210095735388](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20201210095735388.png)

```java
import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList();
        if (s == null || s.length() == 0) return res;
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, s.length(), stack, res);
        return res;
    }

    private void backtracking(String s, int start, int len,
                              Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!isPalindrome(s, start, i))
                continue;
            path.add(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, res);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
```

![image-20201210101151026](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20201210101151026.png)

