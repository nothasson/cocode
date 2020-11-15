import java.util.LinkedList;
import java.util.List;

class Solution {
    private static List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new LinkedList<>();
        if (root == null) return result;
        StringBuffer sb = new StringBuffer();
//        sb.append(root.val);
        helper(root, sb);


        return result;
    }

    private void helper(TreeNode root, StringBuffer stringBuffer) {
        stringBuffer.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            result.add(stringBuffer.substring(2, stringBuffer.length()));
        }
        if (root.left != null) helper(root.left, stringBuffer);
        if (root.right != null) helper(root.right, stringBuffer);
        int length = String.valueOf(root.val).length();
        stringBuffer.delete(stringBuffer.length() - 2 - length, stringBuffer.length());
    }
}