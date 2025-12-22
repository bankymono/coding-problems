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
        System.out.println(sumList(a));
    }

    public static void printList(NewNode head) {
        NewNode current = head;

        while(current != null) {
            System.out.print(current.data + " -> ");
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

}
