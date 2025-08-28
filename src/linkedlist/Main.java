package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.display();

        list.insertV2(1900, 2);
        list.display();
        list.deleteFirst();
        list.display();
    }
}
