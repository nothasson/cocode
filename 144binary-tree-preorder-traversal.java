// 好像又很久没写了，感觉论文好难啊，没数学也感觉好难

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            result.add(temp.val);
            if (temp.right != null) stack.add(temp.right);
            if (temp.left != null) stack.add(temp.left);
        }
        return result;
    }
}