class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
      
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shiftStack();
        return stackOut.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        shiftStack();
        return stackOut.peek();
        
    }
    
    public void shiftStack() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}
