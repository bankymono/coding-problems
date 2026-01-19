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

        NewNode e = new NewNode(11);
        NewNode f = new NewNode(14);
        NewNode g = new NewNode(19);
        NewNode h = new NewNode(21);
        NewNode i = new NewNode(18);
        NewNode j = new NewNode(17);
        NewNode k = new NewNode(50);

        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        j.next = k;
        printList(a);
        System.out.println();
//        System.out.println(linkedListValues(a));
//        System.out.println(sumList(a));
//        System.out.println(linkedListFind(a,5));
//        System.out.println(getNodeValue(a,0));
//        NewNode rev = reverseList(a);
        NewNode rev2 = zipList(a,e);
        printList(rev2);
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

    public static NewNode zipList(NewNode head1, NewNode head2) {

        if(head1 == null) return head2;
        if(head2 == null) return head1;

        NewNode curr1 = head1;
        NewNode curr2 = head2;


        while(curr1 != null && curr2 != null) {
            NewNode next1 = curr1.next;
            NewNode next2 = curr2.next;

            curr1.next = curr2;

            if(next1 == null) break;

            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }

        return head1;
    }

}
