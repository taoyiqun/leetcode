package leetcode_155;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = null;
    private Stack<Integer> helpStack = null;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(int x) {
        if(helpStack.empty()){
            helpStack.push(x);
        }else if(helpStack.peek() >= x){
            helpStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(helpStack.size() != 0 && stack.size() != 0){
            if(helpStack.peek().equals(stack.peek())){
                helpStack.pop();
                stack.pop();
            }else {
                stack.pop();
            }
        }
    }

    public Integer top() {
        if(stack.size() != 0){
            return stack.peek();
        }else {
            return null;
        }
    }

    public Integer getMin() {
        if(helpStack.size() != 0){
            return helpStack.peek();
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
    }
}
