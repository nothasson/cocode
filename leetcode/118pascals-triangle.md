就是生成一个杨辉三角

自己做的比较渣，执行用时用了1ms。

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);  //第一列默认
        int a, b;
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                a = j - 1 >= 0 ? result.get(i - 1).get(j - 1) : 0;  //防止越界
                b = j >= i ? 0 : result.get(i - 1).get(j);
                temp.add(a + b);
            }
            result.add(temp);
        }
        return result;
    }
}
```

网上说的，只是每一行的第一个1和最后一个1单独拎出来，这样的话，就不用三元表达式了。时间复杂度就比之前少了一点，如下图，方法是一样的

```java
class Solution {
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}
```

