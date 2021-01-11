//和102很像，判断是次数是奇偶就好了
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tempNode;
        LinkedList<Integer> tempList;
        int tempSize = 0;
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            tempList = new LinkedList<>();
            tempSize = queue.size();

            for (int i = 0; i < tempSize; i++) {
                tempNode = queue.poll();
                if (isOdd)
                    tempList.addFirst(tempNode.val);
                else
                    tempList.addLast(tempNode.val);
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            result.add(tempList);
            isOdd = !isOdd;

        }
        return result;
    }
}