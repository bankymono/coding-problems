package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NewNode a = new NewNode(2);
        NewNode b = new NewNode(4);
        NewNode c = new NewNode(9);
        NewNode d = new NewNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        printList(a);
        System.out.println();
//        System.out.println(linkedListValues(a));
//        System.out.println(sumList(a));
//        System.out.println(linkedListFind(a,5));
//        System.out.println(getNodeValue(a,0));
        NewNode rev = reverseList(a);
        printList(rev);
    }

    public static void printList(NewNode head) {
        NewNode current = head;

        while(current != null) {
            System.out.print(current.val2 + " -> ");
            current = current.next;
        }
    }

    public static List<Character> linkedListValues(NewNode head){
        List<Character> list = new ArrayList<>();
        NewNode current = head;
        while(current != null){
            list.add(current.data);
            current = current.next;
        }

        return list;
    }

    public static int sumList(NewNode head) {
        NewNode current = head;
        int sum = 0;
        while(current != null) {
            sum += current.val2;
            current = current.next;
        }
        return sum;
    }

    public static boolean linkedListFind(NewNode head, int val) {
        NewNode current = head;

        while (current != null) {
            if(current.val2 == val) return true;
            current = current.next;
        }

        return false;
    }

    public static Integer getNodeValue(NewNode head, int index) {
        if(head == null) return  null;
        NewNode currentNode = head;
        int counter = 0;

        while(currentNode != null) {
            if(counter == index) return currentNode.val2;
            counter++;
            currentNode = currentNode.next;
        }

        return null;
    }


    public static NewNode reverseList(NewNode head) {
        NewNode prev = null;
        NewNode current = head;
        while (current != null) {
            NewNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return  prev;
    }

}
