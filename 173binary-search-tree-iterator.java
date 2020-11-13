class BSTIterator {

    public BSTIterator(TreeNode root) {
        getOrder(root);
    }

    private void getOrder(TreeNode root) {
        if (root == null) return;
        getOrder(root.left);
        order.add(root.val);
        getOrder(root.right);
    }
    private static List<Integer> order = new LinkedList<>();
    private static int now = 0;
    public int next() {
        return order.get(now++);
    }

    public boolean hasNext() {
        return now < order.size();
    }
}

//自己写的果然就水，下面是官方题解
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        
        // Stack for the recursion simulation
        this.stack = new Stack<TreeNode>();
        
        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {
      
        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = this.stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the 
        // helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}