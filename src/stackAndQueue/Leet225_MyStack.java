package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 */
public class Leet225_MyStack {
    Queue<Integer> a; //入队列
    Queue<Integer> b; //出队列
    /** Initialize your data structure here. */
    public Leet225_MyStack() {
        // linkedList -> Deque -> Queue
        // arrayDeque ->
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        a.offer(x);
        while (!b.isEmpty()){
            a.offer(b.poll());
        }
        //a队列在没有push的时候始终为空队列
        Queue temp = a;
        a = b;
        b= temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return b.poll();
    }

    /** Get the top element. */
    public int top() {
        return b.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return b.isEmpty();
    }
}

