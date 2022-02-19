class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();        
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


class MinStack {
    Deque<Long> xStack;
    long min;
    public MinStack() {
        xStack = new LinkedList<Long>();
    }
    
    public void push(int val) {
        if(xStack.isEmpty()){
            min = (long)val;
            xStack.push(0L);
            return;
        }
        xStack.push((long)val - min);
        min = Math.min(min,(long)val);
    }
    
    public void pop() {
        long x = xStack.pop();
        if(x >= 0) return;
        min = min - x;    
    }
    
    public int top() {
        if(xStack.peek()<=0){
            return (int) min;
        }
        return (int) (min + xStack.peek());
    }
    
    public int getMin() {
        return (int)min;
    }
}