class MinStack {

    Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        minStack.push(val);
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        Integer min = minStack.peek();
        while (!minStack.isEmpty()) {
            min = Math.min(minStack.peek(), min);
            tmp.push(minStack.pop());
        }
        while (!tmp.isEmpty()) {
            minStack.push(tmp.pop());
        }
        return min;
    }
}
