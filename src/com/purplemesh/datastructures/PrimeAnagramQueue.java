package com.purplemesh.datastructures;

class PrimeQueue<T> {
    private Node<T> front;
    private Node<T> rear;

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (rear == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue empty");
        }
        T val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void print() {
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class PrimeAnagramQueue {

    public static void main(String[] args) {
        int[] primes = new int[168];
        int size = 0;
        
        for (int i = 2; i < 1000; i++) {
            if (PrimeUtils.isPrime(i)) {
                primes[size++] = i;
            }
        }

        boolean[] visited = new boolean[size];
        PrimeQueue<Integer> queue = new PrimeQueue<>();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (PrimeUtils.areAnagrams(primes[i], primes[j])) {
                    if (!visited[i]) {
                        queue.add(primes[i]);
                        visited[i] = true;
                    }
                    if (!visited[j]) {
                        queue.add(primes[j]);
                        visited[j] = true;
                    }
                }
            }
        }

        System.out.println("Prime Anagrams in Queue:");
        queue.print();
    }
}
