package com.purplemesh.datastructures;

import java.util.ArrayList;
import java.util.List;

class MyNode<T> {
    T data;
    MyNode<T> next;

    public MyNode(T data) {
        this.data = data;
    }
}

class MyStack<T> {
    private MyNode<T> top;

    public void push(T data) {
        MyNode<T> newNode = new MyNode<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot pop from an empty stack.");
        }
        T value = top.data;
        top = top.next;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class PrimeUtils {

    public static boolean isPrime(int num)
    {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) 
        {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean areAnagrams(int a, int b) 
    {
        int[] count = new int[10];

        while (a > 0)
        {
            count[a % 10]++;
            a /= 10;
        }
        while (b > 0)
        {
            count[b % 10]--;
            b /= 10;
        }

        for (int c : count) 
        {
            if (c != 0) return false;
        }
        return true;
    }
}

public class PrimeStack 
{

    public static void main(String[] args)
    {
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < 1000; i++) {
            if (PrimeUtils.isPrime(i)) {
                primes.add(i);
            }
        }

        MyStack<Integer> stack = new MyStack<>();
        boolean[] visited = new boolean[primes.size()];

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (PrimeUtils.areAnagrams(primes.get(i), primes.get(j))) {
                    if (!visited[i]) {
                        stack.push(primes.get(i));
                        visited[i] = true;
                    }
                    if (!visited[j]) {
                        stack.push(primes.get(j));
                        visited[j] = true;
                    }
                }
            }
        }

        System.out.println("Prime Anagrams in Reverse Order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
