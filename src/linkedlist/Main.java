package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(7);
        list.display();

        list.insertV2(1900, 2);
        list.display();
//        list.deleteFirst();
//        list.display();
//        list.deleteLast();
//        list.display();
        list.insertRec(8,3);
        list.display();

//        DLL list = new DLL();
//        list.insertFirst(3);
//        list.insertFirst(4);
//        list.insertFirst(5);
//        list.insertFirst(7);
//        list.insertLast(79);
//        list.insert(5,12);

//        list.display();

//        CLL list  = new CLL();
//        list.insert(23);
//        list.insert(3);
//        list.insert(19);
//        list.insert(75);
//        list.display();
//
//        list.delete(3);
//        list.display();
    }


}
