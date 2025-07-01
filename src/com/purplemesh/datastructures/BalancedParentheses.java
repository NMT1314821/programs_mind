package com.purplemesh.datastructures;

import java.util.Scanner;

import com.purplemesh.utility.Utility;

//Generic Stack class
class Stack<T> {
 private Object[] elements;
 private int top;
 private int capacity;

 public Stack(int size) {
     capacity = size;
     elements = new Object[capacity];
     top = -1;
 }

 public void push(T item) {
     if (top == capacity - 1) {
         System.out.println("Stack Overflow");
         return;
     }
     elements[++top] = item;
 }

 @SuppressWarnings("unchecked")
 public T pop() {
     if (isEmpty()) {
         return null;  // Return null if stack is empty
     }
     return (T) elements[top--];
 }

 @SuppressWarnings("unchecked")
 public T peek() {
     if (isEmpty()) {
         return null;
     }
     return (T) elements[top];
 }

 public boolean isEmpty() {
     return top == -1;
 }

 public int size() {
     return top + 1;
 }
}

public class BalancedParentheses {

 public static boolean isBalanced(String expression) {
     Stack<Character> stack = new Stack<>(expression.length());

     for (int i = 0; i < expression.length(); i++) {
         char ch = expression.charAt(i);

         if (ch == '(') {
             stack.push(ch);
         } else if (ch == ')') {
             if (stack.isEmpty()) {
                 return false;
             }
             stack.pop();
         }
     }
     return stack.isEmpty();
 }

 public static void main(String[] args) 
 {
	 
     System.out.println("Enter an arithmetic expression:");
     String expression =Utility.getString();

     boolean result = isBalanced(expression);

     if (result) {
         System.out.println("True -> The arithmetic expression is balanced.");
     } else {
         System.out.println("False -> The arithmetic expression is NOT balanced.");
     }
  }
}
