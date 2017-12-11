import java.util.Stack;

class MaxStack {
    private Stack<Integer> stack, max;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        max = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (max.isEmpty() || max.peek() <= x)
            max.push(x);
        System.out.println("stack:" + stack);
        System.out.println("max:" + max);
    }

    public int pop() {
        int p = stack.pop();
        if (p == max.peek())
            max.pop();
        return p;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return max.peek();
    }

    public int popMax() {
        int m = max.pop();
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            Integer i = stack.pop();
            if (i.intValue() == m)
                break;
            else
                temp.push(i);
        }
        while (!temp.isEmpty()) {
            this.push(temp.pop());// key
        }

        return m;
    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(5);
        System.out.println(obj.top());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}