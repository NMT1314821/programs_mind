package com.purplemesh.datastructures;

import java.io.*;
import java.util.Scanner;

class OrderedLinkedList<T extends Comparable<T>> {
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null || head.data.compareTo(value) >= 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node<T> current = head;
        while (current.next != null && current.next.data.compareTo(value) < 0) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public boolean remove(T value) {
        if (head == null) return false;

        if (head.data.compareTo(value) == 0) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        while (current.next != null && current.next.data.compareTo(value) != 0) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;

        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }

        return sb.toString().trim();
    }
}

public class OrderedList {
    public static void main(String[] args) {
        String inputFile = "D://filestore//numbers.txt"; 
        OrderedLinkedList<Integer> list = new OrderedLinkedList<>();
        try (Scanner fileScanner = new Scanner(new File(inputFile))) {
            while (fileScanner.hasNextInt()) {
                list.insert(fileScanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with an empty list.");
        }

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nCurrent Ordered List:");
            System.out.println(list);

            System.out.println("Enter a number: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
                continue;
            }

            int userNumber = input.nextInt();

            if (list.remove(userNumber)) {
                System.out.println(userNumber + " was found and removed from the list.");
            } else {
                list.insert(userNumber);
                System.out.println(userNumber + " was not found and has been inserted.");
            }

            
            try (PrintWriter writer = new PrintWriter(new FileWriter(inputFile))) {
                writer.println(list);
                System.out.println("List updated and saved to file.");
            } catch (IOException e) {
                System.out.println("Error writing to the file.");
            }
        }
    }
}
