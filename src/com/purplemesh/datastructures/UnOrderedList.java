package com.purplemesh.datastructures;

import java.io.*;
import java.util.Scanner;

import com.purplemesh.utility.Utility;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    private Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    public boolean removeNode(T data) {
        Node<T> current = head, prev = null;

        while (current != null) {
            if (current.data.toString().equalsIgnoreCase(data.toString())) {
                if (prev == null) {
                    head = current.next; 
                } else {
                    prev.next = current.next; 
                }
                return true; 
            }
            prev = current;
            current = current.next;
        }
        return false; 
    }
   
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Node<T> temp = head;
            while (temp != null) {
                writer.write(temp.data.toString());
                writer.newLine();
                temp = temp.next;
            }
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
    
    public void searchAndModify(T data) {
        if (removeNode(data)) {
            System.out.println(data + " is existing word in file, removed: " + data);
        } else {
            // Word not found, add to front
            Node<T> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            System.out.println(data + " is a new word, so added: " + data);
        }
    }

    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class UnOrderedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        String inputFile = "D://filestore//update.txt";

        try (Scanner scanner=new Scanner(new File(inputFile))) {
            while (scanner.hasNextLine()) {
                String line =scanner.nextLine();
                String[] words = line.split("\\s+|,");
                for (String word : words) {
                    if (!word.isBlank()) {
                        list.add(word.trim());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
            return;
        }

        System.out.println("Initial List:");
        list.display();

        
        while (true) {
            System.out.println("Enter the word to search: ");
            String wordToSearch =Utility.getString().trim();

            if (wordToSearch.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            list.searchAndModify(wordToSearch);

            System.out.println("Updated List:");
            list.display();
            list.saveToFile(inputFile);
            System.out.println("Changes saved to file.\n");
        }
    }
}
