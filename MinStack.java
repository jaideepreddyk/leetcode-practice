import java.util.Stack;

public class MinStack{
    Stack<Integer> arr;
    Stack<Integer> minValues;
    public MinStack() {
        this.arr = new Stack<>();
        this.minValues = new Stack<>();
    }
    
    public void push(int val) {
        this.arr.push(val);
        if(this.minValues.size()==0) minValues.push(val);
        else this.minValues.push(Math.min(minValues.peek(), val));
    }
    
    public void pop() {
        this.arr.pop();
        this.minValues.pop();
    }
    
    public int top() {
        return this.arr.peek();
    }
    
    public int getMin() {
        return this.minValues.peek();
    }
}
