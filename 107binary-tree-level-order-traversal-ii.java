class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> tempList;
        TreeNode tempNode;
        int tempSize;
        while (!queue.isEmpty()) {
            tempList = new LinkedList<>();
            tempSize = queue.size();
            for (int i = 0; i < tempSize; i++) {
                tempNode = queue.poll();
                tempList.add(tempNode.val);
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            result.add(tempList);
        }
        Collections.reverse(result);
        return result;
    }
}