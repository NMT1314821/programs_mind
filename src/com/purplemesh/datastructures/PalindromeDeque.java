package com.purplemesh.datastructures;

//Node class for doubly linked list
class DequeNode<T> {
    T data;
    DequeNode<T> next;
    DequeNode<T> prev;

    DequeNode(T data) {
        this.data = data;
    }
}

//Custom generic Deque implementation
class CustomDeque<T> {
    private DequeNode<T> front;
    private DequeNode<T> rear;

    public void addRear(T data) {
        DequeNode<T> newNode = new DequeNode<>(data);
     if (rear == null) {
         front = rear = newNode;
     } else {
         rear.next = newNode;
         newNode.prev = rear;
         rear = newNode;
     }
 }

 public T removeFront() {
     if (front == null) throw new RuntimeException("Deque is empty");
     T data = front.data;
     front = front.next;
     if (front != null) front.prev = null;
     else rear = null;
     return data;
 }

 public T removeRear() {
     if (rear == null) throw new RuntimeException("Deque is empty");
     T data = rear.data;
     rear = rear.prev;
     if (rear != null) rear.next = null;
     else front = null;
     return data;
 }

 public boolean isEmpty() {
     return front == null;
 }

 public int size() {
	    int count = 0;
	    DequeNode<T> temp = front;
	    while (temp != null) {
	        count++;
	        temp = temp.next;
	    }
	    return count;
	}
}
public class PalindromeDeque {

    public static boolean isPalindrome(String input) {
        CustomDeque<Character> deque = new CustomDeque<>();
        input = input.toLowerCase();

        for (char c : input.toCharArray()) {
            deque.addRear(c);
        }

        while (deque.size() > 1) {
            char front = deque.removeFront();
            char rear = deque.removeRear();
            if (front != rear) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String test1 = "radar";  
        System.out.println(test1 + " → " + isPalindrome(test1)); // true
        
    }
}



