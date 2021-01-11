class MinStack {
    public Stack<Integer>min;
    public Stack<Integer>stack;
    /** initialize your data structure here. */
    public MinStack() {
        min = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.size()==0 || x < min.peek()) 
            min.push(x);
        else min.push(min.peek());
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}