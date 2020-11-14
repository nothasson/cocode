class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode tempNode;
        int tempSize;
        while (!queue.isEmpty()) {
            tempSize = queue.size();
            for (int i = 0; i < tempSize; i++) {
                tempNode = queue.poll();
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
                if (i == tempSize - 1) result.add(tempNode.val);
            }
        }
        return result;
    }
}