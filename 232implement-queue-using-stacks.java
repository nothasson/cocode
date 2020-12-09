class MyQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;


    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    public void push(int x) {
        in.push(x);
    }
    public int pop() {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());
        return out.isEmpty() ? -1 : out.pop();

    }
    public int peek() {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());
        return out.isEmpty() ? -1 : out.peek();
    }
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}