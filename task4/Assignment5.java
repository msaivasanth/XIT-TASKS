// Move all zeros in a number to the end using a linked list(Ex: 1034035 ---> 1343500)

import java.util.*;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
class LinkedList {
    Node head;
    public void insert(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        }

        else {
            Node temp = head;

            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void moveZerosToEnd() {
        // System.out.println("Start.....");
        Node dummyNode1 = new Node(-1);
        Node dummyNode2 = new Node(-1);

        Node temp1 = dummyNode1;
        Node temp2 = dummyNode2;

        Node temp = head;

        while(temp != null) {
            // System.out.println("Inside the loop");
            if(temp.data != 0) {
                temp1.next = temp;
                temp1 = temp1.next;
            }
            else {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp1.next = dummyNode2.next;
        temp2.next = null;


        // ls.head = dummyNode1;

        // System.out.println("End....");
    }

    public void printList() {
        Node temp = head;

        System.out.print("Printing the elements of linked list: ");
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Assignment5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        LinkedList lis = new LinkedList();

        for(int i = 0; i < n; i++) {
            int val = s.nextInt();
            lis.insert(val);
        }

        lis.printList();
        // LinkedList res = new LinkedList();

        lis.moveZerosToEnd();

        lis.printList();
    }
}
