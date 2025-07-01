package com.purplemesh.datastructures;

import com.purplemesh.utility.Utility;

//Custom generic Node class
class QueueNode<T> {
    T data;
    QueueNode<T> next;

    public QueueNode(T data) {
        this.data = data;
        this.next = null;
    }
}

//Custom generic Queue implementation
class CustomQueue<T> {
    private QueueNode<T> front, rear;

    public void enqueue(T data) {
        QueueNode<T> newNode = new QueueNode<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (front == null) throw new RuntimeException("Queue is empty!");
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

class Person {
    String name;
    String transactionType;
    int amount;

    public Person(String name, String transactionType, int amount) {
        this.name = name;
        this.transactionType = transactionType.toLowerCase();
        this.amount = amount;
    }
}

class CashCounter {
    private CustomQueue<Person> queue = new CustomQueue<>();
    private int cashBalance;

    public CashCounter(int initialBalance) {
        this.cashBalance = initialBalance;
    }

    public void addCustomer(Person person) {
        queue.enqueue(person);
        System.out.println("Added: " + person.name + " for " + person.transactionType + " ₹" + person.amount);
    }

    public void processNextCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers to process.");
            return;
        }

        Person p = queue.dequeue();
        if (p.transactionType.equals("deposit")) {
            cashBalance += p.amount;
            System.out.println(p.name + " deposited " + p.amount + ". Balance: " + cashBalance);
        } else if (p.transactionType.equals("withdraw")) {
            if (cashBalance >= p.amount) {
                cashBalance -= p.amount;
                System.out.println(p.name + " withdrew " + p.amount + ". Balance: " + cashBalance);
            } else {
                System.out.println("Insufficient funds for " + p.name);
            }
        } else {
            System.out.println("Invalid transaction.");
        }
    }

    public void displayBalance() {
        System.out.println("Current Cash Balance: " + cashBalance);
    }
}

public class BankingCash {
    public static void main(String[] args) {
       
        CashCounter counter = new CashCounter(10000);

        while (true) {
            System.out.println("\nChoose an option:\n1. Add customer\n2. Process transaction\n3. Show balance\n4. Exit");
            int choice = Utility.number();
            Utility.getString(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = Utility.getString();
                    System.out.print("Transaction type (deposit/withdraw): ");
                    String type = Utility.getString().toLowerCase();
                    System.out.print("Enter amount: ");
                    int amount = Utility.number();
                    Utility.getString();// consume newline
                    counter.addCustomer(new Person(name, type, amount));
                    break;

                case 2:
                    counter.processNextCustomer();
                    break;

                case 3:
                    counter.displayBalance();
                    break;

                case 4:
                    System.out.println("Thanks for banking with us!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}



