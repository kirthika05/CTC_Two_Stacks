package com.kirthika;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) {
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) {
                queue.dequeue();
            } else if (operation == 3) {
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<T>{

    Stack<T> newStack;
    Stack<T> oldStack;

    public MyQueue(){
        newStack = new Stack<T>();
        oldStack = new Stack<T>();
    }

    public void enqueue(T value) {
        newStack.push(value);
    }

    public T peek() {
        prepOld();
        return oldStack.peek();
    }

    public T dequeue() {

        prepOld();
        return oldStack.pop();

    }

    public void prepOld(){
        if (oldStack.isEmpty())
            while(!newStack.isEmpty())
                oldStack.push(newStack.pop());
    }
}