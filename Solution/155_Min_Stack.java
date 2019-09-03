/**
 https://leetcode.com/problems/min-stack/
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        getMin() -- Retrieve the minimum element in the stack.
Example:
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   --> Returns -3.
        minStack.pop();
        minStack.top();      --> Returns 0.
        minStack.getMin();   --> Returns -2.

Input Format:
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]
*/

时间 O （n）
空间 O （n）
//initialize stack of int use Stack<Integer> cur = new Stack<>();
//stack has push peek pop and isEmpty function. need to do null check

class MinStack {
    Stack<Integer> cur = new Stack<>();
    Stack<Integer> min = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        cur.push(x);
        if(min.isEmpty() || min.peek() >= x){
            min.push(x);
        }
    }

    public void pop() {
        if(!cur.isEmpty()){
            int k = cur.pop();
            if(!min.isEmpty() && k == min.peek()){
                min.pop();
            }
        }
    }

    public int top() {
        if(!cur.isEmpty()){
            return cur.peek();
        }
        return 0;

    }

    public int getMin() {
        if(!min.isEmpty()){
            return min.peek();
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

