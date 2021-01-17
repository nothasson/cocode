#### [剑指 Offer 31. 栈的压入、弹出序列](https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

```
输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。
```

模拟即可，不会作图。。就把别人的图放上来了(https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/)~

<img src="https://gitee.com/20162180090/piccgo/raw/master/pic/c880f045c03a8e03b7908b2d49b658a9a32ba8f5d40cb19da62db32c7eb58830-Picture1.png" alt="Picture1.png" style="zoom: 50%;" />

<img src="https://gitee.com/20162180090/piccgo/raw/master/pic/4397f5b44038603d70568147824877cacdaa76cef22371c2c80ff55f915092fd-Picture2.png" alt="Picture2.png" style="zoom:50%;" />

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int popIndex = 0, pushIndex = 0;
        while (pushIndex < pushed.length) {
            while (pushIndex < pushed.length - 1 && pushed[pushIndex] != popped[popIndex])
                stack.push(pushed[pushIndex++]);
            stack.push(pushed[pushIndex++]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
```

好像别人的代码看起来好看一点。。

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
```

