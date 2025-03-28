package com.bridgelabz.queueInterface;
import java.util.*;

public class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        if(queue1.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        while(queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.poll();

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public int top() {
        if(queue1.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        while(queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int topElement = queue1.poll();
        queue2.add(topElement);

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top()); //3

        System.out.println(stack.pop()); //3

        System.out.println(stack.top()); //2
    }
}
