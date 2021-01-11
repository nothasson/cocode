class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null)return res;
        Queue<Node> q = new LinkedList<>();
        int levelSize = 1;
        q.add(root);
        Node temp;
        List<Integer> tempList = new LinkedList<>();
        while (!q.isEmpty()) {
            tempList = new LinkedList<>();
            levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                temp = q.poll();
                tempList.add(temp.val);
                for (Node c : temp.children) {
                    q.add(c);
                }
            }
            res.add(tempList);
        }
        return res;
    }
}